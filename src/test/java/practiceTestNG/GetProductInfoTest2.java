package practiceTestNG;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoTest2 {
	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandname,String productName)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://amazon.in");
		
		//search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
		
		//capture productInfo
		String x="//span[text()='"+productName+"']/../../../../div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
		String price=driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
	
		}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{	ExcelUtility elib=new ExcelUtility();
	int count = elib.getRowcount("product");
		Object[][] objArr=new Object[count][2];
		for(int i=0;i<count;i++)
		{
			objArr[i][0]=elib.getDataFromExcel("product", i+1, 0);
			objArr[i][1]=elib.getDataFromExcel("product", i+1, 1);
		}
		

				
		return objArr;
	}
}
