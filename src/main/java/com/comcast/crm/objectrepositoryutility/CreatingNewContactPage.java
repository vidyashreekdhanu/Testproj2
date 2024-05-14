package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.webdriverutility.JavaUtility;

public class CreatingNewContactPage {
	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(name="lastname")
private WebElement lastNameEdit;

@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
private WebElement saveBtn;

@FindBy(xpath = "(//img[@alt='Select'])[1]")
private WebElement createOrgBtn;

@FindBy(id="search_txt")
private WebElement searchEdit;

@FindBy(name = "search_field")
private WebElement serchField;

@FindBy(name = "search")
private WebElement searchBtn;

@FindBy(name="support_end_date")
private WebElement reqDate;

@FindBy(name="support_start_date")
private WebElement currentDate;
@FindBy(id = "dtlview_Last Name")
private WebElement lastNameInfo;




public WebElement getLastNameInfo() {
	return lastNameInfo;
}
public WebElement getLastNameEdit() {
	return lastNameEdit;
}
public WebElement getCreateOrgBtn() {
	return createOrgBtn;
}
public WebElement getSearchEdit() {
	return searchEdit;
}
public WebElement getSerchField() {
	return serchField;
}
public WebElement getSearchBtn() {
	return searchBtn;
}
public WebElement getReqDate() {
	return reqDate;
}
public WebElement getCurrentDate() {
	return currentDate;
}
public void createContact(String lastName)
{
	lastNameEdit.sendKeys(lastName);
	saveBtn.click();
}
public void createContactWithSystemDate(String lastName,String requiredDate,String ReqcurrentDate)
{
	lastNameEdit.sendKeys(lastName);
	reqDate.clear();
JavaUtility jlib=new JavaUtility();
//String requiredDate = jlib.getRequiredDateYYYYDDMM(30);
//String ReqcurrentDate = jlib.getSystemDateYYYYDDMM();
reqDate.sendKeys(requiredDate);
currentDate.sendKeys(ReqcurrentDate);
	saveBtn.click();
}
public WebElement getSaveBtn() {
	return saveBtn;
}





}