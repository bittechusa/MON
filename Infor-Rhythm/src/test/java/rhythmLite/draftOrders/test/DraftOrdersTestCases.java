package rhythmLite.draftOrders.test;

import generics.Constants;
import generics.TestDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import rhythmLite.draftOrders.main.DraftOrderFunctions;

import java.util.Hashtable;

/**
 * Created by ${mkhan2} on ${10/27/2014}.
 */
public class DraftOrdersTestCases extends DraftOrderFunctions {






    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "draftOrdersDataProvider")
    public void  verifyDraftOrdersFE(Hashtable<String, String> table) throws InterruptedException {
        validateRunmodes("verifyDraftOrdersFE", Constants.DraftOrders, table.get(Constants.RUNMODE_COL));

    }

    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "draftOrdersDataProvider")
    public void  verifyCreateCompanyDraftOrders(Hashtable<String, String> table) throws InterruptedException {
        validateRunmodes("verifyCreateCompanyDraftOrders", Constants.DraftOrders, table.get(Constants.RUNMODE_COL));

        createCompanyDraft(table.get("Browser"), table.get("ProductID"), table.get("ProductQT"), table.get("Draft Order Name"));

    }


    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "draftOrdersDataProvider")
    public void  verifyCreateSingleDraftOrders(Hashtable<String, String> table) throws InterruptedException {
        validateRunmodes("verifyCreateSingleDraftOrders", Constants.DraftOrders, table.get(Constants.RUNMODE_COL));

        createSingleDraft(table.get("Browser"), table.get("ProductID"), table.get("ProductQT"), table.get("Draft Order Name"));


    }

    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "draftOrdersDataProvider")
    public void  verifyTheDraftTab(Hashtable<String, String> table) throws InterruptedException {
        validateRunmodes("verifyTheDraftTab", Constants.DraftOrders, table.get(Constants.RUNMODE_COL));
        draftTab(table.get("Browser"));

    }


    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "draftOrdersDataProvider")
    public void  verifyDraftOrdersNameColumn(Hashtable<String, String> table) throws InterruptedException {
        validateRunmodes("verifyDraftOrdersNameColumn", Constants.DraftOrders, table.get(Constants.RUNMODE_COL));
        draftName(table.get("Browser"));

    }

    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "draftOrdersDataProvider")
    public void  verifyTheDraftOrdersNameClickViewDetailsExpand(Hashtable<String, String> table) throws InterruptedException {
        validateRunmodes("verifyTheDraftOrdersNameClickViewDetailsExpand", Constants.DraftOrders, table.get(Constants.RUNMODE_COL));
        draftNmeExpand(table.get("Browser"));

    }

    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "draftOrdersDataProvider")
    public void  verifyTheClickOnDraftOrdersItemImageToItemDetails(Hashtable<String, String> table) throws InterruptedException {
        validateRunmodes("verifyTheClickOnDraftOrdersItemImageToItemDetails", Constants.DraftOrders, table.get(Constants.RUNMODE_COL));
        clickOnImageToDetails(table.get("Browser"));

    }

    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "draftOrdersDataProvider")
    public void  verifyTheClickOnDraftOrdersItemIDToItemDetails(Hashtable<String, String> table) throws InterruptedException {
        validateRunmodes("verifyTheClickOnDraftOrdersItemIDToItemDetails", Constants.DraftOrders, table.get(Constants.RUNMODE_COL));
        clickOnItemsIDToDetails(table.get("Browser"));

    }





    @AfterMethod
    public void close(){
        closeBrowser();
    }


}
