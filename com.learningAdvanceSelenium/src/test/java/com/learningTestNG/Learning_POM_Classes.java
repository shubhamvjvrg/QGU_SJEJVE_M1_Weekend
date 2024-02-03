package com.learningTestNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.objectRepository.LoginPage;
import com.objectRepository.WelcomePage;

public class Learning_POM_Classes {

	
	 @Test
	 public void loginToDWS() throws InterruptedException
	 {
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.get("https://demowebshop.tricentis.com");
		 
		 WelcomePage wp = new WelcomePage(driver);
		 LoginPage lp = new LoginPage(driver);
		 
		 wp.getLoginLink().click();
		 lp.getEmailTextField().sendKeys("shubhamvjvrg@gmail.com");
		 lp.getPasswordTextField().sendKeys("Shubham123");
		 lp.getLoginButton().click();
		 
		 Thread.sleep(2000);
		 driver.quit();
	 }
 	
}
