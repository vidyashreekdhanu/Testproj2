package com.comcast.crm.contacttest;

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
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.webdriverutility.JavaUtility;
import com.comcast.crm.webdriverutility.WebDriverUtility;

public class CreateContactTest extends BaseclassTest {
	
	@Test
	
		public void createContactTest() throws InterruptedException, EncryptedDocumentException, IOException {
		
				
			//FETCH TESTSCRIPTDATA FROM EXCEL
			String lastName = elib.getDataFromExcel("contact", 1, 2)+jlib.getRandomNumber();
	
								
				HomePage hp=new HomePage(driver);
				hp.getContactLink().click();
				
				ContactPage cp=new ContactPage(driver);
				cp.getCreateNewContactBtn().click();
				Thread.sleep(2000);
				
				//enter all the details& create new organization
				CreatingNewContactPage cnp=new CreatingNewContactPage(driver);
				cnp.createContact(lastName);
				System.out.println("last");
				//verify lastname ExpectedResult
				/*String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
				if( actLastName.contains(lastName))
				{
					System.out.println( actLastName +" information is verified==PASS");
				}
				else
				{
					System.out.println(actLastName +" information is verified==FAIL");
				}*/
				
				
				

	}

}
