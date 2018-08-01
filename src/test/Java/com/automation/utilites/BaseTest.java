package com.automation.utilites;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.AfterClass;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import com.experitest.client.Client;
import com.experitest.client.GridClient;

public class BaseTest {
	protected Client client = null;
	protected GridClient gridClient = null;
	protected Properties cloudProperties = new Properties();
	
	public void init(String deviceQuery, String testName) throws Exception  	{
		initCloudProperties();
		String url = getProperty("url", cloudProperties);
		String accessKey = getProperty("accessKey", cloudProperties);
		if (accessKey != null && !accessKey.isEmpty()) {
			gridClient = new GridClient(accessKey, url);
		} else {
			String username = getProperty("username", cloudProperties);
			String password = getProperty("password", cloudProperties);
			String project = getProperty("project", cloudProperties);
			gridClient = new GridClient(username, password, project, url);
		}
		String adhocDeviceQuery = System.getenv("deviceQuery");
		System.out.println(" device is connected");
		if (adhocDeviceQuery != null) {
			System.out.println("[INFO] Redirecting test to the current device.");
			deviceQuery = adhocDeviceQuery;
		}
		client = gridClient.lockDeviceForExecution(testName, deviceQuery, 30, 300000);
		File reporterDir = new File(System.getProperty("user.dir"), "reports");
		reporterDir.mkdirs();
		client.setReporter("xml", reporterDir.getAbsolutePath(), testName);
	
	}

	protected String getProperty(String property, Properties props) {
		if (System.getProperty(property) != null) {
			return System.getProperty(property);
		} else if (System.getenv().containsKey(property)) {
			return System.getenv(property);
		} else if (props != null) {
			return props.getProperty(property);
		}
		return null;
	}

	private void initCloudProperties() throws FileNotFoundException, IOException {
		FileReader fr = new FileReader("cloud.properties");
		cloudProperties.load(fr);
		fr.close();
	}
@After	
@AfterMethod
 public void tearDown() {
		// Generates a report of the test case.
		// For more information - https://docs.experitest.com/display/public/SA/Report+Of+Executed+Test
		client.generateReport(false);
//		// Releases the client so that other clients can approach the agent in the near future.
		client.releaseClient();
		System.out.println("---------------client is released---------------------------");
	}
	
	@AfterSuite
public void teardown1() {
	Result();	   
	}		
	public void Result() {
			String OutputDir = System.getProperty("user.dir") + "\\test-output";
			String dirc = new SimpleDateFormat("yyyyMMddHHmm'.html'").format(new Date());
			File Dirc = new File(OutputDir + "//" + dirc);
			Dirc.mkdir();
			File source = new File(OutputDir + "\\index.html");
			String fileName = new SimpleDateFormat("yyyyMMddHHmm'.html'").format(new Date());
			File Destination = new File(OutputDir + "\\" + dirc + "\\" + fileName);
			try {
				FileUtils.copyFile(source, Destination);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
}
