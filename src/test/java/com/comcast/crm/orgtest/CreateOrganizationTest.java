package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseclassTest;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.webdriverutility.JavaUtility;
import com.comcast.crm.webdriverutility.WebDriverUtility;
@Test
public class CreateOrganizationTest extends BaseclassTest {
	@Test
	public void createOrgTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		
		
		
	String orgName = elib.getDataFromExcel("org", 1, 2)+jlib.getRandomNumber();
		
		
		
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
	/*	OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		if(actOrgName.contains(orgName))
		{
			System.out.println(orgName+"name is verified==PASS");
		}else
		{
			System.out.println(orgName+"name is not verified==FAIL");
		}*/
		
		
		
		

	}
	


}



