package rhythmLite.gustUser.test;

import generics.Constants;
import generics.TestDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import rhythmLite.gustUser.main.GustUserFunctions;

import java.util.Hashtable;

/**
 * Created by ${mkhan2} on ${10/27/2014}.
 */
public class GustUserTestCases extends GustUserFunctions {

    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "gustUserDataProvider")
    public void verifyGustUsersVisiting(Hashtable<String, String> table) throws InterruptedException {

        validateRunmodes("verifyGustUsersVisiting", Constants.GustUser, table.get(Constants.RUNMODE_COL));

        validateGustLogin(table.get("Browser"));

    }

    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "gustUserDataProvider")
    public void verifyGustUsersAddItemsToMiniCart(Hashtable<String, String> table) throws InterruptedException {

        validateRunmodes("verifyGustUsersAddItemsToMiniCart", Constants.GustUser, table.get(Constants.RUNMODE_COL));

        gustAddItems(table.get("Browser"), table.get("ProductID"), table.get("Quantity"));

    }


    @AfterMethod
    public void close(){
        closeBrowser();
    }


}
