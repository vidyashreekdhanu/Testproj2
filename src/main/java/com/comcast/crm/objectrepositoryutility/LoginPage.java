package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{//Rule1 seperate java class
	//Rule2 Object creation
	
	
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement userEdit;
	
	@FindBy(name="user_password")
	private WebElement passwordEdit;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;		//Rule3 Object Intialization
	
	//Rule4 Object Encapsulation

	public WebElement getUserEdit() {
		return userEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//rule 5:provide Action
	
	public void LoginToApp(String url,String username,String password)
	{	waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		userEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginBtn.click();
		
		
	}
	
	
	

}
