import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class SmokeTest extends BaseTest
{
	@Test
	public void m1() throws Throwable
	{
		dr.manage().window().maximize();.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement menu=dr.findElement(By.xpath("//a[text()='Women']"));
		Actions a=new Actions(dr);
		a.moveToElement(menu).perform();
		Thread.sleep(3000);
		List<WebElement> c=dr.findElements(By.xpath(".//*[@id='main-nav-woman']/div/div"));
		int s=c.size();
		List<WebElement> c1=dr.findElements(By.xpath(".//*[@id='main-nav-woman']/div/div[1]/ul/li"));
		int s1=c1.size();
		
		for(int i=1;i<=s;i++)
		{
			dr.findElements(By.xpath(".//*[@id='main-nav-woman']/div/div["+i+"]"));
		    //System.out.println("hi");
			for(int j=1;j<=s1;j++)
			{Thread.sleep(2000);
		dr.findElement(By.xpath(".//*[@id='main-nav-woman']/div/div["+i+"]/ul/li["+j+"]/a")).click();
		//dr.navigate().back();
		Thread.sleep(3000);
		WebElement menu1=dr.findElement(By.xpath("//a[text()='Women']"));
		Actions a1=new Actions(dr);
		a1.moveToElement(menu1).perform();
		Thread.sleep(2000);
		//System.out.println("hello");
		}
		}
}
}
