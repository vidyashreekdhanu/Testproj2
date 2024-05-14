package com.comcast.crm.basetest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class orgTest extends BaseclassTest {
	@Test(groups = "smokeTest")
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
	}
	@Test(groups = "regressionTest")
	public  void CrOrgWithInduTest() throws IOException, InterruptedException {
				
				String orgName = elib.getDataFromExcel("org", 4, 2)+jlib.getRandomNumber();
				String industry = elib.getDataFromExcel("org", 4, 3);
				String type = elib.getDataFromExcel("org", 4, 4);
				
				
				
				HomePage hp=new HomePage(driver);
				hp.getOrgLink().click();
				
				
				//click on create organization button
				OrganizationsPage cnp=new OrganizationsPage(driver);
				cnp.getCreateNewOrgBtn().click();
				Thread.sleep(2000);
				
				//enter all the details& create new organization
				CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver); 
				//cnop.createOrgan(orgName);
				
				Thread.sleep(2000);
				 cnop.createOrgWithIndustry(orgName, industry);
				 Thread.sleep(2000);
				}
	@Test(groups = "regressionTest")
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
		Thread.sleep(2000);
	}
				
				
				

	}



	
		
		
		
		

	


