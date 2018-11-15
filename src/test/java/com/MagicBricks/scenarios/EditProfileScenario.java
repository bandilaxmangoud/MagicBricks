package com.MagicBricks.scenarios;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.MagicBricks.workFlows.MagicBricksBusinessFuctions;
import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

public class EditProfileScenario extends MagicBricksBusinessFuctions{
	
	ExcelReader xlsrdr5=new ExcelReader(configProps.getProperty("TestData"), configProps.getProperty("sheetName5"));
	
	static Logger logger=Logger.getLogger(IndigiLoginScenario.class.getName());
	
  @Test
  public void TC_5_EditProfile() throws Throwable {
	  TestEngine.testDescription.put(HtmlReportSupport.tc_name, "Indigo Edit Profile");
	  
	  if(EditProfile()){
		  Reporter.SuccessReport("Validate Edit Profile", "Validate Edit Profile Successfully ");
	  }else{
		  Reporter.failureReport("Validate Edit Profile Details", "Failed to validate Edit Profile Deatils");
	  }
	  System.out.println("Test Completed");
  }
}
