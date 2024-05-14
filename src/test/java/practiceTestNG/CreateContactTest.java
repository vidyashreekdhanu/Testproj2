package practiceTestNG;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.LoginPage;

/**
 * @author Archana
 */

public class CreateContactTest {
	/**
	 * Scenario:login()===>navigateContact===>
	 */
	@Test
	public void searchcontactTest(WebDriver driver)
	{
		/*step1: login to app*/
		LoginPage lp=new LoginPage(driver);
	
		}
	

}
