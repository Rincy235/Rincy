package com.crm.vtiger.pomclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateOpportunitiesPage {
	WebDriver driver;
	public CreateOpportunitiesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="potentialname")
	private WebElement opportunityNameTF;
	
	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement relatedToTF;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBT;

	public WebElement getOpportunityNameTF() {
		return opportunityNameTF;
	}

	public WebElement getRelatedToTF() {
		return relatedToTF;
	}

	public WebElement getSaveBT() {
		return saveBT;
	}
	
	public void createOpportunities(String opportunityName) {
		WebDriverUtility wUtil = new WebDriverUtility();
		opportunityNameTF.sendKeys(opportunityName);
		relatedToTF.click();
		wUtil.switchToWindow(driver, "Accounts");
		driver.findElement(By.xpath("//a[text()='Test Yantra']")).click();
		saveBT.click();
	}
}
