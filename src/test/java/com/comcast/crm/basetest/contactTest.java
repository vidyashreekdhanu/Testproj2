package com.comcast.crm.basetest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.webdriverutility.UtilityClassObject;
@Listeners(com.comcast.crm.listenerUtility.ListimpClass.class)
public class contactTest extends BaseclassTest {
	@Test
		
			public void createContactTest() throws InterruptedException, EncryptedDocumentException, IOException {
			
					UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
				//FETCH TESTSCRIPTDATA FROM EXCEL
				String lastName = elib.getDataFromExcel("contact", 1, 2)+jlib.getRandomNumber();
		
				UtilityClassObject.getTest().log(Status.INFO, "navigate to contact Page");				
					HomePage hp=new HomePage(driver);
					//Assert.fail();
					hp.getContactLink().click();
					
					UtilityClassObject.getTest().log(Status.INFO, "navigate to create contact");
					ContactPage cp=new ContactPage(driver);
					cp.getCreateNewContactBtn().click();
					Thread.sleep(2000);
					
					UtilityClassObject.getTest().log(Status.INFO, lastName+"create new contact");
					CreatingNewContactPage cnp=new CreatingNewContactPage(driver);
					cnp.createContact(lastName);
					
					//verifyHeader info expected Result
					String actHeader =cp.getHeaderMsg().getText();
					boolean status = actHeader.contains(lastName);
					Assert.assertEquals(status, true);
					
					String actLastName=cnp.getLastNameInfo().getText();
					SoftAssert ass=new SoftAssert();
					ass.assertEquals(actLastName, lastName);
					ass.assertAll();
					
					}
	@Test
	public void  createContactWithOrgTest()throws InterruptedException, IOException {
		
		
		//FETECH FRROM EXCEL FILE						
		String orgName = elib.getDataFromExcel("contact", 7, 2)+jlib.getRandomNumber();
		String contactLastName = elib.getDataFromExcel("contact", 7, 3)+jlib.getRandomNumber();
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		
		//click on create organization button
		OrganizationsPage cnp=new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();
		Thread.sleep(2000);
		
		//enter all the details& create new organization
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver); 
		cnop.createOrgan(orgName);
		
		Thread.sleep(4000);
		hp.getContactLink().click();
		
		ContactPage cp=new ContactPage(driver);
		cp.getCreateNewContactBtn().click();
		//Thread.sleep(4000);
		
		//enter all the details& create new organization
		CreatingNewContactPage cnp1=new CreatingNewContactPage(driver);
		cnp1.getLastNameEdit().sendKeys(contactLastName);
		cnp1.getCreateOrgBtn().click();
		wlib.switchToTabOnUrl(driver,"module=Accounts" );
	cnp.getSearchEdit().sendKeys(orgName);
		cnp1.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		wlib.switchToTabOnTittle(driver, "module=Contacts");
		cnp1.getSaveBtn().click();
		
		
		String actHeaerInfo=cp.getContactOrgHeaderMsg().getText();
		boolean status = actHeaerInfo.contains(contactLastName);
		Assert.assertEquals(status, true);
		
		
		//String actOrgName = cp.getContactOrgName().getText();
		//boolean stat = actOrgName.contains(orgName);
		//Assert.assertEquals(stat, true);
		//String actLastName = cp.getcontactLastName().getText();
		//boolean status = actLastName.contains(contactLastName);
		//Assert.assertEquals(status, true);
		
		//verify contactOrgname ExpectedResult
		//String actContectOrgName =cnp.getContactOrgName().getText();
		//Assert.assertEquals(actContectOrgName, orgName);
		
				
				}
	@Test(groups = "regressionTest")
	public void createcontactWithSupportDateTest() throws EncryptedDocumentException, IOException, InterruptedException{
		
		String lastName = elib.getDataFromExcel("contact", 4, 2)+jlib.getRandomNumber();

		
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		
		ContactPage cp=new ContactPage(driver);
		cp.getCreateNewContactBtn().click();
		Thread.sleep(2000);
		
		//enter all the details& create new organization
		CreatingNewContactPage cnp=new CreatingNewContactPage(driver);

		String requiredDate=jlib.getSystemDateYYYYDDMM();
		String ReqcurrentDate=jlib.getRequiredDateYYYYDDMM(30);
		cnp.createContactWithSystemDate(lastName, requiredDate, ReqcurrentDate);
		}
	}



