package generics;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

/**
 * Created by Samim on 10/14/14.
 */
public class TestDataProvider {


    //Data provider function for Registered Users Excel file.
    @DataProvider(name = "registerUserDataProvider")
    public static Object[][] getRegisterUserData(Method m) {
        TestBase.init();
        Xlsx_Reader xls1 = new Xlsx_Reader(System.getProperty("user.dir") + TestBase.prop.getProperty("xlsFileLocation") + Constants.RegisteredUser + ".xlsx");

        return RunModeConfiguration.getData(m.getName(), xls1);
    }

    //Data provider function for Gust User excel file.
    @DataProvider(name = "gustUserDataProvider")
    public static Object[][] getGustUserData(Method m) {
        TestBase.init();
        Xlsx_Reader xls1 = new Xlsx_Reader(System.getProperty("user.dir") + TestBase.prop.getProperty("xlsFileLocation") + Constants.GustUser + ".xlsx");

        return RunModeConfiguration.getData(m.getName(), xls1);
    }


    //Data provider function for Dashboard excel file.
    @DataProvider(name = "dashboardDataProvider")
    public static Object[][] getDashboardData(Method m) {
        TestBase.init();
        Xlsx_Reader xls1 = new Xlsx_Reader(System.getProperty("user.dir") + TestBase.prop.getProperty("xlsFileLocation") + Constants.Dashboard+ ".xlsx");

        return RunModeConfiguration.getData(m.getName(), xls1);
    }


    //Data provider function for Mini Cart excel file.
    @DataProvider(name = "miniCartDataProvider")
    public static Object[][] getMiniCartData(Method m) {
        TestBase.init();
        Xlsx_Reader xls1 = new Xlsx_Reader(System.getProperty("user.dir") + TestBase.prop.getProperty("xlsFileLocation") + Constants.MiniCart + ".xlsx");

        return RunModeConfiguration.getData(m.getName(), xls1);
    }



    //Data provider function for Draft Orders excel file.
    @DataProvider(name = "draftOrdersDataProvider")
    public static Object[][] getDraftOrdersData(Method m) {
        TestBase.init();
        Xlsx_Reader xls1 = new Xlsx_Reader(System.getProperty("user.dir") + TestBase.prop.getProperty("xlsFileLocation") + Constants.DraftOrders + ".xlsx");

        return RunModeConfiguration.getData(m.getName(), xls1);
    }


    //Data provider function for Standard Order excel file.
    @DataProvider(name = "standardOrdersDataProvider")
    public static Object[][] getStandardOrderData(Method m) {
        TestBase.init();
        Xlsx_Reader xls1 = new Xlsx_Reader(System.getProperty("user.dir") + TestBase.prop.getProperty("xlsFileLocation") + Constants.StandardOrders + ".xlsx");

        return RunModeConfiguration.getData(m.getName(), xls1);
    }

    //Data provider function for Shopping Cart excel file.
    @DataProvider(name = "shoppingCartDataProvider")
    public static Object[][] getShoppingCartData(Method m) {
        TestBase.init();
        Xlsx_Reader xls1 = new Xlsx_Reader(System.getProperty("user.dir") + TestBase.prop.getProperty("xlsFileLocation") + Constants.ShoppingCart + ".xlsx");

        return RunModeConfiguration.getData(m.getName(), xls1);
    }

}