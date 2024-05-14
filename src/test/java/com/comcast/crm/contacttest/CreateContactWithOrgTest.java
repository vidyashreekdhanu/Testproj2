package com.comcast.crm.contacttest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseclassTest;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactWithOrgTest extends BaseclassTest {
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
				
				//login to app
			/*	wlib.waitForPageToLoad(driver);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.get("http://localhost:8888");
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				Thread.sleep(2000);
				//navigate to organization module
				driver.findElement(By.linkText("Organizations")).click();
				
				//click on create organization button
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				Thread.sleep(2000);
				
				//enter all the details& create new organization
				driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
				Thread.sleep(2000);
				
				
				//navigate to contact module
				driver.findElement(By.linkText("Contacts")).click();
				
				//click on create contact button
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				Thread.sleep(2000);
				
				//enter all the details& create new organization
				driver.findElement(By.name("lastname")).sendKeys(contactLastName);
				driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
				
				//switch to child window
				wlib.switchToTabOnUrl(driver, "module=Accounts");
				driver.findElement(By.name("search_text")).sendKeys(orgName);
				driver.findElement(By.name("search")).click();
				
				Thread.sleep(2000);
				
				
				//switch to parent window
				wlib.switchToTabOnTittle(driver, "Contacts&action");
				driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
				Thread.sleep(2000);*/
				//verify Lastname ExpectedResult
				String actLastName = driver.findElement(By.id("mouseArea_Last Name")).getText();
				if(actLastName.trim().equals(contactLastName))
				{
					System.out.println(contactLastName +" is verified is PASS");
				}
				else
				{
					System.out.println(contactLastName +" is  not verified is FAIL");
				}
				//verify contactOrgname ExpectedResult
				String actContectOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
				if(actContectOrgName.trim().equals(orgName))
				{
					System.out.println(orgName +" is verified is PASS");
				}
				else
				{
					System.out.println(orgName +" is  not verified is FAIL");
				}
				Thread.sleep(5000);
				


		
	}

}
