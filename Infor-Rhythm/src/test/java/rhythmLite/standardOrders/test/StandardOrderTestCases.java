package rhythmLite.standardOrders.test;

import generics.Constants;
import generics.TestDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import rhythmLite.standardOrders.main.StandardOrderFunctions;

import java.util.Hashtable;

/**
 * Created by ${mkhan2} on ${10/27/2014}.
 */
public class StandardOrderTestCases extends StandardOrderFunctions {



    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "standardOrdersDataProvider")
    public void  verifyStandardOrdersFE(Hashtable<String, String> table) throws InterruptedException {

        validateRunmodes("verifyStandardOrdersFE", Constants.StandardOrders, table.get(Constants.RUNMODE_COL));

        openStandards(table.get("Browser"));

    }



    @AfterMethod
    public void close(){
        closeBrowser();
    }

}
