package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
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
import com.comcast.crm.webdriverutility.JavaUtility;
import com.comcast.crm.webdriverutility.WebDriverUtility;

public class createcontactWithSupportDateTest extends BaseclassTest{
	@Test
	public void createcontactWithSupportDateTest() throws EncryptedDocumentException, IOException, InterruptedException{
		
		String lastName = elib.getDataFromExcel("contact", 4, 2)+jlib.getRandomNumber();

		
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		
		ContactPage cp=new ContactPage(driver);
		cp.getCreateNewContactBtn().click();
		Thread.sleep(2000);
		
		//enter all the details& create new organization
		CreatingNewContactPage cnp=new CreatingNewContactPage(driver);
		//cnp.createContact(lastName);
		
		
		
		//login to app
		
				
		//enter all the details& create new organization
		String requiredDate=jlib.getSystemDateYYYYDDMM();
		String ReqcurrentDate=jlib.getRequiredDateYYYYDDMM(30);
		cnp.createContactWithSystemDate(lastName, requiredDate, ReqcurrentDate);
		
		
		
		//driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		Thread.sleep(2000);
		
		//verify startDate and endDate ExpectedResult
		
		/*String actstartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if( actstartDate.equals(startDate))
		{
			System.out.println( startDate +" information is verified==PASS");
		}
		else
		{
			System.out.println(startDate +" information is verified==FAIL");
		}
		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if( actEndDate.equals(endDate))
		{
			System.out.println( endDate +" information is verified==PASS");
		}
		else
		{
			System.out.println(endDate +" information is verified==FAIL");
		}*/

		
	}
	
}

