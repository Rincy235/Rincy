package com.crm.vtigerAllocatedTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC_02_createOppwithoutMandatoryValuesTest {
	@Test
	public void createOppwithoutMandatoryValuesTest() throws Throwable
	{
		// launch the browser
				System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
				WebDriver driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
												
				//get the url
				driver.get("http://localhost:8888/");
												
				// login to the application
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
												
				//Navigate to Opportunity
				driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
				
				// click on create opprotunity
				driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
				
				// click on save button without entering any thing
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				Thread.sleep(2000);
				
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
