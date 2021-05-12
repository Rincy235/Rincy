package Sqlconnection;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class captuOrg {
	
	@Test
	public void captureParticularData()
	{
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Step 1: Get URL
		driver.get("http://localhost:8888");
		
		//Step 2: Login to the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3: Navigate to Organizations
		driver.findElement(By.linkText("Organizations")).click();
		String expData="Skillrary412";
		Boolean flag=false;
		
		//Step 4: Check whether mentioned organization is present or not
		String x = "//table[@class='lvt small']/tbody/tr[*]/td[3]/a";
		List<WebElement> list = driver.findElements(By.xpath(x));
		for(WebElement wb:list)
		{
			String actData = wb.getText();
			if(expData.equals(actData))
			{
				wb.click();
				flag=true;
				break;
			}
		}
		
		if(flag)
		{
			System.out.println("Organisation is present");
		}
		else
		{
			System.out.println("Organisation is not present");
		}
		driver.close();
	}
	
	

}
