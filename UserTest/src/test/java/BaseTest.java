import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseTest 
{
	static FirefoxDriver driver = new FirefoxDriver();
	
	@BeforeTest
	public void start()
	{
		driver.get("http://www.crowdsurge.com/store/index.php?storeid=1217");
	}
	
	@AfterTest
	public void close() throws Exception
	{
		Thread.sleep(5000);
		driver.quit();
	}

}
