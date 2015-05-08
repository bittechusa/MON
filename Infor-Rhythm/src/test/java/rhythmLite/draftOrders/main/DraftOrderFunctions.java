package rhythmLite.draftOrders.main;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import rhythmLite.applicaitonSpecificFunctions.ApplicationSpecificFunctions;

import java.util.List;

/**
 * Created by ${mkhan2} on ${10/27/2014}.
 */
public class DraftOrderFunctions extends ApplicationSpecificFunctions {





    public void createCompanyDraft(String browser,String itemID, String quantity,String orderName) throws InterruptedException {

        toShoppingCart(browser,itemID, quantity);

        Thread.sleep(3000);

        String parentHandle = driver.getWindowHandle(); // get the current window handle
        click("SaveDraftOrder_xpath");

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        input("SaveDraftOrderName_xpath", orderName);
        click("SaveDraftOrderCheck_xpath");
        click("SaveDraftOrderSubmit_xpath");
        Thread.sleep(2000);
        driver.switchTo().window(parentHandle); // switch back to the original window
        click("DashboardUserIcon_xpath");
        Thread.sleep(2000);
        click("Dashboard_xpath");
        click("ViewOrders_xpath");
        click("Drafts_css");

        Thread.sleep(2000);
        //Create list of webElement
        List<WebElement> draftOrderNames = listOfElements("DraftOrderName_xpath");
        //Initialize 2 seconds wait time.

        //Loop for find selected user and click
        for (int i = 0; i < draftOrderNames.size(); i++) {

            if (draftOrderNames.get(i).getText().equals(orderName)) {

                log.info("Successfully Create a Draft Order with " + orderName);
                break;
            } else {
                Assert.fail();
                break;
            }
        }
    }

    public void createSingleDraft(String browser, String itemID, String quantity,String orderName) throws InterruptedException {

        toShoppingCart(browser,itemID, quantity);

        Thread.sleep(3000);

        String parentHandle = driver.getWindowHandle(); // get the current window handle
        click("SaveDraftOrder_xpath");

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }
        input("SaveDraftOrderName_xpath",orderName);
        click("SaveDraftOrderSubmit_xpath");
        Thread.sleep(2000);
        driver.switchTo().window(parentHandle); // switch back to the original window
        click("DashboardUserIcon_xpath");
        Thread.sleep(2000);
        click("Dashboard_xpath");
        click("ViewOrders_xpath");
        click("Drafts_css");

        Thread.sleep(2000);
        //Create list of webElement
        List<WebElement> draftOrderNames = listOfElements("DraftOrderName_xpath");
        //Initialize 2 seconds wait time.

        //Loop for find selected user and click
        for (int i = 0; i < draftOrderNames.size(); i++) {

            if (draftOrderNames.get(i).getText().equals(orderName)) {

                log.info("Successfully Create a Draft Order with " + orderName);
                break;
            }else{
                Assert.fail();
                break;
            }
        }

    }
    public void draftTab(String browser) throws InterruptedException {
        toMyOrder(browser);
        Thread.sleep(2000);
        verifyElementPresentByXpath("Drafts_xpath");

    }

    public void draftName(String browser) throws InterruptedException {
        toMyOrder(browser);
        Thread.sleep(2000);
        click("Drafts_xpath");
        Thread.sleep(2000);
        verifyElementPresentByXpath("DraftName_xpath");

    }

    public void draftNmeExpand(String browser) throws InterruptedException {
        toMyOrder(browser);
        Thread.sleep(2000);
        click("Drafts_xpath");
        Thread.sleep(2000);
        click("DraftOrderNames_xpath");
        Thread.sleep(2000);
        verifyElementPresentByXpath("DraftOrderItemImage_xpath");
        Thread.sleep(2000);
        click("DraftOrderNames_xpath");

    }


    public void clickOnImageToDetails(String browser) throws InterruptedException {
        toMyOrder(browser);
        Thread.sleep(2000);
        click("Drafts_xpath");
        Thread.sleep(2000);
        click("DraftOrderNames_xpath");
        Thread.sleep(2000);
        click("DraftOrderItemImage_xpath");
        Thread.sleep(2000);
        verifyElementPresentByXpath("ItemImage_xpath");


    }

    public void clickOnItemsIDToDetails(String browser) throws InterruptedException {
        toMyOrder(browser);
        Thread.sleep(2000);
        click("Drafts_xpath");
        Thread.sleep(2000);
        click("DraftOrderNames_xpath");
        Thread.sleep(2000);
        click("DraftOrderItemItems_xpath");
        Thread.sleep(2000);
        verifyElementPresentByXpath("ItemImage_xpath");

    }





}
