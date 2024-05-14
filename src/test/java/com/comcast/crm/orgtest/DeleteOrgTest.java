package com.comcast.crm.orgtest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.webdriverutility.JavaUtility;
import com.comcast.crm.webdriverutility.WebDriverUtility;

public class DeleteOrgTest {
public static void main(String[] args) throws InterruptedException, IOException {
		
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		
		//Read from propertyFile
		String BROWSER=flib.getDataFromPropertiesFile("browser");
		String URL=flib.getDataFromPropertiesFile("url");
		String USERNAME=flib.getDataFromPropertiesFile("username");
		String PASSWORD=flib.getDataFromPropertiesFile("password");
		
		
	String orgName = elib.getDataFromExcel("org", 10, 2)+jlib.getRandomNumber();
		
		System.out.println(orgName);

		WebDriver driver=null;
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
		}else
		{
			driver=new ChromeDriver();
		}
		
		//login to app
		
		wlib.waitForPageToLoad(driver);
		driver.get(URL);
		
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp("http://localhost:8888","admin", "admin");
		
		Thread.sleep(2000);
		//navigate to organization module
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		
		//click on create organization button
		OrganizationsPage cnp=new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();
		Thread.sleep(2000);
		
		//enter all the details& create new organization
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver); 
		cnop.createOrgan(orgName);
		
		Thread.sleep(2000);
		
		//verify Header msg ExpectedResult
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		if(actOrgName.contains(orgName))
		{
			System.out.println(orgName+"name is verified==PASS");
		}else
		{
			System.out.println(orgName+"name is not verified==FAIL");
		}
		
		//go back to Organaization Page
		hp.getOrgLink().click();
		//search for Organization
		cnp.getSearchEdit().sendKeys(orgName);
		wlib.select(cnp.getSearchDD(), "Organization Name");
		cnp.getSerachBtn().click();
		
		//In dynamic element select @delete org
		
		driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[7]/a[text()='del']")).click();
		//logout
		hp.logout();
		
		driver.quit();

	}


}
