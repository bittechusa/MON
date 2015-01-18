import org.openqa.selenium.By;


public class Common extends BaseTest
{
	public void buyTickets()
	{
		
		driver.findElement(By.xpath("//a[@href='?storeid=1217&menu=detail&eventid=32432']")).click();
		
	}
	public void unlock()
	{
		driver.findElement(By.xpath("//input[@class='codeinput']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@name='codesubmit']")).click();
	}
	public void selectQuantity()
	{
		driver.findElement(By.xpath("//i[@id='section_selectSelectBoxItArrow']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Section')]")).click();
	}
	
	

}
