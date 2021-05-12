package com.crm.vtigerAllocatedUsingpomTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.pomclass.CreateOpportunitiesPage;
import com.crm.vtiger.pomclass.HomePage;
import com.crm.vtiger.pomclass.OpportunitiesPage;

public class TC_1_createOpportunitiesTest extends BaseClass {
	@Test
	public void createOpportunitiesTest() throws Throwable
	{
					
		String lastname = eUtil.getExcelData("opportunityPage", 1, 2);
		
		// navigate to opportunity page
		homePage = new HomePage(driver);
		homePage.clickOpportunitiesLink();
				
		// click on new opportunity image
		OpportunitiesPage oP = new OpportunitiesPage(driver);
		oP.clickOpportunitiesIMG();
				
		//click on create opportunity page
		CreateOpportunitiesPage cOP = new CreateOpportunitiesPage(driver);
		cOP.createOpportunities(lastname);
	}


}
