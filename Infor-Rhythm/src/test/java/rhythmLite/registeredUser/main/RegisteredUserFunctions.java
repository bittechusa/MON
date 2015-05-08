package rhythmLite.registeredUser.main;

import org.openqa.selenium.By;
import org.testng.Assert;
import rhythmLite.applicaitonSpecificFunctions.ApplicationSpecificFunctions;


/**
 * Created by ${mkhan2} on ${10/27/2014}.
 */
public class RegisteredUserFunctions extends ApplicationSpecificFunctions {


    public String oneInvalidData = "missing details for login";

    public String invalidData = "Invalid username/password";


    public String title = null;



    //Visit site as guest user
    public void verifyGuestVisit(String browser) throws InterruptedException {

        //Instantiated gustLogin Function.
        gustLogin(browser);

        Thread.sleep(2000);
        //Click on User favicon.
        click("BeforeLoginUserIcon_id");

        Thread.sleep(2000);
        //Verify the login option is available.
        verifyElementPresentByXpath("login_xpath");
    }


    //Function for login with valid credentials.
    public void validLogin(String browser, String email, String password, String validUserName) throws InterruptedException {


        //Initialize the Login function.
        verifyLogin(browser, email, password);

        Thread.sleep(3000);
        //Click on User Icon.
        click("AfterLoginUserIcon_id");

        Thread.sleep(2000);
        //Get actual user name from site.
        String actualUserName = getText("ActualUserName_xpath");

        log.info(actualUserName);

        //Validation Valid User login.
        if (validUserName.equals(actualUserName)){

            //Log message for success login.
            log.info("Login is success with valid Credentials");

            //Log message for success login.
            log.info(validUserName + " is equal to " + actualUserName);

        }else{

            //Log message for not success login.
            log.info(validUserName + " is not equal to " + actualUserName);

            //if fail login.
            Assert.fail("Login is not success with valid Credentials");

        }

    }


    //Function for login with invalid credentials.
    public void validEmail(String browser,  String email){

        //Open the Browser.
        openBrowser(browser);

        //Click on User Icon.
        click("BeforeLoginUserIcon_id");

        //Click on User Icon.
        click("login_xpath");

        //Input Email address to the Email field.
        input("Email_id", email);

        //Click Submit Button.
        click("SubmitButton_css");

        //Extends the Alert function for validation for error message.
        validateWindowAlert(oneInvalidData);

    }

    //Function for login with invalid credentials.
    public void validPassword(String browser,  String password){

        //Open the Browser.
        openBrowser(browser);

        //Click on User Icon.
        click("BeforeLoginUserIcon_id");

        //Click on User Icon.
        click("login_xpath");

        //Input Email address to the Email field.
        input("Password_id", password);

        //Click Submit Button.
        click("SubmitButton_css");

        //Extends the Alert function for validation for error message.
        validateWindowAlert(oneInvalidData);

    }

    //Function for login with invalid credentials.
    public void oneWrongData(String browser, String email, String password) throws InterruptedException {

        //Initialize the Login function.
        verifyLogin(browser, email, password);

        Thread.sleep(2000);
        //Extends the Alert function for validation for error message.
        validateWindowAlert(invalidData);

    }


    public void lockedUserLogin(String browser, String email, String password) throws InterruptedException {

        //Initialize the Login function.
        verifyLogin(browser,email,password);

        Thread.sleep(2000);
        //Extends the Alert function for validation for error message.
        validateWindowAlert(invalidData);
    }



    public void incorretCredential5Times(String browser, String email,String password) throws InterruptedException {

        String invalidData =null;

        this.invalidData=invalidData;

        //Open Browser
        openBrowser(browser);

        //Loop the script for 5 times.
        for (int x = 1; x <= 5; x++ ){

            //Navigate to the Site.
            navigate("RegisterUserURL");

            //Click on User Icon.
            click("UserIcon_xpath");

            //Input Email address to the Email field.
            input("Email_xpath", email);

            //Input Password to the Password field.
            input("Password_xpath", password);

            //Click Submit Button.
            click("SubmitButton_xpath");

            //Validate the Window alert.
            validateWindowAlert(invalidData);

            navigateBack();

           log.info("Providing invalid credentials for time :"+ x );

        }

        Thread.sleep(2000);


    }

    public void shoppingCartMergeGuestWithRegisterUser(String browser) throws InterruptedException {


        String item = "6";


        Thread.sleep(3000);


        String addItems = getText("CEPMiniCart");

        log.info("Total items in Mimi cart = " + addItems);

        int addallItems = Integer.parseInt(addItems);


        //Navigate the test site url.
        driver.get("http://54.194.142.220//#items/category/all");

        Thread.sleep(3000);

        click("CEProduct1_xpath");

        Thread.sleep(3000);

        input("CEProductQuantity_xpath", item);

        click("CEAddtoTheCart_xpath");

        Thread.sleep(3000);


        Thread.sleep(3000);

        String second = getText("CEPMiniCart");

        int finalitem = Integer.parseInt(second);

        int addInitial = Integer.parseInt(item);

        int actualItems = addallItems + addInitial;


        if (actualItems == finalitem) {
            log.info("Successfully add item to the shopping cart ");


        } else {

            Assert.fail("Can't add Item to the Mini Cart");

            log.info("Can't add Item to the Mini Cart");
        }


    }

    public void validateLinksNTitle(String widget,String xpathOfTitle, String title) throws InterruptedException {

        //Initialize the unique variable.
        this.title = title;
        //Initialize the Thread.
        Thread.sleep(2000);

        linksValidateByText(widget);

        String text = driver.findElement(By.xpath(prop.getProperty(xpathOfTitle))).getText();

        log.info("Get text --- "+text);

        if (title.equals(text)) {

            log.info("This " + widget + " Links and " + title + " Title  are present in this page");

        } else {

            log.info("This " + widget + " Links and " + title + " Title are not present in this page");

            Assert.fail();
        }

    }


}
