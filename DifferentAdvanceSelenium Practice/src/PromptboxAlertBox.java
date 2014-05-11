import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
public class PromptboxAlertBox 
{
	
	
	 @Test
	public void test ()throws InterruptedException {
	 
	 
	 WebDriver myTestDriver = new FirefoxDriver();
	 myTestDriver.get("http://tinyurl.com/d3lz94p");
	 
	 myTestDriver.manage().window().maximize();
	 
	myTestDriver.findElement(By.xpath("//input[@value = 'alert']")).click();
	 Thread.sleep(2000L);
	 Alert javascriptAlert = myTestDriver.switchTo().alert();
	 System.out.println(javascriptAlert.getText()); // Get text on alert box
	 javascriptAlert.accept();
	 
	 
	 System.out.println("*************prompt******************************************");
	 
	 myTestDriver.findElement(By.xpath("//input[@value = 'prompt']")).click();
	 Thread.sleep(2000L);
	 Alert javascriptprompt = myTestDriver.switchTo().alert();
	 javascriptprompt.sendKeys("This is Selenium Training");
	 
	System.out.println(javascriptprompt.getText()); // Get text on alert box
	 
	 javascriptprompt.accept();
	 javascriptprompt = myTestDriver.switchTo().alert();
	 
	System.out.println(javascriptprompt.getText()); // Get text on alert box
	 javascriptprompt.accept();
	 
	 
	 myTestDriver.findElement(By.xpath("//input[@value = 'prompt']")).click();
	 Thread.sleep(2000L);
	 javascriptprompt = myTestDriver.switchTo().alert();
	 
	 System.out.println(javascriptprompt.getText()); // Get text on alert box
	 
	javascriptprompt.dismiss();
	 javascriptprompt = myTestDriver.switchTo().alert();
	 System.out.println(javascriptprompt.getText()); // Get text on alert box
	 javascriptprompt.accept();
	 
	 Thread.sleep(2000L);
	 System.out.println("***********************************confirm dialog box****************************");
	 myTestDriver.findElement(By.xpath("//input[@value = 'confirm']")).click();
	 Thread.sleep(2000L);
	 Alert javascriptconfirm = myTestDriver.switchTo().alert();
	 javascriptconfirm.accept();
	 
	 javascriptconfirm = myTestDriver.switchTo().alert();
	 System.out.println(javascriptconfirm.getText()); // Get text on alert box
	 javascriptconfirm.accept();
	 
	 myTestDriver.findElement(By.xpath("//input[@value = 'confirm']")).click();
	 Thread.sleep(2000L);
	 javascriptconfirm = myTestDriver.switchTo().alert();
	 
	 javascriptconfirm.dismiss();
	 javascriptconfirm = myTestDriver.switchTo().alert();
	 System.out.println(javascriptconfirm.getText()); // Get text on alert box
	 javascriptconfirm.accept();
	 
	 myTestDriver.quit();
	 
	}
	 @Test
	 public void keyboardcontrol() throws Throwable
	 {

			WebDriver driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("http://www.google.com");
			Thread.sleep(4000);
			//controll keyboard
			Keyboard kb=((HasInputDevices)driver).getKeyboard();
			//press one key
			kb.pressKey(Keys.F5);
			//press multiple key
			kb.sendKeys(Keys.chord(Keys.COMMAND,Keys.SHIFT,"p"));//for window control instead of command
	 }
	 
	}


