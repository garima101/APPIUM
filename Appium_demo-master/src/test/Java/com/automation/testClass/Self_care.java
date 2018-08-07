package com.automation.testClass;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.utilites.BaseTest;

public class Self_care extends BaseTest {
	private static Logger log = Logger.getLogger(Self_care.class);
	
	@Test
	public void PR_JY_001_ActivateSim_001() {
		System.out.println("@@@@@#######testexecution@##########");
		log.info("test1 is passed");
	}
	@Test
	public void PR_JY_001_ONBoard_002() {
		System.out.println("@@@@@#######testexecution@##########");
		log.info("test2 is passed");
		log.debug("this is debug message");
		
	}
	@Test
	public void PR_JY_001_DeactivateSIM_003() {
		System.out.println("@@@@@#######testexecution@##########");
		log.warn("test3 is Failed");
		Assert.assertEquals(true,false);
	}

}
