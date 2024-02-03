package com.generic_Library;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base_Test_2 {
	public WebDriver driver;
	public static WebDriver sdriver;
	public ExtentReports report;
	public ExtentTest test;
	
	@BeforeSuite
	public void configureReport()
	{
		ExtentSparkReporter spark = new ExtentSparkReporter("./src/test/resources/reports/"+Java_Utility.getName()+".html");
		report = new ExtentReports();
		report.attachReporter(spark);
	}
    @BeforeClass(alwaysRun = true)
    public void openBrowser()
    {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	driver.get("https://demowebshop.tricentis.com/");
    	sdriver=driver;
    }
    @BeforeMethod
    public void loginToDWS(Method method)
    {
    	test = report.createTest(method.getName());
    	driver.findElement(By.linkText("Log in")).click();
    	driver.findElement(By.id("Email")).sendKeys("shubhamvjvrg@gmail.com");
    	driver.findElement(By.id("Password")).sendKeys("Shubham123");
    	driver.findElement(By.xpath("//input[@value='Log in']")).click();
    	
    }
    @AfterMethod
    public void logoutFromDWS()
    {
    	driver.findElement(By.linkText("Log out")).click();
    }
    @AfterClass
    public void closeBrowser()
    {
    	driver.quit();
    }
    @AfterSuite
    public void saveReport()
    {
    	report.flush();
    }
}




