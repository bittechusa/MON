import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.Select;


public class RightMouseClick 
{
	
	@Test
	public void rightClick() throws Throwable
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		Thread.sleep(4000);
		WebElement ele=driver.findElement(By.linkText("Business"));
		Actions b=new Actions(driver);
		b.contextClick(ele).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
	}
	@Test
	public void scrollDown() throws Throwable
	{//for scroll the element
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://erail.in");
		//enter from station code
		driver.findElement(By.id("txtStationFrom")).sendKeys("MS" + Keys.TAB);
		//enter to station code
		driver.findElement(By.id("txtStationTo")).sendKeys("TPJ" + Keys.TAB);
		Thread.sleep(3000);
		//assign element for last train
		WebElement ele=driver.findElement(By.xpath("//*[@id=\"divTrainsListTrainsObj\"]/table[1]/tbody/tr[26]/td[2]/a"));
		//view last train
		Coordinates co=((Locatable)ele).getCoordinates();
		co.inViewPort();
		
		
		
	}
	@Test
	public void menuSubmenu() throws Throwable
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://flex.apache.org/");
		Thread.sleep(4000);
		WebElement menu=driver.findElement(By.xpath("//a[contains(text(),'About Flex')]"));
		WebElement subMenu=driver.findElement(By.xpath("//a[text()='Features']"));
		Actions a=new Actions(driver);
		a.moveToElement(menu).perform();
		Thread.sleep(2000);
		a.click(subMenu).perform();
		
	}
	@Test
	public void screenShot() throws Throwable
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://test.jiatro.com/mhs/");
		File sf=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sf, new File("/Users/shahidulislam/Desktop/other/shot1.png"),true);
		driver.close();
	}
	
	

	
	@Test
	public void loopSubmenu() throws Exception
	{ WebDriver driver=new FirefoxDriver();
		
		driver.get("http://www.bluefly.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//ul[@id='main-nav-list']/li"));
	
		List <WebElement> menu= (List<WebElement>) driver.findElements(By.xpath("//ul[@id='main-nav-list']/li"));
		
		for(int i= 2; i<=menu.size();i++)
		{
			List<WebElement>sublink = driver.findElements(By.xpath("//li["+i+"]/div/div/ul/li/a"));
			
			for(int f= 1; f<=sublink.size();f++)
					{
						WebElement menulink = driver.findElement(By.xpath("//ul[@id='main-nav-list']/li/["+i+"]/a"));
						new Actions(driver).moveToElement(menulink).perform();
						driver.findElement(By.xpath("//li["+i+"]/div/div/ul/li/a["+f+"]")).click();
						driver.navigate().back();
						Thread.sleep(3000);
					}
		}
	}
	
	@Test
    public void loopOnPicture() throws Exception
    {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.bluefly.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[text()='Women']")).click();
         List<WebElement> elements =driver.findElements(By.xpath(".//*[@id='departmentCrossSellContainer']/div"));
         int a = elements.size();
        // System.out.println("size is:"+ a);
         for (int i = 2; i<=a; i++)
         {
             driver.findElement(By.xpath(".//*[@id='departmentCrossSellContainer']/div["+i+"]/div[1]/a/img")).click();
             Thread.sleep(3000);
             driver.navigate().back();
             Thread.sleep(3000);
         }

	}
	@Test
	public void getSizeFromDropDown() throws Throwable
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.facebook.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Select dropdown=new Select(driver.findElement(By.id("day")));
		dropdown.selectByVisibleText("20");
		Thread.sleep(3000);
		int boxsize=dropdown.getOptions().size();
		
		dropdown.selectByIndex(boxsize-1);
		
		
	}
	@Test
	public void getAlllink()
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.facebook.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        List<WebElement> alllink=driver.findElements(By.tagName("a"));
        System.out.println(alllink.size());
        for(WebElement linkText:alllink)
        {
        	System.out.println(linkText.getText());
        	
        }
		
	}
}