package com.learningTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.generic_Library.File_Utility;

public class Learning_Excel_File_2 {
	
@DataProvider(name = "flipkartSearchData")

public Object[][] searchData()throws Throwable
{
return File_Utility.getMultipleDataFromExcelFile("searchData");
}

@Test(dataProvider = "flipkartSearchData")
public void searchFlipkartTest(String search) throws Throwable
{
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.flipkart.com/");
	driver.findElement(By.name("q")).sendKeys(search,Keys.ENTER);
	Thread.sleep(2000);
	driver.quit();
}
}
