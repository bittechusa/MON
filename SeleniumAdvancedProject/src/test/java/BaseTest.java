import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest 
{
	FirefoxDriver driver=new FirefoxDriver();
	@Before
	public void start()
	{
		driver.get("http://www.bittechusa.com/alert.html");
	}
	@After
	public void end() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}

}
