package com.MagicBricks.scenarios;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.MagicBricks.workFlows.MagicBricksBusinessFuctions;
import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

public class MagentoPriceScenario extends MagicBricksBusinessFuctions {
	static Logger logger=Logger.getLogger(MagentoPriceScenario.class.getName());
	
	@Test
	public void TC_2() throws Throwable{
		TestEngine.testDescription.put(HtmlReportSupport.tc_name, "Magento Price comparision scenario");
		if(VerifyPrice()){
			Reporter.SuccessReport("validate price", "validate price compare succussfully");
		}
		else
		{
			Reporter.failureReport("validate price", "failed to validate price");
		}
		
		System.out.println("Test completed");
	}

}
