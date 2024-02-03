package com.learningTestNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.generic_Library.WebDriver_Utility;
import com.objectRepository.LoginPage;
import com.objectRepository.WelcomePage;

public class Learning_Extent_Report {

	 @Test
	 public void loginTest() throws InterruptedException
	 {
		 ExtentSparkReporter spark = new ExtentSparkReporter("./src/test/resources/reports/FirstReport.html");
		 ExtentReports report = new ExtentReports();
		 report.attachReporter(spark);
		 
		 ExtentTest test = report.createTest("loginTest");
		 
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.get("https://demowebshop.tricentis.com");
		 try {
			 Assert.assertEquals(driver.getTitle(), "DWS");
			 test.log(Status.INFO, "Demo Web Shop Opened....");
			 WelcomePage wp = new WelcomePage(driver);
			 LoginPage lp = new LoginPage(driver);
			 wp.getLoginLink().click();
			 test.log(Status.INFO, "Login Page Opened....");
			 lp.getEmailTextField().sendKeys("shubhamvjvrg@gmail.com");
			 lp.getPasswordTextField().sendKeys("Shubham123");
			 lp.getLoginButton().click();
			 test.log(Status.PASS, "User logged In Successfully.....");
			 Thread.sleep(2000);
		 }catch(Throwable e)
		 {
			 test.log(Status.FAIL, "Test case Failed");
			 test.addScreenCaptureFromBase64String(WebDriver_Utility.getScreenShotPath(driver));
		 }
		 
		 driver.quit();
		 report.flush();
	 }
}
