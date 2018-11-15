package com.MagicBricks.scenarios;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.MagicBricks.workFlows.MagicBricksBusinessFuctions;
import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

public class IndigiLoginScenario extends MagicBricksBusinessFuctions {
	
	ExcelReader xlsrdr5=new ExcelReader(configProps.getProperty("TestData"), configProps.getProperty("sheetName5"));
	int rowCount=xlsrdr5.getRowCount("sheetName5");
	static Logger logger=Logger.getLogger(IndigiLoginScenario.class.getName());

	
  @Test
  public void TC_1_Login() throws Throwable {
	  
	  TestEngine.testDescription.put(HtmlReportSupport.tc_name, "Indigo Login Scenario");
	
	  if (IndigoLogin()) {	
		 
		  Reporter.SuccessReport("Validate LogIn credentials", "Validate Login Successfully ");
		  
	} else {
		Reporter.failureReport("Validate LogIn credentials", "Failed to validate Login");
		
	}
	  System.out.println("Test completed");
  }
}
