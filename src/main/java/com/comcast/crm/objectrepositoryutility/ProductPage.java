package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
@FindBy(xpath = "//img[@alt='Create Product...']")
private WebElement createNewProductBtn;
@FindBy(xpath = "//input[@name='productname']")
private WebElement productEdit;

public WebElement getProductEdit() {
	return productEdit;
}

public WebElement getCreateNewProductBtn() {
	return createNewProductBtn;
}
}
