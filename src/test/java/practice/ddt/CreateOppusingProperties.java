package practice.ddt;

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

public class CreateOppusingProperties {
 @Test
 public void createOppusingProperties() throws Throwable
 {
	//Launch Browser
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
			/* read the data from properties File */
			  //step-1 : get the java representation object of the Physical file*/
			FileInputStream fis = new FileInputStream("./AppCredential/commonData.properties");
			    
			  //step-2 : create an Object of the Properties class & load the all keys:value pair
			    Properties pObj = new Properties();
			    pObj.load(fis);
			    
			    
			  //get URL
			driver.get(pObj.getProperty("url"));
							
			//Login to the application
			driver.findElement(By.name("user_name")).sendKeys(pObj.getProperty("username"));
			driver.findElement(By.name("user_password")).sendKeys(pObj.getProperty("password"));
			driver.findElement(By.id("submitButton")).click();
					
			//Navigate to Opportunities
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.linkText("Opportunities")).click();
					
			//Create Opportunities
			driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
					
			//Enter the details
			driver.findElement(By.xpath("//input[@name='potentialname']")).sendKeys("OppNo"+JavaUtility.getRandomData());
					
			//Click on related to button
			driver.findElement(By.xpath("//input[@name='related_to_display']/following-sibling::img[@alt='Select']")).click();
								
			// switch the window
			WebDriverUtility wd = new WebDriverUtility();
			wd.switchToWindow(driver, "Accounts");
			driver.findElement(By.xpath("//a[contains(text(),'techM')]")).click();
			wd.switchToWindow(driver, "Potentials");
					
		    // click on save button
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					
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
