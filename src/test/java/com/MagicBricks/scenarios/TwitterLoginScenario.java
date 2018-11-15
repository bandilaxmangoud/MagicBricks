package com.MagicBricks.scenarios;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.MagicBricks.workFlows.MagicBricksBusinessFuctions;
import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

public class TwitterLoginScenario extends MagicBricksBusinessFuctions{
	ExcelReader xlsrdr5=new ExcelReader(configProps.getProperty("TestData"), configProps.getProperty("sheetName5"));
	
	static Logger logger=Logger.getLogger(TwitterLoginScenario.class.getName());
	
  @Test
  public void TC_3_TwitterLogin() throws Throwable {
	  TestEngine.testDescription.put(HtmlReportSupport.tc_name, "Indigo Twitter Login Scenario");
	  if (TwitterLogin()) {	
			 
		  Reporter.SuccessReport("Validate LogIn credentials", "Validate Twitter Login Successfully ");
		  
	} else {
		Reporter.failureReport("Validate LogIn credentials", "Failed to validate Twitter Login");
		
	}
	  System.out.println("Test completed");
  }
}
