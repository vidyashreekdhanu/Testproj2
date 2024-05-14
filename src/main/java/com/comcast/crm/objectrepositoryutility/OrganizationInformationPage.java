package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.webdriverutility.WebDriverUtility;

public class OrganizationInformationPage {
	
	WebDriver driver;
	public OrganizationInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(name = "phone")
	private WebElement phonenEdit;
	@FindBy(name = "button")
	private WebElement SaveBtn;
	@FindBy(name="accountname")
	private WebElement orgNameEdit;
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement contactOrgName;
	public WebElement getContactOrgName() {
		return contactOrgName;
	}
	public WebElement getOrgNameEdit() {
		return orgNameEdit;
	}
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	public WebElement getPhonenEdit() {
		return phonenEdit;
	}
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	public void createOrgWithPhoneno(String orgName,String phoneNumber) {
	orgNameEdit.sendKeys(orgName);
	WebDriverUtility wlib=new WebDriverUtility();
	wlib.waitForElementPresent(driver, phonenEdit);
	
	phonenEdit.sendKeys(phoneNumber);
	  SaveBtn.click();
	  
	}

}
