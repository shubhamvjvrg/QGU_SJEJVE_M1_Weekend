package com.learningTestNG;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Learning_Configuration_Annotation {

	@BeforeSuite
	public void beforeSuite()
	{
		Reporter.log("Executing Before Suite.....", true);
	}
	@AfterSuite
	public void afterSuite()
	{
		Reporter.log("Executing After Suite.....", true);
	}
	@BeforeTest
	public void beforetest()
	{
		Reporter.log("Executing Before Test.....", true);
	}
	@AfterTest
	public void afterTest()
	{
		Reporter.log("Executing After Test.....", true);
	}
	@BeforeClass
	public void beforeClass()
	{
		Reporter.log("Executing Before Class.....", true);
	}
	@AfterClass
	public void afterClass()
	{
		Reporter.log("Executing After Class.....", true);
	}
	@BeforeMethod
	public void beforeMethod()
	{
		Reporter.log("Executing Before Method.....", true);
	}
	@AfterMethod
	public void afterMethod()
	{
		Reporter.log("Executing After Method.....", true);
	}
	@Test(priority =2) // Acts like Main Method
	public void loginTest() // acts like Test Case
	{
		Reporter.log("Executing Login Test Case", true); // Steps of Test Case
	}
	@Test (priority =1) // Acts like Main Method
	public void registerTest() // acts like 
	{
		Reporter.log("Executing Resgister Test Case", true);
	}
	@Test (priority =3) // Acts like Main Method
	public void searchTest() // acts like 
	{
		Reporter.log("Executing Search Test Case", true);
	}
}
