package com.comcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databseutility.Databaseutility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.webdriverutility.JavaUtility;
import com.comcast.crm.webdriverutility.UtilityClassObject;
import com.comcast.crm.webdriverutility.WebDriverUtility;

public class BaseclassTest {
	//Create object
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib=new JavaUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	//public ExtentSparkReporter spark;
	//public ExtentReports report;

		@BeforeSuite
		public void configBS() throws SQLException
		{
			System.out.println("==connect Db, report Config===");
		//	dbLib.getDbConnection();
			/* spark=new ExtentSparkReporter("./AdvanceReport/report.html");
			spark.config().setDocumentTitle("CRM Test Suite Result");
			spark.config().setReportName("CRM Report");
			spark.config().setTheme(Theme.DARK);
			
			//Add Env information& create test
			 report=new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("OS", "Window-10");
			report.setSystemInfo("BROWSER", "CHROME=100");*/
		}
	
		@BeforeClass
		public void configBC(/*String browser*/) throws IOException
		{
			System.out.println("====Launch browser=====");
			String BROWSER =/* browser;*/flib.getDataFromPropertiesFile("browser");
			
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
			sdriver=driver;
			UtilityClassObject.setDriver(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		}
		@BeforeMethod
		public void configBM() throws IOException
		{
			System.out.println("====login=====");
			
			String URL=flib.getDataFromPropertiesFile("url");
			String USERNAME=flib.getDataFromPropertiesFile("username");
			String PASSWORD=flib.getDataFromPropertiesFile("password");
			LoginPage lp=new LoginPage(driver);
			lp.LoginToApp(URL, USERNAME, PASSWORD);
		}
		
	@AfterMethod
	public void configAM()
	{
		System.out.println("logout");
		HomePage hp=new HomePage(driver);
		hp.logout();
	}
	@AfterClass
	public void configAC() throws SQLException
	{
	System.out.println("=====close the Browser=====");
//	driver.quit();
	
	}@AfterSuite
	public void configAS() throws SQLException
	{
	System.out.println("====close Db, close report backup====");
	//dbLib.closeDbConnection();
	//report.flush();
	}
	}


