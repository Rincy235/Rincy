package Sqlconnection;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CaptureDynamicWebtable {

	@Test
	public void captureOrgName()
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
		
		//Step 4: Capture all the organization names
		String x = "//table[@class='lvt small']/tbody/tr[*]/td[3]";
		List<WebElement> list = driver.findElements(By.xpath(x));
		
		for(int i=1;i<list.size();i++)
		{ 
			System.out.println(list.get(i).getText());
		}
		driver.close();
	}
}
