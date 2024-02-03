package com.testScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.generic_Library.Base_Test;
import com.generic_Library.Base_Test_2;
import com.generic_Library.WebDriver_Utility;

public class TC001_SearchTest extends Base_Test_2{

	@Test
	public void searchTest() throws Throwable
	{
		driver.findElement(By.name("q")).sendKeys("mobile");
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		test.log(Status.PASS, "Product Searched");
		WebDriver_Utility.takesScreenshotOfWebPage(driver, "SearchSS");
			
		
	
	}
	
}
