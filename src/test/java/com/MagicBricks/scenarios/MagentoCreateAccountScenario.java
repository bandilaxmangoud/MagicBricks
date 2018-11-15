package com.MagicBricks.scenarios;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.MagicBricks.workFlows.MagicBricksBusinessFuctions;
import com.ctaf.accelerators.TestEngine;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.utilities.Reporter;

public class MagentoCreateAccountScenario extends MagicBricksBusinessFuctions {
	static Logger logger=Logger.getLogger(MagentoCreateAccountScenario.class.getName());
	
	@Test
	public void TC_5() throws Throwable{
		TestEngine.testDescription.put(HtmlReportSupport.tc_name, "Account creation scenario");
		
		if(createAccount()){
			Reporter.SuccessReport("validate account creation", "account creation successfully");
		}
		else{
			Reporter.failureReport("validate account creation", "failed to validate account creation");
		}
		System.out.println("Test completed");
	}

}
