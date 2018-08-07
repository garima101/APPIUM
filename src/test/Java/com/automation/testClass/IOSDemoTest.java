package com.automation.testClass;



import java.io.IOException;

import org.apache.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automation.utilites.BaseTest;


public class IOSDemoTest extends BaseTest {
	private static Logger log = Logger.getLogger(IOSDemoTest.class);
	
@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='ios'") String deviceQuery) throws Exception{
	deviceQuery="@serialnumber='1e3289cb21bbb133c149e1e8529bde19dc31b91a'";
		init(deviceQuery, "IOSDemoTest");
		}
	
	@Test
	public void PR_JY_002_001_WebPasstest(){
		log.warn("About to launch IOS safari");
		client.launch("safari:https://google.com", false, false);
		client.elementSendText("Web", "xpath=//*[@class='gLFyf']", 0, "Iphone");
		log.info("the IOS Web test is pass");
	}
	
	@Test
	public void PR_JY_002_002_WebFailtest() throws Exception {
		client.launch("safari:https://google.com", false, false);
		Assert.assertEquals(client.isElementFound("Web", "Id=hplogo"),true);
	//	System.out.println("###@@@@@@@@11111111111111@@@############");
		Assert.assertEquals(client.isElementFound("Web", "xpath=//*[@class='gb_b gb_dc']"), false);
	//	System.out.println("@@@@@@@############@@2222222222222222222@@@@#######");
		log.info("the IOS Web 2 test is pass");
		testCapture123();
		}
	
}

