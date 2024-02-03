package com.testScripts;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.generic_Library.Base_Test;
import com.generic_Library.WebDriver_Utility;

public class TC002_AddToCart_Test extends Base_Test {

	@Test
	public void addToCartTest()
	{
		driver.findElement(By.partialLinkText("APPAREL & SHOES")).click();
		driver.findElement(By.xpath("//a[text()='Casual Golf Belt']/ancestor::div[@class='details']/descendant::input[@value='Add to cart']")).click();
		driver.findElement(By.partialLinkText("Shopping cart")).click();
		WebDriver_Utility.scrollToWebElement(driver, driver.findElement(By.xpath("//h1[text()='Shopping cart']")));
		try
		{
			
			WebDriver_Utility.takesScreenshotOfWebPage(driver, "ShoppingCartSS");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
