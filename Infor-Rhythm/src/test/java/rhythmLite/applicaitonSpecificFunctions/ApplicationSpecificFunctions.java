package rhythmLite.applicaitonSpecificFunctions;

import generics.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by ${mkhan2} on ${10/27/2014}.
 */
public class ApplicationSpecificFunctions extends TestBase{


    public String title=null;



    //Test type setting
    public void openBrowser(String browser){

        //Select the mode where to test.
        testLocal(browser);

        //Navigate to the Site.
        navigate("TestSiteURL");
    }


    //Login function roe Site
    public void verifyLogin(String browser, String emailId,String password) throws InterruptedException {

        //Open the Browser function instantiated from Test Base class.
        openBrowser(browser);

        //Click on User Icon.
        click("BeforeLoginUserIcon_id");

        //Click on User Icon.
        click("login_xpath");

        //Input Email address to the Email field.
        input("Email_id", emailId);

        //Input Password to the Password field.
        input("Password_id", password);

        //Click Submit Button.
        click("SubmitButton_css");
    }


    //Default login function.
    public void login(String browser) throws InterruptedException {

       //Instantiated doLogin function.
        verifyLogin(browser, prop.getProperty("defaultQAUEmail"), prop.getProperty("defaultQAPassword"));
    }


    //Default gust user login.
    public void gustLogin(String browser) throws InterruptedException {

        //Open the Browser.
        openBrowser(browser);
    }


    //Add Item to the Mini Cart Function.
    public void addItem( String productID,String quantity ) throws InterruptedException {

        //Create xpath 1st
        String firstXpath ="//*[@id='grid-view']/li[";

        //Create xpath 2nd
        String lastXpath="]/div/a";

        String beforeAddItemsAtMiniCart;

        if(driver.findElements(By.xpath(prop.getProperty("ItemMiniCart_xpath"))).size()!=0){

            beforeAddItemsAtMiniCart = getText("ItemMiniCart_xpath");

            log.info("Mini Cart Item before add "+ beforeAddItemsAtMiniCart);

        }else {

            beforeAddItemsAtMiniCart = "0";
        }

        //Click on Menu
        click("Menu_id");

        //Click on Shop
        click("Shop_xpath");

        //Create entire xpath
        String xpath = firstXpath+productID+lastXpath;

        //Click on Items
        driver.findElement(By.xpath(xpath)).click();

        //Input the quantity for Item.
        input("ProductQuantity_css", quantity);

        //Click on Add To Cart
        click("AddToTheCart_css");

        Thread.sleep(4000);

        String afterAddItemsAtMiniCart= getText("ItemMiniCart_xpath");

        int x = Integer.parseInt(afterAddItemsAtMiniCart);

        int z =Integer.parseInt(beforeAddItemsAtMiniCart);

        int e = (x-z);

        int y = Integer.parseInt(quantity);

        if (e==y ){
            log.info("Successfully add "+ y +" Items to the Min Cart");
        }else{
            Assert.fail("Can't add item to the Mini Cart");
        }


    }

    //Navigate to the Shopping Cart Function
    public void toShoppingCart( String browser,String productID,String quantity ) throws InterruptedException {

        //Instantiated login Function.
        login(browser);

        //Instantiated addItem function
        addItem(productID,quantity);

        //Initialize the thread.
        Thread.sleep(3000);
        click("MimiCartGoToCart_xpath");

    }

    public void toMyOrder(String browser) throws InterruptedException {
        login(browser);
        Thread.sleep(2000);
        click("ViewOrders_xpath");


    }


    //Function for validate links with title of page
    public void validateLinksNTitle(String widget,String xpathOfTitle, String title) throws InterruptedException {

        this.title = title;

        Thread.sleep(2000);

        linksValidateByText(widget);

        Thread.sleep(2000);

        String text = getText(xpathOfTitle);

        log.info("Get text --- "+text);

        if (title.equals(text)) {

            log.info("This " + widget + " Links and " + title + " Title  are present in this page");

        } else {

            log.info("This " + widget + " Links and " + title + " Title are not present in this page");

            Assert.fail();
        }

    }

    //Function for Menu Button.
    public void ValidateButtonNTitle(String button_Xpath,String expectedTitle){

        //Click on Menu Button.
        click(button_Xpath);

        //Condition for Menu Button open expected page.
        if (isElementPresent(expectedTitle)==true){

            log.info("Menu Button is working as expected");

        }else {

            log.info("Menu Button is not working as expected");

            Assert.fail();
        }

    }




}
