package practice.ddt;

import org.testng.annotations.Test;

import org.testng.xml.XmlTest;

public class CreateCustomerTest {

	@Test
	public void createCustomerText(XmlTest xml)
	{
		System.out.println("execute test1");
		String BROWSER = xml.getParameter("browser");
		System.out.println(BROWSER);
	}
}
