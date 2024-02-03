package com.learningTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Learning_Hard_Assert {
	@Test
	public void loginTestCase()
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
    	Assert.assertEquals(driver.getTitle(), "Flipkart");
	}
}
