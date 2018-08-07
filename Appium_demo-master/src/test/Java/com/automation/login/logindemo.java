package com.automation.login;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;


import com.automation.utilites.BaseTest;

public class logindemo extends BaseTest  {
	private static Logger log = Logger.getLogger(logindemo.class);
	@Test(timeOut=1000)
	public void PR_JY_002_ValidateName_001() throws InterruptedException, IOException
	{
		System.out.println("@@@@@@@@@@@@@#############i am in first test case from Validate name");
		//log.error("Time out Error");
		Thread.sleep(1500);
		log.info("The test case is Pass ");
		}
	@Test
	public void PR_JY_002_ValidateName_002() throws InterruptedException, IOException
	{
		System.out.println("@@@@@@@@@@@@@#############i am in Second test case from validate name");
	log.info("passed testecase");		
	}
	@Test
	public void PR_JY__002_ValidateAge_003()
	{
		System.out.println("@@@@#####################i am in First test case from Validate Age");
		log.info("passed testecase");	
	}
	public void PR_JY__002_ValidateAge_004()
	{
		System.out.println("@@@@#####################i am in second test case from Validate Age");
		log.info("passed testecase");	
	}

}
