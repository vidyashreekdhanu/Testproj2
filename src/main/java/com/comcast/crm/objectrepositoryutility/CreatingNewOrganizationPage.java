package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.webdriverutility.WebDriverUtility;

public class CreatingNewOrganizationPage {
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="accountname")
	private WebElement orgNameEdit;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	@FindBy(name="industry")
	private WebElement industryDD;
	
	
	public WebElement getOrgNameEdit() {
		return orgNameEdit;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createOrgan(String orgName)
	{
		orgNameEdit.sendKeys(orgName);
		saveBtn.click();
	}
	public void createOrgWithIndustry(String orgName,String industry)
	{
		orgNameEdit.sendKeys(orgName);
		WebDriverUtility wlib=new WebDriverUtility();
		//wlib.select(industryDD, industry);
		Select sel=new Select(industryDD);
		sel.selectByVisibleText(industry);
		saveBtn.click();
	}
	public WebElement getIndustryDD() {
		return industryDD;
	}

}
