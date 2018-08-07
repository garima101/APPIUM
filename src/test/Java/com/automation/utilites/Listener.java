package com.automation.utilites;



import org.apache.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;


public class Listener extends BaseTest implements ITestListener, ISuiteListener, IInvokedMethodListener  {
	private static Logger log = Logger.getLogger(Listener.class.getName());;
	
	@Override
	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub
		//Reporter.log("About to end executing Suite " + arg0.getName(), true);
		log.info("About to end executing Suite " +arg0.getName());
	}

	@Override
	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		//Reporter.log("About to begin executing Suite " + arg0.getName(), true);
		log.info("About to begin executing Suite " +arg0.getName() );
	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		//Reporter.log("Completed executing test " + arg0.getName(), true);
		log.info("Completed executing test" +arg0.getName() );
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
	//	Reporter.log("About to begin executing Test " + arg0.getName(), true);
		log.info("About to begin executing Test " +arg0.getName() );
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		printTestResults(arg0);
		try {
			testCapture123();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			log.error("the test case is failed " +arg0.getName());
		}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		printTestResults(arg0);
		log.error("the testcase is skipped " +arg0.getName());
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		//System.out.println("The execution of the main test starts now");
		log.info("The execution of the main test starts now " +arg0.getName());

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		printTestResults(arg0);
		log.info("the test is sucess "+arg0.getName());

	}

	private void printTestResults(ITestResult result) {

		Reporter.log("Test Method resides in " + result.getTestClass().getName(), true);

		if (result.getParameters().length != 0) {

			String params = null;

			for (Object parameter : result.getParameters()) {

				params += parameter.toString() + ",";

			}

			Reporter.log("Test Method had the following parameters : " + params, true);
			log.info("Test Method had the following parameters : " + params );

		}

		String status = null;

		switch (result.getStatus()) {

		case ITestResult.SUCCESS:

			status = "Pass";

			break;

		case ITestResult.FAILURE:

			status = "Failed";

			break;

		case ITestResult.SKIP:

			status = "Skipped";

		}

		Reporter.log("Test Status: " + status, true);
		log.info("Test Status:" + status );
	}

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {

		String textMsg = "About to begin executing following method : " + returnMethodName(arg0.getTestMethod());

	//	Reporter.log(textMsg, true);
		log.info(textMsg);

	}

	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {

		String textMsg = "Completed executing following method : " + returnMethodName(arg0.getTestMethod());

//		Reporter.log(textMsg, true);
		log.info(textMsg);
	}

	private String returnMethodName(ITestNGMethod method) {
		return method.getRealClass().getSimpleName() + "." + method.getMethodName();
	}

}
