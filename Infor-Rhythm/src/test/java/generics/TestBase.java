//Package information.
package generics;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.SkipException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by ${mkhan2} on ${10/27/2014}.
 */


public class TestBase {

    // Initialize the WedDriver as static.
    public WebDriver driver;

    //Initialize the Property file as static.
    public static Properties prop;

    //Initialize the variable for browser = if browser is open it will prevent to open same browser again.
    public static boolean isBrowserOpened = false;

    //Initialize the Log file for entire project.
    public static Logger log = Logger.getLogger("devpinoyLogger");

    //--*******-- Browserstack information --******--//

    //Initialize user name on Browserstack
    public static final String USERNAME = "mamunkhan1";

    //Initialize automated key for Browserstack
    public static final String AUTOMATE_KEY = "kbwsyczq4yoCbwUTxbBb";

    //Initialize url and username and automate key for Browserstack
    public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";


    //Function for Initialization the Property file.
    public static void init() {

        //Condition for property file.
        if (prop == null) {

            //Configure the location of property file.
            String path = System.getProperty("user.dir") + "/src/test/resources/project.properties";

            //Initialize the property file.
            prop = new Properties();

            //Initialize the try catch block.
            try {

                //Initialize file to FileInputStream.
                FileInputStream fs = new FileInputStream(path);

                //Load property file.
                prop.load(fs);

                //If file is not present, then control will come to catch block.
            } catch (Exception e) {

                //Log information.
                log.error("There is no Property file on this location == " + path);

                //Printing server error information.
                e.printStackTrace();
            }
        }
    }


    // Function for validate the run mode suite level, test case level and browser level.
    public void validateRunmodes(String testName, String suiteName, String dataRunmode) {

        //Log information.
        log.info("Validating runmode for " + testName + " in suite " + suiteName);

        //Validate the Suite.xlsx run mode for Suite level.
        boolean suiteRunmode = RunModeConfiguration.isSuiteRunnable(suiteName, new Xlsx_Reader(System.getProperty("user.dir") + prop.getProperty("xlsFileLocation") + "Suite.xlsx"));

        //Validate run mode for Suite test case level.
        boolean testRunmode = RunModeConfiguration.isTestCaseRunnable(testName, new Xlsx_Reader(System.getProperty("user.dir") + prop.getProperty("xlsFileLocation") + suiteName + ".xlsx"));

        //Validate run mode for Browser level.
        boolean dataSetRunmode = false;

       //Validate run mode for Browser level.
        if (dataRunmode.equals(Constants.RUNMODE_YES))
            dataSetRunmode = true;

        //Validate run mode for Browser level.
        if (!(suiteRunmode && testRunmode && dataSetRunmode)) {

            //Log information.
            log.info("Skipping the test " + testName + " inside the suite " + suiteName);

            //Skip Information fo any level.
            throw new SkipException("Skipping the test " + testName + " inside the suite " + suiteName);

        }

    }


    // Function for Selenium Grid connection.
    public void testGrid(String browserName) {

        try {
            //Initialize the desired capabilities.
            DesiredCapabilities cap = new DesiredCapabilities();

            //Check the condition for browser open or not.
            //if (!isBrowserOpened)

                //Setting for Firefox browser.
                if (browserName.equalsIgnoreCase("firefox")) {

                    //Log information.
                    log.info("Grid Firefox browser Open");

                    //Set Firefox browser.
                    cap = DesiredCapabilities.firefox();

                    //Set browser name Firefox.
                    cap.setBrowserName("firefox");

                    //Set platform for Browser.
                    cap.setPlatform(org.openqa.selenium.Platform.MAC);

                    //Setting for Chrome browser.
                } else if (browserName.equalsIgnoreCase("chrome")) {

                    //Log information.
                    log.info("Grid Chrome browser Open");

                    //Set Chrome to Desired capabilities.
                    cap = DesiredCapabilities.chrome();

                    //Set Chrome Browser.
                    cap.setBrowserName("chrome");

                    //Set Platform for Browser.
                    cap.setPlatform(org.openqa.selenium.Platform.MAC);

                    //Setting for Safari browser.
                } else if (browserName.equalsIgnoreCase("safari")) {

                    //Log information.
                    log.info("Grid Safari browser Open");

                    //Set Desired Capabilities for Browser.
                    cap = DesiredCapabilities.safari();

                    //Set Browser Nme.
                    cap.setBrowserName("safari");

                    //Set Browser platform.
                    cap.setPlatform(org.openqa.selenium.Platform.MAC);

                    //Setting for Internet Explorer browser.
                } else if (browserName.equalsIgnoreCase("IE")) {

                    //Log information.
                    log.info("Grid Internet Explorer browser Open");

                    //Set Desired Capabilities for Browser.
                    cap = DesiredCapabilities.internetExplorer();

                    //Set Browser name.
                    cap.setBrowserName("IE");

                    //Set Platform name for browser.
                    cap.setPlatform(Platform.WINDOWS);
                }

            try {
                //Initialize the Infro Remote selenium grid address
                driver = new RemoteWebDriver(new URL("http://usmawsoab.rhythm.com:4444/wd/hub"), cap);


                //Initialize the local Remote selenium grid address
                //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);


                //This setting for My Mac
                //driver = new RemoteWebDriver(new URL("http://10.0.1.5:4444/wd/hub"), cap);


                //If browser is not present, then control will come to catch block.
            } catch (MalformedURLException e) {

                //Print server generate log information.
                e.printStackTrace();
            }


            //Open browser as maximize mode.
            driver.manage().window().maximize();

            //Initialize the global time out for entire project -- This line of code will wait 20 second for finding any  web elements.
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            //If browser is not present, then control will come to catch block.
        } catch (Exception e) {

            //Log information.
            log.error("Not able to open browser -  -- " + browserName);

            //TestNG Assertion for fail this function.
            Assert.fail(e.getMessage());

        }

    }


    //Function for run test on the Browser Stack
    public void browserStack(String browserName) {

        try {

            //Initialize the desired capabilities.
            DesiredCapabilities caps = new DesiredCapabilities();

            //Check the condition for browser open or not.
            if (!isBrowserOpened)

                //Setting for Firefox browser.
                if (browserName.equalsIgnoreCase("firefox")) {

                    //Log information.
                    log.info("Browser Stack Open Firefox");

                    //Set capability for Browser name.
                    caps.setCapability("browser", "Firefox");

                    //Set capability for Browser version.
                    caps.setCapability("browser_version", "32.0");

                    //Set capability for Browser platform.
                    caps.setCapability("os", "Windows");

                    //Set capability for OS Version.
                    caps.setCapability("os_version", "8.1");

                    //Set capability for Screen size.
                    caps.setCapability("resolution", "2048x1536");

                    //Setting for Chrome browser.
                } else if (browserName.equalsIgnoreCase("chrome")) {

                    //Log information.
                    log.info("Browser Stack Open Chrome");

                    //Set capability for Browser Name.
                    caps.setCapability("browser", "Chrome");

                    //Set capability for Browser version.
                    caps.setCapability("browser_version", "38.0");

                    //Set capability for Browser OS.
                    caps.setCapability("os", "Windows");

                    //Set capability for OS Version.
                    caps.setCapability("os_version", "8.1");

                    //Set capability for Screen size.
                    caps.setCapability("resolution", "2048x1536");

                    //Setting for Safari browser.
                } else if (browserName.equalsIgnoreCase("safari")) {

                    //Log information.
                    log.info("Browser Stack Open Safari");

                    //Set capability for Browser name.
                    caps.setCapability("browser", "Safari");

                    //Set capability for Browser version.
                    caps.setCapability("browser_version", "7.0");

                    //Set capability for Browser OS.
                    caps.setCapability("os", "OS X");

                    //Set capability for Browser OS Version.
                    caps.setCapability("os_version", "Mavericks");

                    //Set capability for Browser Screen size.
                    caps.setCapability("resolution", "1920x1080");

                    //Setting for Internet Explorer.
                } else if (browserName.equalsIgnoreCase("IE")) {

                    //Log information.
                    log.info("Browser Stack Open Internet Explorer");

                    //Set capability for Browser name.
                    caps.setCapability("browser", "IE");

                    //Set capability for Browser version.
                    caps.setCapability("browser_version", "11");

                    //Set capability for Browse OS.
                    caps.setCapability("os", "Windows");

                    //Set capability for Browse OS Version.
                    caps.setCapability("os_version", "8.1");

                    //Set capability for Browse  size.
                    caps.setCapability("resolution", "2048x1536");

                }

            try {

                //Initialize the Browser stack Remote address
                driver = new RemoteWebDriver(new URL(URL), caps);

                //If browser is not present, then control will come to catch block.
            } catch (MalformedURLException e) {

                //Print server generate log information.
                e.printStackTrace();
            }

            //Variable returning true.
            isBrowserOpened = true;

            //Open browser as maximize mode
            driver.manage().window().maximize();

            //Initialize the global time out for entire project -- This line of code will wait 20 second for finding any  web elements.
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            //If browser is not present, then control will come to catch block.
        } catch (Exception e) {

            //Initialize the log file
            log.info("Not able to open browser -  -- " + browserName);

            //Initialize the TestNG fail Assertion.
            Assert.fail(e.getMessage());
        }

    }


    //Function for run test on local browser.
    public void testLocal(String browserName) {

        try {

                //Setting for Chrome browser
                if (browserName.equalsIgnoreCase("chrome")) {

                    //Log information.
                    log.info("Open Browser -- Chrome");

                    //Configure the Chrome driver with Selenium WebDriver and location of Chrome driver.
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + prop.getProperty("ChromeDriver"));

                    //Initialize the  Chrome browser.
                    driver = new ChromeDriver();

                    //Setting for Safari browser---It will work only on MAC Not In Window base computer
                } else if (browserName.equalsIgnoreCase("safari")) {

                    //Log information.
                    log.info("Open Browser -- Safari");

                    //Initialize the  Chrome browser.
                    driver = new SafariDriver();

                    //Setting for Firefox browser.
                } else if (browserName.equalsIgnoreCase("firefox")) {

                    //Log information.
                    log.info("Open Browser -- Firefox");

                    //Initialize the Firefox browser.
                    driver = new FirefoxDriver();
                }

            //Open browser as maximize mode
            driver.manage().window().maximize();

            //Initialize the global time out for entire project -- This line of code will wait 20 second for finding any  web elements.
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            //If browser is not present, then control will come to catch block.
        } catch (Exception e) {

            //log information
            log.error("Not able to open browser -  " + browserName);

            //Initialize the TestNG assertion.
            Assert.fail(e.getMessage());

        }

    }


    //Function for quite the browser.
    public void closeBrowser() {

        //Condition for if Browser does not have any job.
        if(driver != null) {

            //Quit the browser.
            driver.quit();

            //Log information.
            log.info("Close Browser");

            driver=null;
        }

    }

    //Function for navigate the URL.
    public void navigate(String URLKey) {

        try {

            //Initialize the driver and navigate the URL.
            driver.navigate().to(prop.getProperty(URLKey));

            //Log information.
            log.info("Navigate to the URL --- " + URLKey);

            //If URL is not present, then control will come to catch block.
        } catch (Exception e) {

            //Log information.
            log.error("Not valid URL --- " + URLKey);

            //TestNG Assertion, if element is not present then test case will fail.
            Assert.fail(e.getMessage());

        }

    }

    // Function for navigate back.
    public void navigateBack() {

        //Selenium command for Browser get back to the previous session.
        driver.navigate().back();

        log.info("Navigate back to the Browser");
    }


    //Function for click on elements.
    public void click(String identifier) {

        try {

            //Click on xpath element.
            if (identifier.endsWith("_xpath")) {

                //Find Web element by xpath.
                driver.findElement(By.xpath(prop.getProperty(identifier))).click();

                //Log information.
                log.info("Click on --- " + identifier);

                //Click on ID element.
            } else if (identifier.endsWith("_id")) {

                //Find Web element by ID.
                driver.findElement(By.id(prop.getProperty(identifier))).click();

                //Log information.
                log.info("Click on --- " + identifier);

                //Click on Name Element.
            } else if (identifier.endsWith("_name")) {

                //Find Web element by Name.
                driver.findElement(By.name(prop.getProperty(identifier))).click();

                //Log information.
                log.info("Click on --- " + identifier);

                //Click on Css element.
            } else if (identifier.endsWith("_css")) {

                //Find Web element by CSS.
                driver.findElement(By.cssSelector(prop.getProperty(identifier))).click();

                //Log Information.
                log.info("Click on --- " + identifier);
            }else if (identifier.endsWith("_class")) {

                //Find Web element by CSS.
                driver.findElement(By.className(prop.getProperty(identifier))).click();

                //Log Information.
                log.info("Click on --- " + identifier);
            }

            //If identifier is not present, then control will come to catch block.
        } catch (NoSuchElementException e) {

            //Log information.
            log.error("Element not found --- " + identifier);

            //TestNG Assertion fail.
            Assert.fail(e.getMessage());

        }

    }


    //Function for Input data to the input box.
    public void input(String identifier, String data) {

        try {

            //Input data to web element by xpath.
            if (identifier.endsWith("_xpath")) {

                //Clear the input box
                driver.findElement(By.xpath(prop.getProperty(identifier))).clear();

                //Input date to input box web element by xpath.
                driver.findElement(By.xpath(prop.getProperty(identifier))).sendKeys(data);

                //Log information.
                log.info("Input ---- "+data);

                //Input data to web element by ID.
            } else if (identifier.endsWith("_id")) {

                //Clear the input box
                driver.findElement(By.id(prop.getProperty(identifier))).clear();

                //Input date to input box web element by ID.
                driver.findElement(By.id(prop.getProperty(identifier))).sendKeys(data);

                //Log information.
                log.info("Input ---- "+data);

                //Input data to web element by Name.
            } else if (identifier.endsWith("_name")) {

                //Clear the input box
                driver.findElement(By.xpath(prop.getProperty(identifier))).clear();

                //Input date to input box web element by Name.
                driver.findElement(By.name(prop.getProperty(identifier))).sendKeys(data);

                //Log information.
                log.info("Input ---- "+data);

                //Input data to web element by CSS.
            } else if (identifier.endsWith("_css")) {

                //Clear the input box
                driver.findElement(By.cssSelector(prop.getProperty(identifier))).clear();

                //Input date to input box web element by CSS.
                driver.findElement(By.cssSelector(prop.getProperty(identifier))).sendKeys(data);

                //Log information.
                log.info("Input ---- "+data);
            }

            //If identifier is not present then control will come to catch block.
        } catch (NoSuchElementException e) {

            //Log information.
            log.error("Element not found - " + identifier);

            //TestNG Assertion fail
            Assert.fail(e.getMessage());
        }
    }


    //Function for Verify elements preset of not.
    public boolean verifyTitle(String expectedTitleKey) {

        try {

            //Initialize  first Variable.
            String expectedTitle = prop.getProperty(expectedTitleKey);

            //Initialize second Variable.
            String actualTitle = driver.getTitle();

            //Log information.
            log.info("Verify Title --- "+expectedTitleKey);

            //Condition for first variable and second variable if both are same then return true.
            if (expectedTitle.equals(actualTitle))
                return true;

            //If identifier is not present then control will come to catch block.
        } catch (NoSuchElementException e) {

            //Log information.
            log.error("Title not matching ---- "+expectedTitleKey);

            //TestNg Assertion Fain if both variable are not same.
            Assert.fail(e.getMessage());
        }

        //Default statement return false.
        return false;
    }


    //Function for finding elements present or no present.
    public boolean isElementPresent(String identifier) {


        //Initialize the Integer for count the total elements.
        int size = 0;

        //Condition find element with xpath.
        if (identifier.endsWith("_xpath")) {

            //Get the size of Elements present inside the web page.
            size = driver.findElements(By.xpath(prop.getProperty(identifier))).size();

            //Log Information.
            log.info("Element Present --- "+identifier);
        }

        //Condition find element with ID.
        else if (identifier.endsWith("_id")) {

            //Get the size of Elements present inside the web page.
            size = driver.findElements(By.id(prop.getProperty(identifier))).size();

            //Log Information.
            log.info("Element Present --- "+identifier);
        }

        //Condition find element with Name.
        else if (identifier.endsWith("_name")) {

            //Get the size of Elements present inside the web page.
            size = driver.findElements(By.name(prop.getProperty(identifier))).size();

            //Log Information.
            log.info("Element Present --- "+identifier);
        }

        //Condition find element with CSS.
        else if (identifier.endsWith("_css")) {

            //Get the size of Elements present inside the web page.
            size = driver.findElements(By.cssSelector(prop.getProperty(identifier))).size();

            //Log Information
            log.info("Element Present --- "+identifier);
        }


        //Condition if there is element present or not.
        if (size > 0)

            //Returning True.
            return true;

            //Default result returning false.
        else

            //Returning False.
            return false;
    }


    // Function for return text.
    public String getText(String identifier) {

        try {

            //Initialize the String variable for as null.
            String text = null;

            //Conditional finding webElement by Xpath.
            if (identifier.endsWith("_xpath")) {

                //Returning text to text variable form webElement.
                text = driver.findElement(By.xpath(prop.getProperty(identifier))).getText();

                //Log Information.
                log.info("Get Text --- "+identifier);
            }

            //Conditional finding webElement by ID.
            else if (identifier.endsWith("_id")) {

                //Returning text to text variable form webElement.
                text = driver.findElement(By.id(prop.getProperty(identifier))).getText();

                //Log Information.
                log.info("Get Text --- "+identifier);
            }

            //Conditional finding webElement by ID.
            else if (identifier.endsWith("_name")) {

                //Returning text to text variable form webElement.
                text = driver.findElement(By.name(prop.getProperty(identifier))).getText();

                //Log Information.
                log.info("Get Text --- "+identifier);
            }

            //Conditional finding webElement by ID.
            else if (identifier.endsWith("_css")) {

                //Returning text to text variable form webElement.
                text = driver.findElement(By.cssSelector(prop.getProperty(identifier))).getText();

                //Log Information.
                log.info("Get Text --- "+identifier);
            }


            // Returning text to the text String variable.
            return text;


            //If identifier is not present, then control will come to catch block.
        } catch (NoSuchElementException e) {

            //Log information.
            log.error("Text is not Present --- " + identifier);

            //TestNG assertion fail
            Assert.fail(e.getMessage());
        }


        //Return default identifier.
        return identifier;

    }


    //Function for Selenium WebDriver to select elements form Dropdown list.
    public void selectDropdownList(String identifier, String selectOption) throws InterruptedException {

        try {

            //Initialize the WebElement.
            WebElement selectUserType = null;

            //Find the web element with xpath.
            if (identifier.endsWith("_xpath")) {
                selectUserType = driver.findElement(By.xpath(prop.getProperty(identifier)));
            }

            //Find the web element with ID.
            else if (identifier.endsWith("_id")) {
                selectUserType = driver.findElement(By.id(prop.getProperty(identifier)));
            }

            //Find the web element with Name.
            else if (identifier.endsWith("_name")) {
                selectUserType = driver.findElement(By.name(prop.getProperty(identifier)));
            }

            //Find the web element with cssSelector.
            else if (identifier.endsWith("_css")) {
                selectUserType = driver.findElement(By.cssSelector(prop.getProperty(identifier)));
            }

            //Initialize the Select
            Select selectUser = new Select(selectUserType);

            //Create a list of elements.
            List<WebElement> list = selectUser.getOptions();


            Thread.sleep(2000);

            //Loop throw all options.
            for (WebElement option : list) {

                //Condition if selectOption is equals to one of the looping option.
                if (option.getText().equals(selectOption)) {

                    //Log information.
                    log.info("Select dropdown list --- " + selectOption);

                    //Then click the matching option.
                    option.click();

                    //Stop the loop.
                    break;
                }
            }

            //If identifier is not present, then control will come to catch block.
        } catch (NoSuchElementException e) {

            //Log information.
            log.error("This --- "+selectOption+" Element is not present Select dropdown list");

            //TestNG assertion fail.
            Assert.fail(e.getMessage());


        }
    }


    //Function for Selenium  explicit wait.
    public void waitUntilForClick(String identifire) {

        try {

            //Initialize the wit to the selenium WebDriver.
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)

                    //Wait 10 Second.
                    .withTimeout(10, TimeUnit.SECONDS)

                            //Re-run every 2 Second.
                    .pollingEvery(2, TimeUnit.SECONDS)

                            //Ignoring the Exception.
                    .ignoring(NoSuchElementException.class);

            //Wait until the elements visible ot desire command like Click.
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty(identifire)))).click();

            //Log information.
            log.info("Click on --- "+identifire);

            //If identifier is not present, then control will come to catch block.
        } catch (NoSuchElementException e) {

            //Log information.
            log.error("Element is not present --- "+identifire);

            //TestNG assertion fail.
            Assert.fail(e.getMessage());
        }
    }


    //Function for take Screen short for any failure to the project.
    public void takeScreenShort(String testName) {

        // Log information.
        log.info("Screen Short for --- "+testName);

        // Initialize the driver and output file type.
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {

            //Initialize the file location, image name and file type.
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + prop.getProperty("ScreenShortLocation") + testName + ".png"));

        } catch (IOException e) {

            //Log information.
            log.error("Not able to take Screen Short for --- "+testName);

            //Printing server Stack Trace.

            Assert.fail(e.getMessage());
        }
    }


    //Function for Drag and Drop.
    public void dragAndDrop(String identifier, String dropPlace) throws InterruptedException {


        try {

            //Initialize the web element here.
            WebElement draggable = driver.findElement(By.xpath(prop.getProperty(identifier)));

            log.info("Drag element from --- "+identifier);

            //Initialize the web element here.
            WebElement droppable = driver.findElement(By.xpath(prop.getProperty(dropPlace)));

            log.info("Drop element into --- "+dropPlace);

            //Initialize the Action class here.
            Actions action = new Actions(driver);

            //Wait 3 seconds here.
            Thread.sleep(3000);

            //Drop element from one place to another place.
            action.dragAndDrop(draggable, droppable).perform();

        } catch (NoSuchElementException e){

            log.error("Not able to Drag and Drop from --- "+identifier+" to "+dropPlace);

            Assert.fail(e.getMessage());
        }


    }

    //Function for return list of Web Elements
    public List<WebElement> listOfElements(String identifier) {

        List<WebElement> elements = null;

        try {

            elements = null;

            //Find the web element with xpath.
            if (identifier.endsWith("_xpath")) {
                elements = driver.findElements(By.xpath(prop.getProperty(identifier)));
                log.info("Get list of elements for --- "+identifier);
            }

            //Find the web element with ID.
            else if (identifier.endsWith("_id")) {
                elements = driver.findElements(By.id(prop.getProperty(identifier)));
                log.info("Get list of elements for --- "+identifier);
            }

            //Find the web element with Name.
            else if (identifier.endsWith("_name")) {
                elements = driver.findElements(By.name(prop.getProperty(identifier)));
                log.info("Get list of elements for --- "+identifier);
            }

            //Find the web element with cssSelector.
            else if (identifier.endsWith("_css")) {
                elements = driver.findElements(By.cssSelector(prop.getProperty(identifier)));
                log.info("Get list of elements for --- "+identifier);
            }

            return elements;

        } catch (NoSuchElementException e) {

            //Log information.
            log.error("Element is not present ---" + identifier);

            //TestNG assertion fail.
            Assert.fail(e.getMessage());

        }

        return elements;
    }


    //Function for upload Image and files.
    public void uploadFile(String identifier, String location) {


        try {

            //Create web element.
            WebElement fileInput = null;

            //Find the web element with xpath.
            if (identifier.endsWith("_xpath")) {

                fileInput = driver.findElement(By.xpath(prop.getProperty(identifier)));

                //Log Information.
                log.info("Click on --- "+identifier);
            }

            //Find the web element with ID.
            else if (identifier.endsWith("_id")) {

                fileInput = driver.findElement(By.id(prop.getProperty(identifier)));

                //Log Information.
                log.info("Click on --- "+identifier);
            }

            //Find the web element with Name.
            else if (identifier.endsWith("_name")) {
                fileInput = driver.findElement(By.name(prop.getProperty(identifier)));
                //Log Information.
                log.info("Click on --- "+identifier);
            }

            //Find the web element with cssSelector.
            else if (identifier.endsWith("_css")) {
                fileInput = driver.findElement(By.cssSelector(prop.getProperty(identifier)));
                //Log Information.
                log.info("Click on --- "+identifier);
            }

            fileInput.sendKeys(System.getProperty("user.dir")+location);

            //Log Information.
            log.info("Upload file --- "+ location);

        }catch (NoSuchElementException e){
            //Log Information.
            log.info("Unable to locate or upload --- "+identifier);


            Assert.fail(e.getMessage());

        }


    }


    //Function for find links by text.
    public void linksValidateByText(String text){

        try {

            List<WebElement>list = driver.findElements(By.tagName("a"));

            //Loop throw all options.
            for (WebElement option : list) {

            //Condition if select Option is equals to one of the looping option.
            if (option.getText().equals(text)) {

                //Then click the matching option.
                option.click();
                //Log information.
                log.info("Click on --- " + text);

                //Stop the loop.
                break;
                }
            }


        //If identifier is not present, then control will come to catch block.
        } catch (NoSuchElementException e) {

            //Log information.
            log.error("This --- "+text+" is not present");

            //TestNG assertion fail.
            Assert.fail(e.getMessage());

        }
    }


    //Keyboard enter function.
    public void keyboardEnter_Key(String identifier){

        try {
            driver.findElement(By.xpath(prop.getProperty(identifier))).sendKeys(Keys.ENTER);

            log.info("Press the Enter Kye");

        }catch (NoSuchElementException e){
            log.info("Unable to locate or upload --- "+identifier);
            Assert.fail(e.getMessage());
        }

    }


    //Keyboard Arrow Down function.
    public void keyboardArrow_Down(String identifier){

        try {

            driver.findElement(By.xpath(prop.getProperty(identifier))).sendKeys(Keys.ARROW_DOWN);
            log.info("Press the Arrow Key");

        }catch (NoSuchElementException e){
            log.info("Unable to locate or upload "+identifier);
            Assert.fail(e.getMessage());
        }

    }


    //Function for Window Alert validation with message.
    public void validateWindowAlert(String message){

        try{

            Alert alert = driver.switchTo().alert();

            String actualText = alert.getText();

            if(message.equals(actualText)){

                log.info("Alert present with valid Message "+ actualText);

            }else {

                Assert.fail("Alert Message in not valid");
            }

            alert.accept();

        }catch (Exception e){

            Assert.fail(e.getMessage());
        }


    }

    //Function for validate the any locator with xpath is present or not.
    public void verifyElementPresentByXpath(String locator){

        if(driver.findElements(By.xpath(prop.getProperty(locator))).size()!=0){

            log.info(locator+" is Present");

            }else{

            log.info(locator+" is not Present");

            Assert.fail(locator+" is not Present");

            }

        }


    }





