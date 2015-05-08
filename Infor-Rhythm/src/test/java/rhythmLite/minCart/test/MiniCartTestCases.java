package rhythmLite.minCart.test;

import rhythmLite.minCart.main.MiniCartFunctions;
import generics.Constants;
import generics.TestDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Created by ${mkhan2} on ${10/27/2014}.
 */
public class MiniCartTestCases extends MiniCartFunctions {





    @Test(priority =3,dataProviderClass = TestDataProvider.class, dataProvider = "miniCartDataProvider")
    public void  addItemRUser(Hashtable<String, String> table) throws InterruptedException {

        validateRunmodes("addItemRUser", Constants.MiniCart, table.get(Constants.RUNMODE_COL));


    }



    @AfterMethod
    public void close(){
        closeBrowser();
    }






}
