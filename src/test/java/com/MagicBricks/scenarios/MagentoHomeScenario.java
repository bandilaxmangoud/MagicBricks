package com.MagicBricks.scenarios;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.MagicBricks.workFlows.MagicBricksBusinessFuctions;
import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

public class MagentoHomeScenario extends MagicBricksBusinessFuctions {
	
	static Logger logger=Logger.getLogger(MagentoHomeScenario.class.getName());
	
	@Test
	public void TC_1() throws Throwable{
		TestEngine.testDescription.put(HtmlReportSupport.tc_name, "Magento Home Scenario");
		if(MagentoHome()){
			Reporter.SuccessReport("Validate Title", "validate  Title Successfully");
		}
		else
		{
			Reporter.failureReport("validate Title", "failed To validate Title");
		}
		
		System.out.println("Test completed");
	}

}
