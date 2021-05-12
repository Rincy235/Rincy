package com.crm.vtigerReadDatafromPropertiesTests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class TC_04_createOppwithMapOrgclearOrgTest {
	@Test
	public void createOppwithMapOrgclearOrgTest() throws Throwable
	{
	// launch the browser
	System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
									
	/* read the data from properties File */
	
	FileInputStream fis = new FileInputStream("./Data/TC_commonData.properties");
	Properties pObj = new Properties();
	pObj.load(fis);
	    
	    
	//get URL
	driver.get(pObj.getProperty("url"));
					
	//Login to the application
	driver.findElement(By.name("user_name")).sendKeys(pObj.getProperty("username"));
	driver.findElement(By.name("user_password")).sendKeys(pObj.getProperty("password"));
	driver.findElement(By.id("submitButton")).click();
	
	// click on opportunities
	driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
	
	// click on add opportunity
	driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
	// enter the details
	driver.findElement(By.xpath("//input[@name='potentialname']")).sendKeys("OppNo"+JavaUtility.getRandomData());
	// click on select button
	driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
			
	// switch the window
	WebDriverUtility wd = new WebDriverUtility();
	wd.switchToWindow(driver, "Accounts");
	driver.findElement(By.xpath("//a[text()='TY Organization']")).click();
	wd.switchToWindow(driver, "Potentials");
	
	// click on clear organization
	driver.findElement(By.xpath("//input[@title='Clear']")).click();
	
	// click on save button 
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	// handle the alert
	driver.switchTo().alert().accept();
	
	// logout of the application
	WebElement target = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	WebElement dest = driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
	Actions act = new Actions(driver);
	act.moveToElement(target).perform();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click()", dest);
						
	// close the driver
	driver.close();
	}
}


