package com.automation.signup;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.automation.utilites.BaseTest;

public class SignupDemo extends BaseTest{
	private static Logger log = Logger.getLogger(SignupDemo.class);
	
		@Test
		public void PR_JY_003_ClickLogin_001()
		{
			System.out.println("im in first test case from Signup Class");
			log.info("Click login passed");
		}
		public void PR_JY_003_ClickLogin_002()
		{
			System.out.println("im in Second test case from Signup Class");
			log.info("Click login passed");
		}
		@Test
		public void _PR_JY_003_ClickSignup_003()
		{
			System.out.println("im in third test case from Signup Class");
			log.info("Click login passed");
		}
}
