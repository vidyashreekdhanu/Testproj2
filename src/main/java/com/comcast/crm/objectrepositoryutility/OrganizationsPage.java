package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	WebDriver driver;
	public OrganizationsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//img[@title='Create Organization...']")
	private WebElement createNewOrgBtn;
	@FindBy(name = "search_text")
	private WebElement searchEdit;
	@FindBy(name = "search_field")
	private WebElement searchDD;
	@FindBy(name="submit")
	private WebElement serachBtn;
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement contactOrgName;
	public WebElement getContactOrgName() {
		return contactOrgName;
	}
	
	public WebElement getSerachBtn() {
		return serachBtn;
	}

	public WebElement getSearchEdit() {
		return searchEdit;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
}
