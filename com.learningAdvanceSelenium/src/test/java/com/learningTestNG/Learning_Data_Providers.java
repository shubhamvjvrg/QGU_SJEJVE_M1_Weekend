package com.learningTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Learning_Data_Providers {
	@Test(dataProvider = "loginData")
	public void loginTestCase(String username, String password)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	driver.get("https://demowebshop.tricentis.com/");
    	Assert.assertEquals(driver.getTitle(), "Demo Web Shop", "I am Validating Title");
    	driver.findElement(By.linkText("Log in")).click();
    	Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/login");
    	driver.findElement(By.id("Email")).sendKeys(username);
    	driver.findElement(By.id("Password")).sendKeys(password);
    	driver.findElement(By.xpath("//input[@value='Log in']")).click();
    	Assert.assertEquals(driver.getTitle(), "Flipkart");
	}
	@DataProvider(name="loginData")
	public Object loginData()
	{
		Object [][] data = new Object[3][2];
		data[0][0]="shubhamvjvrg@gmail.com";
		data[0][1]="Shubham@123";
		data[1][0]="shubham@gmail.com";
		data[1][1]="Shubham@123";
		data[2][0]="shubham123@gmail.com";
		data[2][1]="Shubham@123";
		return data;
	}
	
}
