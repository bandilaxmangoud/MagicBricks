package com.MagicBricks.scenarios;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.MagicBricks.workFlows.MagicBricksBusinessFuctions;
import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Data_Provider;
import com.ctaf.utilities.Reporter;

public class FkartLoginScenario extends MagicBricksBusinessFuctions {

	ExcelReader xlsrdr=new ExcelReader(configProps.getProperty("TestData"),
			configProps.getProperty("sheetName5"));
	
	
	static Logger logger=Logger.getLogger(FkartLoginScenario.class.getName());
	@Test
	public void TC_1_Login() throws Throwable
	{
		TestEngine.testDescription.put(HtmlReportSupport.tc_name, "Flipkart Scenario");
		if(FkartLogin()){
			Reporter.SuccessReport("validate Login Summary Details", "validate  Login Successfully");
		}
		else {
			Reporter.failureReport("validate Login", "failed To validate Login");
		}
		System.out.println("Test completed");
	}
	
	/*
	@DataProvider
	public Object[][] getData() throws Exception
	{
		return Data_Provider.getTableArray("Fkart");
	}
	*/
	
	
}
