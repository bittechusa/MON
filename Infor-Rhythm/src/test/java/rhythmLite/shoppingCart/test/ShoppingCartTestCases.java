package rhythmLite.shoppingCart.test;

import generics.Constants;
import generics.TestDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import rhythmLite.shoppingCart.main.ShoppingCartFunctions;

import java.util.Hashtable;

/**
 * Created by ${mkhan2} on ${10/27/2014}.
 */
public class ShoppingCartTestCases extends ShoppingCartFunctions {


    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "shoppingCartDataProvider")
    public void verifyOrderFromFE(Hashtable<String, String> table) throws InterruptedException {

        validateRunmodes("verifyOrderFromFE", Constants.ShoppingCart, table.get(Constants.RUNMODE_COL));

    }





    @AfterMethod
    public void close(){
        closeBrowser();
    }
}


