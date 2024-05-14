package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver;
	public ContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;
	public WebElement getHeaderMsg() {
		return headerMsg;
		
	}
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createNewContactBtn;
	@FindBy(className = "dvHeaderText")
	private WebElement contactOrgHeaderMsg;
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement contactOrgName;
	
	public WebElement getContactOrgName() {
		return contactOrgName;
	}
	public WebElement getContactOrgHeaderMsg() {
		return contactOrgHeaderMsg;
	}
	@FindBy(id = "mouseArea_Last Name")
	private WebElement contactLastName;
	public WebElement getcontactLastName() {
		return contactLastName;
	}
	public WebElement getCreateNewContactBtn() {
		return createNewContactBtn;
	}

}
