package com.automation.testClass;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.openqa.selenium.By;
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
		deviceQuery="@serialnumber='2db1bc34efc4695084f3e3ddfee3d680bb8a1ab9'";
		init(deviceQuery, "IOSDemoTest");
	}
	
	@Test
	public void WebPasstest(){
		log.warn("About to launch IOS safari");
		client.launch("safari:https://google.com", false, false);
		client.elementSendText("Web", "xpath=//*[@class='gLFyf']", 0, "Iphone");
		log.info("the IOS Web test is pass");
	}
	
	@Test
	public void WebFailtest() {
		client.launch("safari:https://google.com", false, false);
		Assert.assertEquals(client.isElementFound("Web", "Id=hplogo"),true);
		Assert.assertEquals(client.isElementFound("Web", "xpath=//*[@class='gb_b gb_dc']"), true);
		log.info("the IOS Web 2 test is pass");
	}
	
	/*@Test
	public void DXPWebtest() {
		client.launch("safari:http://136.225.241.31:31483/#/final", false, false);
	}*/
}

