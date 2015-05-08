package rhythmLite.dashboard.main;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import rhythmLite.applicaitonSpecificFunctions.ApplicationSpecificFunctions;

/**
 * Created by ${mkhan2} on ${10/27/2014}.
 */
public class DashboardFunctions extends ApplicationSpecificFunctions {



    public void addItemNumberWidget(String productID0,String productQY0,String productID1,String productQY1,String productID2,String productQY2,String productID3,String productQY3,String productID4,String productQY4,
                                    String productID5,String productQY5,String productID6,String productQY6,String productID7,String productQY7,String productID8,String productQY8,String productID9,String productQY9) throws InterruptedException {

        String itemXpath = "//*[@id='item-";

        String qytXpaht = "//*[@id='qty-";

        String xpath2 = "']";

        String[] i = {"0","1","2","3","4","5","6","7","8","9"};



        input(itemXpath + i[0] + xpath2, productID0);
        input(qytXpaht + i[0] + xpath2, productQY0);

        input(itemXpath + i[1] + xpath2, productID1);
        input(qytXpaht + i[1] + xpath2, productQY1);

        click("AddMoreItems_xpath");
        Thread.sleep(2000);

        input(itemXpath + i[2] + xpath2, productID2);
        input(itemXpath + i[2] + xpath2, productQY2);

        input(itemXpath + i[3] + xpath2, productID3);
        input(itemXpath + i[3] + xpath2, productQY3);

        click("AddMoreItems_xpath");
        Thread.sleep(2000);

        input(itemXpath + i[4] + xpath2, productID4);
        input(itemXpath + i[4] + xpath2, productQY4);

        input(itemXpath + i[5] + xpath2, productID5);
        input(itemXpath + i[5] + xpath2, productQY5);

        click("AddMoreItems_xpath");
        Thread.sleep(2000);

        input(itemXpath + i[6] + xpath2, productID6);
        input(itemXpath + i[6] + xpath2, productQY6);

        input(itemXpath + i[7] + xpath2, productID7);
        input(itemXpath + i[7] + xpath2, productQY7);

        click("AddMoreItems_xpath");
        Thread.sleep(2000);

        input(itemXpath + i[8] + xpath2, productID8);
        input(itemXpath + i[8] + xpath2, productQY8);

        input(itemXpath + i[9] + xpath2, productID9);
        input(itemXpath + i[9] + xpath2, productQY9);

        click("AddToCart_xpath");

        Thread.sleep(2000);



        Alert alert = driver.switchTo().alert();

        log.info("Alert detected : {}"+alert.getText());

        alert.accept();


    }


    }


