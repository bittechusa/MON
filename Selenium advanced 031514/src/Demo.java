import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
//import com.gargoylesoftware.htmlunit.javascript.host.geo.Coordinates;
//import com.steadystate.css.parser.Locatable;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.Select;


public class Demo 
{
	static FirefoxDriver driver =new FirefoxDriver();

	public static void main(String[] args) {
		

	}
	//wait for page load
	static void test()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Assign action object
		WebElement element=driver.findElement(By.linkText("link"));
		Actions b=new Actions(driver);
		b.contextClick(element).sendKeys("hi");
		
	}
	static void test1()
	{
		//view last train
		
		WebElement c=driver.findElement(By.xpath("//inpyt[@id='n']"));
		Coordinates co=((Locatable)c).getCoordinates();
		
	}
	static void test2()
	{
		//assign for list box
		WebElement e=driver.findElement(By.id("m"));
		//assign select object
		Select s=new Select(e);
		//select value by text
		s.selectByVisibleText("r");
		//list box size
		int listboxSize=s.getOptions().size();
		//select last value by index
		s.selectByIndex(listboxSize-1);
		
	}
	static void test3()
	{
		//get all link text
		List<WebElement> count=driver.findElements(By.tagName("a"));
		System.out.println(count.size());
		for(WebElement link:count)
		{
			System.out.println(link.getText());
		}
	}
		static void test4()
		{
			WebDriver driver=new FirefoxDriver();
			driver.get("http://developer.paypal.com/webapp/developer/applications/myapp");
			//maximize window
			driver.manage().window().maximize();
			driver.findElement(By.linkText("Log In")).click();
			//parent window handle
			String handle=driver.getWindowHandle();
			//all window handle
			Set<String> handles=driver.getWindowHandles();
			//loop for each handle
			for(String h:handles)
			{
				if(!h.equals(handle))
				{
					driver.switchTo().window(h);
				}
				
			}
		}
			//how to read excel sheet using poi api
			
		static void test5() throws Throwable
		{
			String inputfile ="C:\\Users\\Desktop\\controller.xls"; 
			InputStream excelInp = new FileInputStream(inputfile); 
			HSSFWorkbook wb = new HSSFWorkbook(excelInp); 
			int sheetNum = 0;//initilize becuze of error only
			HSSFSheet sheet = wb.getSheetAt(sheetNum); 
			int upColumnNum = 0;//initilize becuze of error only
			HSSFRow columnupdate = sheet.getRow(upColumnNum); 
			short upRowNum = 0;//initilize becuze of error only
			HSSFCell rowupdate = columnupdate.getCell(upRowNum);
		}
		
		
	
	

}
