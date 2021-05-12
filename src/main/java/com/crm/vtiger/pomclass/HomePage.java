package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorIMG;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutLink;
	
	public WebElement getAdmininstratorIMG() {
		return administratorIMG;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}
	
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	/**
	 * click on opportunities link
	 */
	public OpportunitiesPage clickOpportunitiesLink() {
		opportunitiesLink.click();
		return new OpportunitiesPage(driver);
		}

	/**
	 * click on Sign-out
	 */
	public void signOut() {
		mouseOver(driver, administratorIMG);
		signOutLink.click();
}
}
