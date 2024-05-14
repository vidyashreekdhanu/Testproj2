package com.comcast.crm.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
public void waitForElementPresent(WebDriver driver,WebElement ele)
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(ele));
}
public void switchToTabOnUrl(WebDriver driver,String partialUrl)
{
	Set<String> id = driver.getWindowHandles();
	Iterator<String> it = id.iterator();
	while(it.hasNext())
	{
		String windowID = it.next();
		driver.switchTo().window(windowID);
		String actUrl = driver.getCurrentUrl();
		if(actUrl.contains(partialUrl))
		{
			break;
		}
	}
}
public void switchToTabOnTittle(WebDriver driver,String partialTitle)
{
	Set<String> id1 = driver.getWindowHandles();
	Iterator<String> it1 = id1.iterator();
	while(it1.hasNext())
	{
		String windowID1 = it1.next();
		driver.switchTo().window(windowID1);
		String actUrl = driver.getTitle();
		if(actUrl.contains(partialTitle))
		{
			break;
		}
	}
}
public void switchToFrame(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}
public void switchToFrame(WebDriver driver,String nameId)
{
	driver.switchTo().frame(nameId);
}
public void switchToFrame(WebDriver driver,WebElement ele)
{
	driver.switchTo().frame(ele);
}
public void switchToAlertAndAccept(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
public void switchToAlertAndCancel(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
public void select(WebElement ele,String text)
{
	Select sel=new Select(ele);
	sel.selectByVisibleText(text);
}
public void select(WebElement ele,int index)
{
	Select sel=new Select(ele);
	sel.selectByIndex(index);
}
public void mouseMoveOnElement(WebDriver driver,WebElement ele)
{
	Actions act=new Actions(driver);
	act.moveToElement(ele).perform();
}
public void doubleClick(WebDriver driver,WebElement ele)
{
	Actions act=new Actions(driver);
	act.doubleClick(ele).perform();
}

}



