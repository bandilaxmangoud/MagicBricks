package com.MagicBricks.scenarios;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.MagicBricks.workFlows.MagicBricksBusinessFuctions;
import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

public class IndigoBrokenLinkScenario extends MagicBricksBusinessFuctions{
	
	static Logger logger=Logger.getLogger(IndigoBrokenLinkScenario.class.getName());
	
  @Test
  public void TC_6_BrokenLinks() throws Throwable {
	  TestEngine.testDescription.put(HtmlReportSupport.tc_name, "Broken Links and Images");
	  
	  if(BrokenLinks()){
		  
		  Reporter.SuccessReport("Validate Broken links and images", "Validate  Broken links and images Successfully ");
	  }else{
		  Reporter.failureReport("Validate  Broken links and images", "Failed to validate Broken links and images");
	  }
	  
	  System.out.println("Test Completed");
  }
}
