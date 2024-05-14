package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseclassTest;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.webdriverutility.JavaUtility;
import com.comcast.crm.webdriverutility.WebDriverUtility;
@Test
public class CreateOrganizationWithIndustriesTest extends BaseclassTest {
	@Test
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
				
				/*//navigate to organization module
				driver.findElement(By.linkText("Organizations")).click();
				
				//click on create organization button
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				Thread.sleep(2000);
				
				//enter all the details& create new organization
				driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
				Thread.sleep(2000);
				WebElement ele1 = driver.findElement(By.name("industry"));
				wlib.select(ele1, industry);
				//Select sel=new Select(ele1);
				//sel.selectByIndex(10);
				WebElement ele2 = driver.findElement(By.name("accounttype"));
				wlib.select(ele2, type);
				//Select sel1=new Select(ele2);
				//sel1.selectByIndex(7);
				driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
				Thread.sleep(2000);
				
				//verify industries and type info
				String actIndustries = driver.findElement(By.id("dtlview_Industry")).getText();
				if(actIndustries.trim().equals(industry))
				{
					System.out.println(industry +" information is verified==PASS");
				}
				else
				{
					System.out.println(industry +" information is not verified==FAIL");
				}
				//verify type information
				String actType = driver.findElement(By.id("dtlview_Type")).getText();
				if(actType.trim().equals(type))
				{
					System.out.println(type +" information is verified==PASS");
				}
				else
				{
					System.out.println(type +" information is not verified==FAIL");
				}
				*/
				

	}

}
