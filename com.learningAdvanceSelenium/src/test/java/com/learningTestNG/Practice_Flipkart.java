package com.learningTestNG;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Practice_Flipkart {

	@Test
	public void practiceFlipkart() throws Throwable
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com");
		driver.findElement(By.name("q")).sendKeys("mobile",Keys.ENTER);
		WebElement minDD = driver.findElement(By.xpath("(//select[@class= '_2YxCDZ'])[1]"));
		WebElement maxDD = driver.findElement(By.xpath("(//select[@class= '_2YxCDZ'])[2]"));
		Select sel1 = new Select(minDD);
		sel1.selectByValue("30000");
		Select sel2 = new Select(maxDD);
		sel2.selectByValue("Max");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",driver.findElement(By.xpath("//div[text()='SAMSUNG']/..//div[contains(@class,'24')]")) );
		Thread.sleep(2000);
		js.executeScript("arguments[0].click()",driver.findElement(By.xpath("//div[text()='4★ & above']/..//div[contains(@class,'24')]")) );
		Thread.sleep(2000);
		js.executeScript("arguments[0].click()",driver.findElement(By.xpath("//div[text()='Internal Storage']")) );
		Thread.sleep(2000);
		js.executeScript("arguments[0].click()",driver.findElement(By.xpath("//div[text()='128 - 255.9 GB']")) );
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[text()='SAMSUNG']/..//div[contains(@class,'24')]")).click();
//		driver.findElement(By.xpath("//div[text()='4★ & above']/..//div[contains(@class,'24')]")).click();
//		driver.findElement(By.xpath("//div[text()='Internal Storage']")).click();
//		driver.findElement(By.xpath("//div[text()='128 - 255.9 GB']")).click();
		driver.findElement(By.xpath("//div[text()='SAMSUNG Galaxy Z Flip3 5G (Cream, 128 GB)']")).click();
		String parentWindowID = driver.getWindowHandle();
		Set<String> allWindowID = driver.getWindowHandles();
		allWindowID.remove(parentWindowID);
		for (String windowID : allWindowID) {
			driver.switchTo().window(windowID);
		}
		Thread.sleep(5000);
		String mobileName = driver.findElement(By.xpath("//span[text()='SAMSUNG Galaxy Z Flip3 5G (Cream, 128 GB)']")).getText();
		String price = driver.findElement(By.xpath("//span[@class='B_NuCI']/../../..//div[contains(@class,'jeq')]")).getText();
		Reporter.log(mobileName,true);
		Reporter.log(price,true);
		Thread.sleep(2000);
		driver.quit();
		
	}
}
