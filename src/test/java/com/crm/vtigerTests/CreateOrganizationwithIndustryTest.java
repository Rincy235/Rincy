package com.crm.vtigerTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateOrganizationwithIndustryTest {
	@Test
	public void createOrganizationwithIndustry() throws InterruptedException
	{
		//Launch Browser
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
		//get URL
		driver.get("http://localhost:8888");
				
		//Login to the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
				
		//Navigate to Organization
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Organizations")).click();
				
		//Create Organization with industry
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("Team");
		WebElement industry = driver.findElement(By.xpath("//select[@name='industry']"));
	    Select sel = new Select(industry);
	    Thread.sleep(2000);
	    sel.selectByVisibleText("Education");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
		//Logout from application
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebElement dest = driver.findElement(By.xpath("(//a[@class='drop_down_usersettings'])[2]"));
		Actions act = new Actions(driver); //To perform mouse and keyboard action
		act.moveToElement(element).perform();//to move the cursor
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", dest);
				
	}

}
	

