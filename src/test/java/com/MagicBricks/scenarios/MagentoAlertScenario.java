package com.MagicBricks.scenarios;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.MagicBricks.workFlows.MagicBricksBusinessFuctions;
import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

public class MagentoAlertScenario extends MagicBricksBusinessFuctions{
	static Logger logger=Logger.getLogger(MagentoAlertScenario.class.getName());
	
	@Test
	public void TC_3() throws Throwable
	{
		TestEngine.testDescription.put(HtmlReportSupport.tc_name, "Magento Alert Scenario");
		if(VerifyAlert()){
			Reporter.SuccessReport("validate alert", "alert displayed succussfully");
		}
		else
		{
			Reporter.failureReport("validate alert", "failed to display alert");
		}
		System.out.println("Test completed");
	}

}
