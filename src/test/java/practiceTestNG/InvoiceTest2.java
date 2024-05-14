package practiceTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseclassTest;

public class InvoiceTest2 {
	@Test(retryAnalyzer =com.comcast.crm.listenerUtility.RetryListenerImp.class)
	public void activateSim()
	{
	System.out.println("execute createInvoicetest");
	//Assert.assertEquals("", "Login");
	System.out.println("step_1");
	System.out.println("step_2");
	System.out.println("step_3");
	System.out.println("step_4");
	}
}
