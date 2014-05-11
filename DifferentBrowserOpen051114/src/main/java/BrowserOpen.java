import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class BrowserOpen 
{
	WebDriver driver;
	
	public void start()
	{
		String b=System.getProperty("moga");
		if(b.equals("F"))
		{
			driver=new FirefoxDriver();
		}
		else if(b.equals("C"))
		{
		System.setProperty("webdriver.chrome.driver", "/Users/shahidulislam/Downloads/chromedriver");
		driver=new ChromeDriver();
		}
		else if(b.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "/Users/shahidulislam/Downloads/IEDriverServer");
			driver=new InternetExplorerDriver();
		}
		else
			driver=new FirefoxDriver();
		
	}
	public void end()
	{
		driver.quit();
	}
		

}
