package com.MagicBricks.scenarios;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.MagicBricks.workFlows.MagicBricksBusinessFuctions;
import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

public class ScheduleFlightScenario extends MagicBricksBusinessFuctions {
	ExcelReader xlsrdr6=new ExcelReader(configProps.getProperty("TestData"), configProps.getProperty("sheetName6"));
	
	static Logger logger=Logger.getLogger(SearchFlightScenario.class.getName());
  @Test
  public void TC_4_ScheduleFlights() throws Throwable {
	  TestEngine.testDescription.put(HtmlReportSupport.tc_name, "Schedule Flight Details Scenario");
	  if(FlightSchedules()){
		  Reporter.SuccessReport("Validate Schedule Flight Details", "Schedule Flights Details Successfully");
	  }else{
		  Reporter.failureReport("Validate Schedule Flight Details", "Failed to Schedule Flights Details");
	  }
	  
	  System.out.println("Test Completed");
  }
}
