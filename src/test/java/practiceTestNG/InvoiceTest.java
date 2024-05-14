package practiceTestNG;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseclassTest;
@Listeners(com.comcast.crm.listenerUtility.ListimpClass.class)
public class InvoiceTest extends BaseclassTest {
@Test
public void createInvoiceTest()
{
System.out.println("execute createInvoicetest");
String title = driver.getTitle();
Assert.assertEquals(title, "Home");
System.out.println("step_1");
System.out.println("step_2");
System.out.println("step_3");
System.out.println("step_4");
}
@Test
public void createInvoicewithContactTest()
{
	System.out.println("execute createInvoicewithContactTest");
	System.out.println("step_1");
	System.out.println("step_2");
	System.out.println("step_3");
	System.out.println("step_4");
}
}
