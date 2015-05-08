package rhythmLite.gustUser.main;

import org.testng.Assert;
import rhythmLite.applicaitonSpecificFunctions.ApplicationSpecificFunctions;

/**
 * Created by ${mkhan2} on ${10/27/2014}.
 */
public class GustUserFunctions extends ApplicationSpecificFunctions{


    public String gustWelcome = "Hello, please sign in for great deals.";


    //Gust User login validation Function.
    public void validateGustLogin(String browser) throws InterruptedException {

        //Instantiated guest login Function
        gustLogin(browser);

        //Click on User Icon.
        click("BeforeLoginUserIcon_id");

        //Get the actual text from the gust user greeting.
        String welcomeText = getText("GustUserWelcomeText_css");

        //Log information.
        log.info(welcomeText);

        //Condition for if greeting is equal with the actual message.
        if (gustWelcome.equals(welcomeText)){

            log.info("Successfully Guest visiting site");

        }else {

            Assert.fail("User not a Gust User");
        }

    }

    public void gustAddItems(String browser,String productID,String quantity ) throws InterruptedException {

        //Instantiated guest login Function
        gustLogin(browser);

        //Instantiated Add Item Function.
        addItem(productID,quantity);



    }






}
