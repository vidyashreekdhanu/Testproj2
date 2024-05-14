package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
@FindBy(xpath = "//img[@alt='Create Product...']")
private WebElement createNewProductBtn;
<<<<<<< HEAD
@FindBy(xpath = "(//input[@class='crmbutton small save'])[1]")
private WebElement saveBtn;
public WebElement getSaveBtn() {
	return saveBtn;
}
=======
@FindBy(xpath = "//input[@name='productname']")
private WebElement productEdit;

public WebElement getProductEdit() {
	return productEdit;
}

>>>>>>> branch 'master' of https://github.com/archanakshettyudupi/Testproj2.git
public WebElement getCreateNewProductBtn() {
	return createNewProductBtn;
}
}
