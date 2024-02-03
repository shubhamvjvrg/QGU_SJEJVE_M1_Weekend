package com.learningTestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Learning_Priority_Attribute {
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
