package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parralel
{
	public WebDriver driver;
	 
	  @Parameters("browser")
	 
	  @BeforeClass
	 
	  // Passing Browser parameter from TestNG xml
	 
	  public void beforeTest(String browser) {
	 
	  // If the browser is Firefox, then do this
	 
	  if(browser.equalsIgnoreCase("firefox")) {
	 
	  driver = new FirefoxDriver();
	 
	  // If browser is IE, then do this   
	 
	  }else if (browser.equalsIgnoreCase("ie")) {
	 
	  // Here I am setting up the path for my IEDriver
	 
	  System.setProperty("webdriver.ie.driver", "C:/driver/IEDriverServer.exe");
	 
	  driver = new InternetExplorerDriver();
	 
	  }
	 
	  // Doesn't the browser type, lauch the Website
	 
	  driver.get("http://www.facebook.com");
	  driver.manage().window().maximize();
	 
	  }
	 
	  // Once Before method is completed, Test method will start
	 
	  @Test public void login() throws InterruptedException {

	    driver.findElement(By.id("email")).sendKeys("testuser_1");
	 
	    driver.findElement(By.id("pass")).sendKeys("Test@123");
	 
	    driver.findElement(By.id("u_0_n")).click();
	 
	}  
	 
	  @AfterClass public void afterTest() throws InterruptedException {
	   Thread.sleep(3000);
	   driver.quit();
	 
	}


}
