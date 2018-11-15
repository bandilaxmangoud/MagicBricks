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

/*
 * Test Scenarios of MagicBricks
 * 
 */
public class RentPropertyScenario extends MagicBricksBusinessFuctions {
	ExcelReader xlsrdr = new ExcelReader(configProps.getProperty("TestData"),
			configProps.getProperty("sheetName2"));
	Logger logger = Logger.getLogger(RentPropertyScenario.class.getName());

	/*
	 * Verify Login and logout
	 */
	@Test(dataProvider = "getData")
	
		
	public void TC_1_RentPropertySearch(String City, String PropertyType, String NoofRooms, String Budget) throws Throwable {
		
		TestEngine.testDescription.put(HtmlReportSupport.tc_name,  "MagicBricks Scenario");
		
		
				if(RentPropertySearch( City,  PropertyType,  NoofRooms, Budget)){
					Reporter.SuccessReport("validate Account Summary Details","validate Property Search Successfully");
		
				}else{
	Reporter.failureReport("validate Property ","failed To validate Rent Property Search");

		}
		
		
		System.out.println("Test Completed");
	
	}	
	
	@DataProvider
	public Object[][] getData() throws Exception
	{
		return Data_Provider.getTableArray("RENTDATA");
	}
	
	}


	 

