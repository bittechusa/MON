import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class RegressionTest extends BaseTest
{
	@Test
	public void m2() throws Throwable
	{
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> m=dr.findElements(By.xpath("//ul[@id='main-nav-list']/li"));
		int m1=m.size();
		List<WebElement> c=dr.findElements(By.xpath(".//*[@id='main-nav-woman']/div/div"));
		int s=c.size();
		List<WebElement> c1=dr.findElements(By.xpath(".//*[@id='main-nav-woman']/div/div[1]/ul/li"));
		int s1=c1.size();
		for(int k=2;k<=m1;k++)
		{
			WebElement menu=dr.findElement(By.xpath("//ul[@id='main-nav-list']/li["+k+"]"));
			Actions a=new Actions(dr);
			a.moveToElement(menu).perform();
			Thread.sleep(3000);
		
		for(int i=1;i<=1;i++)
		{
			dr.findElements(By.xpath("//ul[@id='main-nav-list']/li["+k+"]/div/div["+i+"]"));
		    //System.out.println("hi");
			for(int j=1;j<=s1;j++)
			{
				Thread.sleep(2000);
				if(dr.findElement(By.xpath("//ul[@id='main-nav-list']/li["+k+"]/div/div["+i+"]/ul/li["+j+"]/a")).isDisplayed())
				{
				dr.findElement(By.xpath("//ul[@id='main-nav-list']/li["+k+"]/div/div["+i+"]/ul/li["+j+"]/a")).click();
				//dr.navigate().back();
				
			
				Thread.sleep(2000);
				WebElement menu1=dr.findElement(By.xpath("//ul[@id='main-nav-list']/li["+k+"]"));
				Actions a1=new Actions(dr);
				a1.moveToElement(menu1).perform();
				
				Thread.sleep(2000);
		//System.out.println("hello");
				}
		}
		}
		}
}

}
