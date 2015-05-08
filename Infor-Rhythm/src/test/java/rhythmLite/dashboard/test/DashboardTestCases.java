package rhythmLite.dashboard.test;

import generics.Constants;
import generics.TestDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import rhythmLite.dashboard.main.DashboardFunctions;

import java.util.Hashtable;

/**
 * Created by ${mkhan2} on ${10/27/2014}.
 */
public class DashboardTestCases extends DashboardFunctions {



    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "dashboardDataProvider")
    public void  validateMenuButton(Hashtable<String, String> table) throws InterruptedException {

        validateRunmodes("validateMenuButton", Constants.Dashboard, table.get(Constants.RUNMODE_COL));

        login(table.get("Browser"));

        ValidateButtonNTitle("Menu_xpath", "Company_xpath");

    }

    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "dashboardDataProvider")
    public void  validateSearchButton(Hashtable<String, String> table) throws InterruptedException {

        validateRunmodes("validateSearchButton", Constants.Dashboard, table.get(Constants.RUNMODE_COL));

        login(table.get("Browser"));

        ValidateButtonNTitle("SearchButton_xpath","SearchContent_xpath");

    }

    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "dashboardDataProvider")
    public void  validateUserButton(Hashtable<String, String> table) throws InterruptedException {

        validateRunmodes("validateUserButton", Constants.Dashboard, table.get(Constants.RUNMODE_COL));

        login(table.get("Browser"));

        ValidateButtonNTitle("DashboardUserIcon_xpath","ActualUserName_xpath");

    }

    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "dashboardDataProvider")
    public void  validateMiniCartButton(Hashtable<String, String> table) throws InterruptedException {

        validateRunmodes("validateMiniCartButton", Constants.Dashboard, table.get(Constants.RUNMODE_COL));

        login(table.get("Browser"));

        ValidateButtonNTitle("MiniCartButton_xpath","CloseCart_xpath");

    }


    @Test(priority = 1,dataProviderClass = TestDataProvider.class, dataProvider = "dashboardDataProvider")
    public void  validateOrderHistoryLinks(Hashtable<String, String> table) throws InterruptedException {

        validateRunmodes("validateOrderHistoryLinks", Constants.Dashboard, table.get(Constants.RUNMODE_COL));

        login(table.get("Browser"));

        validateLinksNTitle(table.get("OrderLinks"),"MyOrder_xpath",table.get("ExpectedTitle"));

    }

    @Test(priority = 2,dataProviderClass = TestDataProvider.class, dataProvider = "dashboardDataProvider")
    public void  validateInvoiceLinks(Hashtable<String, String> table) throws InterruptedException {

        validateRunmodes("validateInvoiceLinks", Constants.Dashboard, table.get(Constants.RUNMODE_COL));

        login(table.get("Browser"));

        validateLinksNTitle(table.get("InvoiceLinks"),"Invoice_xpath",table.get("ExpectedTitle"));

    }


    @Test(priority = 3,dataProviderClass = TestDataProvider.class, dataProvider = "dashboardDataProvider")
    public void  validateDeliveryNotesLinks(Hashtable<String, String> table) throws InterruptedException {

        validateRunmodes("validateDeliveryNotesLinks", Constants.Dashboard, table.get(Constants.RUNMODE_COL));

        login(table.get("Browser"));

        validateLinksNTitle(table.get("DeliveryNotes"),"DeliverNotes_xpath",table.get("ExpectedTitle"));

    }


    @Test(priority = 3,dataProviderClass = TestDataProvider.class, dataProvider = "dashboardDataProvider")
    public void  validateAddItemNumber(Hashtable<String, String> table) throws InterruptedException {

        validateRunmodes("validateAddItemNumber", Constants.Dashboard, table.get(Constants.RUNMODE_COL));

        login(table.get("Browser"));

        addItemNumberWidget(table.get("ProductID0"),table.get("QuantityID0"),table.get("ProductID1"),table.get("QuantityID1"),table.get("ProductID2"),table.get("QuantityID2"),table.get("ProductID3"),table.get("QuantityID3"),table.get("ProductID4"),table.get("QuantityID4"),table.get("ProductID5"),table.get("QuantityID5"),table.get("ProductID6"),table.get("QuantityID6"),table.get("ProductID7"),table.get("QuantityID7"),table.get("ProductID8"),table.get("QuantityID8"),table.get("ProductID9"),table.get("QuantityID9"));

    }




    @AfterMethod
    public void close(){
        closeBrowser();
    }


}

