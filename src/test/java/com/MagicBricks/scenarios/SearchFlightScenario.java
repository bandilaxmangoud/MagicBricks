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

public class SearchFlightScenario extends MagicBricksBusinessFuctions{
	
	ExcelReader xlsrdr6=new ExcelReader(configProps.getProperty("TestData"), configProps.getProperty("sheetName6"));
	int rowCount=xlsrdr6.getRowCount("SearchFlights");
	
	static Logger logger=Logger.getLogger(SearchFlightScenario.class.getName());
	
  @Test 
  public void TC_2_SearchFlight() throws Throwable {
	  TestEngine.testDescription.put(HtmlReportSupport.tc_name, "Search Flight Details Scenario");
	  //System.out.println(rowCount);

	  for (int rowno = 2; rowno <= rowCount; rowno++) {	  
	  if (SearchFlight(rowno)) {
		 
		  
		  Reporter.SuccessReport("Validate Search Flight", "Search Flights Successfully");
		
	} else {
		Reporter.failureReport("Validate Search Flight", "Failed to Search Flights");

	}
	  } 
	  
	  System.out.println("Test Completed");
	  
	  
  }
  
	
	}


