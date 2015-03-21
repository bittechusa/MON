import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest 
	{
		FirefoxDriver dr;
		@Before
		public void start()
		{
			dr=new FirefoxDriver();
			dr.get("http://www.facebook.com");
			dr.manage().window().maximize();
			dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		@After
		public void end() throws InterruptedException
		
		{
			Thread.sleep(3000);
			dr.quit();
		}

}
