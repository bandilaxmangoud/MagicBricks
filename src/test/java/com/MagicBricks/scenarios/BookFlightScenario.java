/*package com.MagicBricks.scenarios;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.MagicBricks.workFlows.MagicBricksBusinessFuctions;
import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

public class BookFlightScenario extends MagicBricksBusinessFuctions{
	ExcelReader xlsrdr6=new ExcelReader(configProps.getProperty("TestData"), configProps.getProperty("sheetName6"));
	int rowCount=xlsrdr6.getRowCount("SearchFlights");
	
	static Logger logger=Logger.getLogger(BookFlightScenario.class.getName());
	
  @Test
  public void TC_7_BookFlight() throws Throwable {
	  TestEngine.testDescription.put(HtmlReportSupport.tc_name, "Book Flight Details Scenario");
	 	
	  int rowno=2;
	  if(BookFlight(rowno)){
		  Reporter.SuccessReport("Validate Book a Flight", "Validate Book a Flight successfully");
	  }
	  else{
		  Reporter.failureReport("Validate Book a  Flight", "Failed to Book a Flight");
	  }
  
	  System.out.println("Test Completed");
  }
}*/
