package com.crm.vtigerTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

//import com.crm.vtiger.GenericUtils.WebDriverUtility;

//import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class ContactMailMergeTest {
	@Test
	
	public void createMailMergeTest() throws InterruptedException
	{
		//WebDriverUtility wutil=new WebDriverUtility();
		//launch browser
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//get the URL
		driver.get("http://localhost:8888/");
		
		//login to the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
	
		//navigate to contacts
		driver.findElement(By.linkText("Contacts")).click();
				
		//click on mail merge template
		driver.findElement(By.linkText("Create Mail Merge templates")).click();
		Thread.sleep(3000);
		
		//click on browse button and select organization
		driver.findElement(By.xpath("//input[@class='small']")).sendKeys("C:\\assignment.txt");
		Thread.sleep(5000);
		
		//click on save button
		driver.findElement(By.xpath("//input[@title='Save']")).click();
				
		// logout of the application
		WebElement target = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebElement dest = driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
		Actions act = new Actions(driver);
		act.moveToElement(target).perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", dest);
									
		// close the driver
		Thread.sleep(5000);
		driver.close();
	}

}
