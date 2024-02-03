package com.learningTestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class First_TestNG_Class {
@Test // Acts like Main Method
public void loginTest() // acts like Test Case
{
	Reporter.log("Executing Login Test Case", true); // Steps of Test Case
}
@Test // Acts like Main Method
public void registerTest() // acts like 
{
	Reporter.log("Executing Resgister Test Case", true);
}
@Test // Acts like Main Method
public void searchTest() // acts like 
{
	Reporter.log("Executing Search Test Case", true);
}
}
