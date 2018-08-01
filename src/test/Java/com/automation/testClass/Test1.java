package com.automation.testClass;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.automation.utilites.BaseTest;

public class Test1 extends BaseTest {
	private static Logger log = Logger.getLogger(Test1.class);
	
	@Test
	public void test1() {
		System.out.println("@@@@@#######testexecution@##########");
		log.info("test1 is passed");
	}
	@Test
	public void test2() {
		System.out.println("@@@@@#######testexecution@##########");
		log.info("test2 is passed");
		log.debug("this is debug message");
		
	}
	@Test
	public void test3() {
		System.out.println("@@@@@#######testexecution@##########");
		log.warn("test3 is Failed");
		assertEquals(true,false);
		
	}

	
}
