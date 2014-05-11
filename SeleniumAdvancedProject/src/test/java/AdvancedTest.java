import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class AdvancedTest extends BaseTest
{
	/*@Test
	public void test1() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@type='button']")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//a[@class='btn']")).click();
		driver.navigate().back();
		driver.switchTo().defaultContent();//to back regularpage
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("hi");}
		*/
//driver.switchTo().frame(driver.findElements(By.tagName("iframe").get(0));for multiple iframe
	
	/*@Test
	public void drugable() throws Throwable
	{
		driver.get("http://www.jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		WebElement dropable=driver.findElement(By.id("draggable"));//source file
		WebElement moga2=driver.findElement(By.id("droppable"));//target file
		new Actions(driver).dragAndDropBy(dropable, 200, 10).build().perform();//this for anywhere based on pixel
		new Actions(driver).dragAndDrop(dropable, moga2).build().perform();//this for specific place
		Thread.sleep(4000);
	}*/
	@Test
	public void alert2() throws Throwable
	{
		driver.get("http://www.bittechusa.com/alert2.html");
		driver.findElement(By.xpath("//button")).click();
		String text=driver.switchTo().alert().getText();
		System.out.println(text);
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		//driver.switchTo().alert().accept();
		
	}

}
