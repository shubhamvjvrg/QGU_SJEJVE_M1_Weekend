package com.testScripts;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.generic_Library.WebDriver_Utility;

public class TC003_RemoveFromCart_Test extends TC002_AddToCart_Test {

	@Test
	public void removeFromCartTest()
	{
		driver.findElement(By.partialLinkText("Shopping cart")).click();
		WebDriver_Utility.scrollToWebElement(driver, driver.findElement(By.xpath("//h1[text()='Shopping cart']")));
		driver.findElement(By.xpath("//a[text()='Casual Golf Belt']/ancestor::tr[@class='cart-item-row']/descendant::input[@name='removefromcart']")).click();
		driver.findElement(By.name("updatecart")).click();
		try
		{
			
			WebDriver_Utility.takesScreenshotOfWebPage(driver, "afterRemoveShoppingCartSS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
