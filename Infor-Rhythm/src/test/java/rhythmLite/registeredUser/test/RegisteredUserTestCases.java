package rhythmLite.registeredUser.test;


import rhythmLite.registeredUser.main.RegisteredUserFunctions;
import generics.Constants;
import generics.TestDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Created by ${mkhan2} on ${10/27/2014}.
 */
public class RegisteredUserTestCases extends RegisteredUserFunctions {


    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "registerUserDataProvider")
    public void  verifyVisitSiteAsGuestUser(Hashtable<String, String> table) throws InterruptedException {

        validateRunmodes("verifyVisitSiteAsGuestUser", Constants.RegisteredUser, table.get(Constants.RUNMODE_COL));

        verifyGuestVisit(table.get("Browser"));

    }


    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "registerUserDataProvider")
    public void  verifyLoginWithValidEmailValidPassword(Hashtable<String, String> table) throws InterruptedException {

        validateRunmodes("verifyLoginWithValidEmailValidPassword", Constants.RegisteredUser, table.get(Constants.RUNMODE_COL));

        validLogin(table.get("Browser"), table.get("Email"), table.get("Password"),table.get("ActualUser"));

    }



    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "registerUserDataProvider")
    public void  verifyLoginWithValidEmailWithoutPassword(Hashtable<String, String> table) throws InterruptedException {

        validateRunmodes("verifyLoginWithValidEmailWithoutPassword", Constants.RegisteredUser, table.get(Constants.RUNMODE_COL));

        validEmail(table.get("Browser"), table.get("Email"));

    }


    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "registerUserDataProvider")
    public void  verifyLoginWithWithoutEmailValidPassword(Hashtable<String, String> table) throws InterruptedException {

        validateRunmodes("verifyLoginWithWithoutEmailValidPassword", Constants.RegisteredUser, table.get(Constants.RUNMODE_COL));

        validPassword(table.get("Browser"), table.get("Password"));

    }


    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "registerUserDataProvider")
    public void  verifyLoginWithValidEmailWrongPassword(Hashtable<String, String> table) throws InterruptedException {

        validateRunmodes("verifyLoginWithValidEmailWrongPassword", Constants.RegisteredUser, table.get(Constants.RUNMODE_COL));

        oneWrongData(table.get("Browser"), table.get("Email"), table.get("Password"));

    }

    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "registerUserDataProvider")
    public void  verifyLoginWithInvalidEmailValidPassword(Hashtable<String, String> table) throws InterruptedException {

        validateRunmodes("verifyLoginWithInvalidEmailValidPassword", Constants.RegisteredUser, table.get(Constants.RUNMODE_COL));

        oneWrongData(table.get("Browser"), table.get("Email"),table.get("Password"));

    }

    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "registerUserDataProvider")
    public void  verifyLoginWithInvalidEmailInvalidPassword(Hashtable<String, String> table) throws InterruptedException {

        validateRunmodes("verifyLoginWithInvalidEmailInvalidPassword", Constants.RegisteredUser, table.get(Constants.RUNMODE_COL));

        oneWrongData(table.get("Browser"), table.get("Email"),table.get("Password"));

    }

    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "registerUserDataProvider")
    public void  verifyLockedUserLogin(Hashtable<String, String> table) throws InterruptedException {

        validateRunmodes("verifyLockedUserLogin", Constants.RegisteredUser, table.get(Constants.RUNMODE_COL));

        lockedUserLogin(table.get("Browser"), table.get("Email"), table.get("Password"));

    }


    @Test(priority = 0,dataProviderClass = TestDataProvider.class, dataProvider = "registerUserDataProvider")
    public void  verifyRegisterUserIncorrectCredential5Times(Hashtable<String, String> table) throws InterruptedException {

        validateRunmodes("verifyRegisterUserIncorrectCredential5Times", Constants.RegisteredUser, table.get(Constants.RUNMODE_COL));

        incorretCredential5Times(table.get("Browser"), table.get("Email"), table.get("Password"));

    }



    @AfterMethod
    public void close(){
        closeBrowser();
    }


}
