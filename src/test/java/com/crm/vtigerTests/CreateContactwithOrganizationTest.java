package com.crm.vtigerTests;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
public class CreateContactwithOrganizationTest {
	
	@Test
	public void createContactOrganization() throws Throwable
	{
	
		FileInputStream fis = new FileInputStream("./Data/TC_commonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		
		//Launch Browser
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
		//get URL
		driver.get("url");
				
		//Login to the application
		driver.findElement(By.name("user_name")).sendKeys("username");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		
		//Navigate to contacts
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Contacts")).click();
		
		//Create contact with Organization
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Robin");
		
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		
		Set<String> wh = driver.getWindowHandles();
		ArrayList<String> al = new ArrayList<String>(wh);
		driver.switchTo().window(al.get(1));
		driver.findElement(By.xpath("//a[contains(text(),'techM')]")).click();
		driver.switchTo().window(al.get(0));
		
		//To save the created contact
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//Logout from application
		WebElement administrator=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebElement signout=driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
		Actions action=new Actions(driver);
		action.moveToElement(administrator).click(signout).build().perform();
							
		// close the driver
		Thread.sleep(5000);
		driver.close();
	}

}
