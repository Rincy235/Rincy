package seleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridPractice {
	@Test
	public void gridPractice() throws MalformedURLException {
		RemoteWebDriver driver;
		
		URL url = new URL("");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		
		cap.setPlatform(Platform.WINDOWS);
		
	}

}
