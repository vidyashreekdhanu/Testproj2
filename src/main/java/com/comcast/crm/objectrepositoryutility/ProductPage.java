package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
@FindBy(xpath = "//img[@alt='Create Product...']")
private WebElement createNewProductBtn;
@FindBy(xpath = "(//input[@class='crmbutton small save'])[1]")
private WebElement saveBtn;
public WebElement getSaveBtn() {
	return saveBtn;
}
public WebElement getCreateNewProductBtn() {
	return createNewProductBtn;
}
}
