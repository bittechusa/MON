package rhythmLite.minCart.main;

import org.openqa.selenium.By;
import org.testng.Assert;
import rhythmLite.applicaitonSpecificFunctions.ApplicationSpecificFunctions;

/**
 * Created by ${mkhan2} on ${10/27/2014}.
 */
public class MiniCartFunctions extends ApplicationSpecificFunctions {


    //Add Item to the Mini Cart Function.
    public void addItem( String productID,String quantity ) throws InterruptedException {



        //Create xpath 1st
        String firstXpath ="//*[@id='grid-view']/li[";

        //Create xpath 2nd
        String lastXpath="]/div/a";

        //Create entire xpath
        String xpath = firstXpath+productID+lastXpath;


        driver.findElement(By.xpath(xpath)).click();



        Thread.sleep(2000);

        input("CEProductQuantity_xpath", quantity);

        click("CEAddtoTheCart_xpath");

        Thread.sleep(3000);

        String beforeProduct = getText("CEMiniCartItems_xpath");

        int before = Integer.parseInt(beforeProduct);

        int add = Integer.parseInt(quantity);

        if (add <= before){
            log.info("Successfully add "+add+" Items");
        }else {
            Assert.fail("Not successfully add "+add+" Items");
        }


    }

    //Update Items to the Mini Cart function
    public void updateItem(String updateQuantity) throws InterruptedException {


        //Get the total items count from the Mini Cart.
        String beforeProduct = getText("CEMiniCartItems_xpath");

        log.info("There are "+beforeProduct+" items inside the Mini cart");

        //Click on Mini Cart favicon.
        click("ECMiniCartButton_xpath");

        //Input item quantity inside the Input box.
        input("CEUpdateQuantity_xpath",updateQuantity);

        //Click on Go To Cart.
        click("CEGoToCart_xpath");

        //Get the total items count from the Mini Cart.
        String afterUpdate = getText("CEMiniCartItems_xpath");

        //Convert Sting to Integer.
        int initialItems = Integer.parseInt(afterUpdate);

        //Convert Sting to Integer.
        int add = Integer.parseInt(updateQuantity);

        //Condition for two value.
        if (add == initialItems){

            log.info("Successfully update "+add+" Items");

        }else {

            Assert.fail("Not successfully update "+add+" Items");

            log.info("Not successfully update "+add+" Items");
        }


    }

    //Function for delete Item to the Mini Cart.
    public void deleteItemFromMiniCart() throws InterruptedException {



        String xpath="//*[@id='cart-panel']/div/div/div[1]/div/ul/li/button";

        String xpath1="//*[@id='cart-panel']/div/div/div[1]/div/ul/li[";

        String xpath2="]/button";


        click("ECMiniCartButton_xpath");

        click("CEMiniCartDeleteItem_xpath");


        int i =1;

        /*while (isXpathPresent(xpath1+i+xpath2)){

            driver.findElement(By.xpath(xpath1+i+xpath2)).click();

        }


        while (isXpathPresent(xpath)){

            driver.findElement(By.xpath(xpath)).click();

        }
        */
        boolean element = isElementPresent("CEMiniCartItems_xpath");


        if(element==false){

            log.info("Deletion is success, there is no item inside the Mini Cart");

        } else {

            Assert.fail("Can't delete all the items");

        }




    }





    public void registerUserAddItem(String productID,String item) throws InterruptedException {


        Thread.sleep(2000);

        //Click on Menu
        click("CEMenu_xpath");

        //Click on Shop
        click(" CEShop_xpath");

        Thread.sleep(2000);

        String beforeProduct = getText("CEMiniCartItems_xpath");

        int before = Integer.parseInt(beforeProduct);

        //Create xpath
        String firstXpath ="//*[@id='grid-view']/li[";

        //Create xpath
        String lastXpath="]/div/a";

        String xpath = firstXpath+productID+lastXpath;

        driver.findElement(By.xpath(xpath)).click();

        log.info("Select Product Id = "+productID);

        input("CEProductQuantity_xpath", item);

        click("CEAddtoTheCart_xpath");



        int newAdd = Integer.parseInt(item);

        int allProduct = newAdd+before;



        String afterProduct = getText("//*[@id='nav-utility']/ul/li[3]/button/span/span");

        int after = Integer.parseInt(afterProduct);


        if (allProduct==after){
            log.info("Success fully add = "+ newAdd);
        }else {
            Assert.fail("Can't add item to the cart");
        }


        Thread.sleep(3000);



    }

    public void openABC(String browser) throws InterruptedException {

        openBrowser(browser);

        navigate("google");

        Thread.sleep(5000);

    }


}
