package com;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Parameter 
{
	private static WebDriver driver;
	 
	  @Test
	 
	  @Parameters({ "sUsername", "sPassword" })
	 
	  public void test(String sUsername, String sPassword) {
	 
	      driver = new FirefoxDriver();
	      driver.manage().window().maximize();
	 
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	      driver.get("http://www.facebook.com");
	 
	      driver.findElement(By.id("email")).sendKeys(sUsername);
	 
	      driver.findElement(By.id("pass")).sendKeys(sPassword);
	 
	      driver.findElement(By.id("u_0_n")).click();
	 
	      driver.quit();
	 
	  }
	 
}
