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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseclassTest;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.webdriverutility.JavaUtility;
import com.comcast.crm.webdriverutility.WebDriverUtility;

public class CreateorgWithPhonenumberTest extends BaseclassTest {
@Test
public void phonenumbertest() throws InterruptedException, EncryptedDocumentException, IOException {
	
	String orgName = elib.getDataFromExcel("org", 7, 2)+jlib.getRandomNumber();
	String phoneNumber = elib.getDataFromExcel("org", 7, 3);
					
	HomePage hp=new HomePage(driver);
	hp.getOrgLink().click();
	
	
	//click on create organization button
	OrganizationsPage cnp=new OrganizationsPage(driver);
	cnp.getCreateNewOrgBtn().click();
	Thread.sleep(2000);
	
	//enter all the details& create new organization
	//CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver); 
	//cnop.createOrgan(orgName);
	
	Thread.sleep(2000);
	OrganizationInformationPage oip=new OrganizationInformationPage(driver);
	oip.createOrgWithPhoneno(orgName, phoneNumber);
	//wlib.waitForElementPresent(driver, );
	//oip.getPhonenEdit().sendKeys(phoneNumber);
	//oip.getPhoneSaveBtn().click();
	Thread.sleep(10);
			
			
			
			//navigate to organization module
			/*driver.findElement(By.linkText("Organizations")).click();
			
			//click on create organization button
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			Thread.sleep(2000);
			
			//enter all the details& create new organization
			driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
			Thread.sleep(2000);
			driver.findElement(By.id("phone")).sendKeys(phoneNumber);
			driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
			Thread.sleep(2000);
			
			//verify phoneNumberinfo ExpectedResult
			String actPhoneNumber = driver.findElement(By.id("dtlview_Phone")).getText();
			if(actPhoneNumber.trim().equals(phoneNumber))
			{
				System.out.println(actPhoneNumber+" is created is PASS");
			}
			else
			{
				System.out.println(actPhoneNumber +" is not created is FAIL");
			}
			
			*/
			
			
			

}
}
