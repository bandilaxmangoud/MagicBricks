package com.MagicBricks.scenarios;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.MagicBricks.workFlows.MagicBricksBusinessFuctions;
import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

public class MagentoCompareScenario extends MagicBricksBusinessFuctions{
	static Logger logger=Logger.getLogger(MagentoCompareScenario.class.getName());
	
	@Test
	public void TC_4() throws Throwable{
		TestEngine.testDescription.put(HtmlReportSupport.tc_name, "Magento Compare Scenario");
		
		if(verifyCompare()){
			Reporter.SuccessReport("validate PopUp", "compare 2 products succussfully");
		}
		else
		{
			Reporter.failureReport("validate PopUp", "failed to compare the products");
		}
		System.out.println("Test completed");
	}

}
