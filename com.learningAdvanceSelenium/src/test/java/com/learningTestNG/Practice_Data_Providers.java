package com.learningTestNG;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Practice_Data_Providers {
@Test(dataProvider = "searchData")
public void searchTestCase(String searchData) throws InterruptedException
{
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://demowebshop.tricentis.com/");
	Assert.assertEquals(driver.getTitle(), "Demo Web Shop", "I am Validating Title");
	driver.findElement(By.linkText("Log in")).click();
	Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/login");
	driver.findElement(By.id("Email")).sendKeys("shubhamvjvrg@gmail.com");
	driver.findElement(By.id("Password")).sendKeys("Shubham123");
	driver.findElement(By.xpath("//input[@value='Log in']")).click();
	driver.findElement(By.name("q")).sendKeys(searchData);
	driver.findElement(By.xpath("//input[@value='Search']")).click();
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest = new File("./src/test/resources/screenshots/"+searchData+"ss.jpeg");
	Thread.sleep(2000);
	driver.quit();
	try
	{
		FileHandler.copy(src, dest);
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
@DataProvider(name = "searchData")
public Object searchData()
	{
		Object data[][]= new Object[20][1];
		
		data[0][0]="Jacket";
		data[1][0]="Mobile";
		data[2][0]="Books";
		data[3][0]="Laptop";
		data[4][0]="Pen";
		data[5][0]="Pencil";
		data[6][0]="Eraser";
		data[7][0]="chrger";
		data[8][0]="cable";
		data[9][0]="Car";
		data[10][0]="House";
		data[11][0]="Bike";
		data[12][0]="AirFreshner";
		data[13][0]="Induction";
		data[14][0]="Bottle";
		data[15][0]="Tiffin";
		data[16][0]="Adapter";
		data[17][0]="Jeans";
		data[18][0]="Shirt";
		data[19][0]="Tshirt";
		
		return data;
		
	}

}
