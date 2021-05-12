package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	WebDriver driver;
	public OpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//img[@title='Create Opportunity...']")
	private WebElement createOpportunitiesIMG;

	public WebElement getCreateOpportunitiesIMG() {
		return createOpportunitiesIMG;
	}

	//business class
	public void clickOpportunitiesIMG() {
		createOpportunitiesIMG.click();
	}
}
