package com.MagicBricks.workFlows;  

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.IFactoryAnnotation;

import sun.invoke.util.VerifyType;

import com.MagicBricks.scenarios.IndigiLoginScenario;
import com.MagicBricks.testObjects.FkartLocators;
import com.MagicBricks.testObjects.IndigoLocators;
import com.MagicBricks.testObjects.MagentoLocators;
import com.MagicBricks.testObjects.MagicBricksLocators;
import com.ctaf.accelerators.ActionEngine;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.gargoylesoftware.htmlunit.javascript.host.Element;


public class MagicBricksBusinessFuctions extends ActionEngine {
	
	

	ExcelReader xlsrdr = new ExcelReader(configProps.getProperty("TestData"),
			configProps.getProperty("sheetName1"));
	ExcelReader xlsrdr3 = new ExcelReader(configProps.getProperty("TestData"),
			configProps.getProperty("sheetName3"));
	ExcelReader xlsrdr5=new ExcelReader(configProps.getProperty("TestData"),
			configProps.getProperty("sheetName5"));
	ExcelReader xlsrdr6=new ExcelReader(configProps.getProperty("TestData"),
			configProps.getProperty("sheetName6"));
	
	
	
	static Logger logger = Logger.getLogger(MagicBricksBusinessFuctions.class.getName());
	
	
	/**
	 * This method  checks login functionality
	 * @return: boolean value (True: if the element is enabled, false: if it not enabled).
	 * @throws Throwable 
	 */
	
public boolean IndigoLogin() throws Throwable {
		boolean res = false;
		HtmlReportSupport.reportStep("Entering Login Details");
		try {
			//System.out.println(xlsrdr5.getCellValue("User Name", "value"));
			waitForElementPresent(IndigoLocators.IndigoLogoImage, "Indigo Logo");
			click(IndigoLocators.LogInlnk, "LogIn Link");
			waitForElementPresent(IndigoLocators.LoginUserID, "Login User ID");
			type(IndigoLocators.LoginUserID, xlsrdr5.getCellData("User Name", 2), "User ID");
			type(IndigoLocators.LoginPassword, xlsrdr5.getCellData( "Password", 2), "Password");
			click(IndigoLocators.LogInbtn, "Login");
			
			Thread.sleep(10000);
			
			if (isElementPresent(IndigoLocators.LogOut, "Logged In")) {
				res = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return res;
		}
	
		return res;

	}

/**
 * This method  checks twitter login functionality
 * @return: boolean value (True: if the element is enabled, false: if it not enabled).
 * @throws Throwable 
 */
public boolean TwitterLogin() throws Throwable{
	boolean res=false;
	HtmlReportSupport.reportStep("Enter Twitter Login details");
	
	try {
		waitForElementPresent(IndigoLocators.TwitterImage, "Twitter Image");
		click(IndigoLocators.TwitterImage, "Twitter Image");
		Thread.sleep(10000);
		tab();
		//waitForElementPresent(IndigoLocators.TwitterLoginlnk, "Twitter Log In");
	
		//click(IndigoLocators.TwitterLoginlnk, "Twitter Log In");
		type(IndigoLocators.TwitterLoginUsername, xlsrdr5.getCellData("User Name", 5), "User Name");
		type(IndigoLocators.TwitterLoginPassword, xlsrdr5.getCellData( "Password", 5), "Password");
		click(IndigoLocators.TwitterLoginbtn, "Log In Button");
		Thread.sleep(10000);
		
				
		if(isElementPresent(IndigoLocators.TwitterSettings, "Profile Settings")){
			res=true;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		return res;
	}
	return res;
	
}


/**
 * This method  checks edit profile functionality
 * @return: boolean value (True: if the element is enabled, false: if it not enabled).
 * @throws Throwable 
 */
public boolean EditProfile() throws Throwable{
	boolean res=false;
	HtmlReportSupport.reportStep("Edit Profile Details");
	try {
		IndigoLogin();
		waitForElementPresent(IndigoLocators.EditProfile, "Edit Profile Button");
		click(IndigoLocators.EditProfile, "Edit Profile Button");
		ScrollDown(IndigoLocators.EditProfileAddr1, "Street Address1");
		click(IndigoLocators.EditProfileAddr1, "Street Address1");
		Thread.sleep(2000);
		clear(IndigoLocators.EditProfileAddr1, "Street Address1");
		type(IndigoLocators.EditProfileAddr1, xlsrdr5.getCellData("Addr1", 2), "Street Address1");
		clear(IndigoLocators.EditProfileAddr2, "Street Address2");
		type(IndigoLocators.EditProfileAddr2, xlsrdr5.getCellData("Addr2", 2), "Street Address2");
		Thread.sleep(6000);
		click(IndigoLocators.UpdateProfile, "Update Profile");
		Thread.sleep(2000);
		click(IndigoLocators.LogOut, "Log Out");
		
		
		if(isElementPresent(IndigoLocators.LogOut, "Logged In")){
			res=true;
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
		return res;
	}
	return res;
	
}




/**
 * This method  checks search flight functionality
 * @param rowno: It takes the no of rows in a SearchFlights sheet (Get it from TestData)
 * @return: boolean value (True: if the element is enabled, false: if it not
 *          enabled).
 */
public boolean SearchFlight(int rowno) throws Throwable{
	boolean res=false;
	HtmlReportSupport.reportStep("Search Flights details");
	
	try {
		
		waitForElementPresent(IndigoLocators.BookFlight, "Book Flight");
		click(IndigoLocators.BookFlight,  "Book Flight");
		click(IndigoLocators.RoundTrip, "Round Trip");
		click(IndigoLocators.From, "From");
		type(IndigoLocators.From, xlsrdr6.getCellData("From", rowno), "From");
		click(By.partialLinkText(xlsrdr6.getCellData("From", rowno)), "");
		clear(IndigoLocators.To, "");
		type(IndigoLocators.To, xlsrdr6.getCellData("To", rowno), "To");
		click(By.partialLinkText(xlsrdr6.getCellData("To", rowno)), "");
		waitForElementPresent(IndigoLocators.Departing, "Departing Time");
		type(IndigoLocators.Departing, xlsrdr6.getCellData("Departing", rowno), "Departing");
		type(IndigoLocators.Returning, xlsrdr6.getCellData("Returning", rowno), "Returning");
		//click(IndigoLocators.AdultIncrease, "Adult size");
		AdultPassengerSize(rowno);
		ChildPassengerSize(rowno);
		InfantPassengerSize(rowno);
		click(IndigoLocators.SearchFlights, "Search Flights");
		Thread.sleep(6000);
		
		ScrollDown(IndigoLocators.SelectAndContinuebtn,"Select And Continue");
		ScrollUp(IndigoLocators.SelectFlightlnk,"Select Flight");
		
		

		
		if (isElementPresent(IndigoLocators.SelectFlightlnk, "Select Flights")) {
			res = true;
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
		return res;
	}
	
	return res;
	
}

/**
 * This method  increase or decrease the adult passengers size functionality
 * @param rowno: It takes the no of rows in a SearchFlights sheet (Get it from TestData)
 * @return: boolean value (True: if the element is enabled, false: if it not
 *          enabled).
 */
public boolean AdultPassengerSize(int rowno) throws Throwable{
	boolean res=false;
	try {
			
			int actSize=Integer.parseInt(driver.findElement(IndigoLocators.Adult).getText());
			int exlSize=Integer.parseInt(xlsrdr6.getCellData("Adult", rowno));
			/*System.out.println(actSize);
			System.out.println(exlSize);*/
			
			if(actSize==exlSize){
				res=true;
			}else if(actSize>exlSize){
				while(actSize>exlSize){
				click(IndigoLocators.AdultDecrese, "<");// click on "<" symbol
				int actSize1=Integer.parseInt(driver.findElement(IndigoLocators.Adult).getText());
				actSize=actSize1;
				res=true;
				
				}
			}else
			{
				while(actSize<exlSize){
					click(IndigoLocators.AdultIncrease, ">");//click on ">" symbol
					int actSize1=Integer.parseInt(driver.findElement(IndigoLocators.Adult).getText());
					actSize=actSize1;
							
				res=true;
				
				}
			}
	} catch (Exception e) {
		e.printStackTrace();
		return res;
	}
	return res;
	
}

/*
 * This method  increase or decrease the child passengers size functionality
 * @param rowno: It takes the no of rows in a SearchFlights sheet (Get it from TestData)
 * @return: boolean value (True: if the element is enabled, false: if it not
 *          enabled).
 */
public boolean ChildPassengerSize(int rowno) throws Throwable{
	boolean res=false;
	try {
		int actSize=Integer.parseInt(driver.findElement(IndigoLocators.Child).getText());
		int exlSize=Integer.parseInt(xlsrdr6.getCellData("Child", rowno));
		
		if(actSize==exlSize){
			res=true;
		}else if(actSize>exlSize){
			while(actSize>exlSize){
				click(IndigoLocators.ChildDecrease, "<");// click on "<" symbol
				int actSize1=Integer.parseInt(driver.findElement(IndigoLocators.Child).getText());
				actSize=actSize1;
				res=true;
				
			}
			
		}else{
			while(actSize<exlSize){
				click(IndigoLocators.ChildIncrease, ">");//click on ">" symbol
				int actSize1=Integer.parseInt(driver.findElement(IndigoLocators.Child).getText());
				actSize=actSize1;
				res=true;
			}
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
		return res;
	}
	
	return res;
	
}


/*
 * This method  increase or decrease the infant passengers size functionality
 * @param rowno: It takes the no of rows in a SearchFlights sheet (Get it from TestData)
 * @return: boolean value (True: if the element is enabled, false: if it not
 *          enabled).
 */
public boolean InfantPassengerSize(int rowno) throws Throwable{
	boolean res=false;
	try {
		int actSize=Integer.parseInt(driver.findElement(IndigoLocators.Infant).getText());
		int exlSize=Integer.parseInt(xlsrdr6.getCellData("Infant", rowno));
		
		if(actSize==exlSize){
			res=true;
			
		}else if(actSize>exlSize){
			while(actSize>exlSize){
				click(IndigoLocators.InfantDecrease, "<");// click on "<" symbol
				int actSize1=Integer.parseInt(driver.findElement(IndigoLocators.Infant).getText());
				actSize=actSize1;
				res=true;
				
			}
					
				}else{
					while(actSize<exlSize){
						click(IndigoLocators.InfantIncrease, ">");//click on ">" symbol
						int actSize1=Integer.parseInt(driver.findElement(IndigoLocators.Infant).getText());
						actSize=actSize1;
						res=true;
			}
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		return res;
	}
	
	return res;
	
}


/**
 * This method  checks Flight schedules functionality
 * @return: boolean value (True: if the element is enabled, false: if it not
 *          enabled).
 */
public boolean FlightSchedules() throws Throwable{
	boolean res=false;
	HtmlReportSupport.reportStep("Flight Schedules Details");
	try {
		waitForElementPresent(IndigoLocators.IndigoLogoImage, "Indigo Logo");
		click(IndigoLocators.Schedulelnk, "Schedule");
		click(IndigoLocators.ScheduleOrigin, "Schedule Origin");
		type(IndigoLocators.ScheduleOrigin, xlsrdr6.getCellData("From", 2), "Origin");
		click(IndigoLocators.ScheduleDestination, "Schedule Destination");
		type(IndigoLocators.ScheduleDestination, xlsrdr6.getCellData("To", 2), "Destination");
		click(IndigoLocators.ScheduleSearchFlightslnk, "Schedule Search Flights link");
		Thread.sleep(6000);
		waitForElementPresent(IndigoLocators.FlightSchedule, "Flight Schedule");
		
		click(IndigoLocators.ExportToExcel, "Export To Excel");
		Thread.sleep(6000);
		
		
		if (isElementPresent(IndigoLocators.FlightSchedule, "Flight Schedule")) {
			res = true;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		return res;
	}
	
	return res;
	
}



/**
 * This method  checks Broken Links functionality
 * @return: boolean value (True: if the element is enabled, false: if it not
 *          enabled).
 * @throws Throwable 
 */
public boolean BrokenLinks() throws Throwable{
	boolean res=false;
	HtmlReportSupport.reportStep("To display all links and broken links details");
	try {
		
		waitForElementPresent(IndigoLocators.IndigoLogoImage, "Indigo Logo");
		BrokenLinksAndImages();
		Thread.sleep(6000);
		
		if (isElementPresent(IndigoLocators.IndigoLogoImage, "Indigo Logo")) {
			res = true;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		return res;
	}
	return res;
	
}













public boolean FkartLogin() throws Throwable{
	boolean res=false;
	HtmlReportSupport.reportStep("Entering Login details");
	try {
		
		//waitForElementPresent(FkartLocators.MenuImage, "Logo");
		click(FkartLocators.login, "Login");
		Thread.sleep(5000);
		type(FkartLocators.UName,
				xlsrdr5.getCellData("User Name", 1), "Email ID");
		Thread.sleep(5000);
		type(FkartLocators.Pwd,
				xlsrdr5.getCellData( "Password", 1), "Password");
		Thread.sleep(5000);
		click(FkartLocators.LogIn, "Login");
		Thread.sleep(10000);
		/*if(isElementPresent(FkartLocators.LogOut, "LogOut"))
		{
			res=true;
		}
		click(FkartLocators.Moveto_accName, "Laxman");
		Thread.sleep(3000);
		click(FkartLocators.LogOut, "LogOut");
		Thread.sleep(3000);*/
		
	} catch (Exception e) {
		e.printStackTrace();
		return res;
	}
	res=true;
	
	
	
	return true;
}




public boolean MagentoHome() throws Throwable
{
	boolean res=false;
	HtmlReportSupport.reportStep("Verify item in mobile page and sorted by NAME");
	try {
		Thread.sleep(3000);
		waitForElementPresent(MagentoLocators.ImageLogo, "Logo");
		//String title=driver.getTitle();
		verifyTitle(driver.getTitle());
		click(MagentoLocators.MobileLnk, "MOBILE");
		Thread.sleep(3000);
		verifyTitle(driver.getTitle());
		click(MagentoLocators.SortBy, "SORT BY");
		Thread.sleep(3000);
		mouseover(MagentoLocators.SortBy_Name, "Name                        ");
		click(MagentoLocators.SortBy_Name, "Name                        ");
		Thread.sleep(3000);
		
		getElements2(MagentoLocators.ProductNames);
		
						
	} catch (Exception e) 
	{
		e.printStackTrace();
		return res;
	}
	
	res=true;
	
	return true;
	
}



public boolean VerifyPrice() throws Throwable
{
	boolean res=false;
	String price1 = null;
	HtmlReportSupport.reportStep("verify the price in LIST page and DETAILS page");
	try {
		Thread.sleep(3000);
		waitForElementPresent(MagentoLocators.ImageLogo, "Logo");
		verifyTitle(driver.getTitle());
		click(MagentoLocators.MobileLnk, "MOBILE");
		Thread.sleep(3000);
		getElements2(MagentoLocators.ProductNames);
		
		//getElements2(MagentoLocators.ProductPrice);
		
		/*//It will print the Product names as order wise
		List<WebElement> linkElements =driver.findElements(MagentoLocators.ProductNames);
		String[] linksText = new String[linkElements.size()];
		int index = 1;
		
		for(WebElement element : linkElements)
		{
		    linksText[index] = element.getText();
		    System.out.println(linksText[index]);
	
		
		if(linksText[index].equalsIgnoreCase("Sony Xperia"))//value taken from excel sheet
		{
			
			
			price1=driver.findElement(MagentoLocators.ProductPrice).getText();
			System.out.println(price1);
		
		}	}*/
		
		/*click(MagentoLocators.SonyXperiaLnk, "Sony Xperia");
		Thread.sleep(3000);
	
		String price2=driver.findElement(MagentoLocators.SonyXperiaPrice).getText();
		System.out.println(price2);*/
		
		//Assert.assertEquals(price1, price2);
		//assertTextMatching(MagentoLocators.ProductPrice, "$100.00", "Sony Xperia");
		
	} catch (Exception e) {
		e.printStackTrace();
		return res;
	}
	
	res=true;
	return true;
	
}


public boolean VerifyAlert() throws Throwable{
	boolean res=false;
	HtmlReportSupport.reportStep("Verify Alert message Displayed");
	try {
		Thread.sleep(3000);
		waitForElementPresent(MagentoLocators.ImageLogo, "Logo");
		verifyTitle(driver.getTitle());
		click(MagentoLocators.MobileLnk, "MOBILE");
		Thread.sleep(3000);
		click(MagentoLocators.SonyXperiaAddtoCartBtn, "SX_AddToCart");
		Thread.sleep(3000);
		click(MagentoLocators.SonyXperiaAddtoCartEdit, "Edit Box");
		type(MagentoLocators.SonyXperiaAddtoCartEdit, "1000", "Edit Qty");
		Thread.sleep(3000);
		click(MagentoLocators.SonyXperiaAddtoCartUpdate, "UPDATE");
		Thread.sleep(3000);
		//isPopUpElementPresent(MagentoLocators.ErrMsg, "Error Message");
		isElementPresent(MagentoLocators.ErrMsg, "Error Message");
		System.out.println(getText(MagentoLocators.ErrMsg, "Error Message"));
		click(MagentoLocators.EmptyCartLnk, "EMPTY CART");
		Thread.sleep(3000);
		isElementPresent(MagentoLocators.CartEmpty, "Shopping Cart Empty");
		System.out.println(getText(MagentoLocators.CartEmpty, "Shopping Cart Empty"));
		Thread.sleep(3000);
	} catch (Exception e) {
		e.printStackTrace();
		return res;
	}
	res=true;
	return true;
	
}

public boolean verifyCompare() throws Throwable{
	boolean res=false;
	HtmlReportSupport.reportStep("verify 2 products compare ");
	try {
		
		Thread.sleep(3000);
		waitForElementPresent(MagentoLocators.ImageLogo, "LOGO");
		verifyTitle("Home Page");
		click(MagentoLocators.MobileLnk, "MOBILE");
		Thread.sleep(3000);
		click(MagentoLocators.SonyXperiaAddToCompare, "SONY XPERIA ADD TO COMPARE");
		Thread.sleep(2000);
		click(MagentoLocators.IPhoneAddToCompare, "IPHONE ADD TO COMPARE");
		click(MagentoLocators.CompareBtn, "COMPARE");
		Thread.sleep(3000);
		switchWindowByTitle("Products Comparison List - Magento Commerce", 2);
		verifyTitle("Products Comparison List - Magento Commerce");
		isPopUpElementPresent(MagentoLocators.PopUpComparePage, "Compare Products");
		closeBrowser();
		Thread.sleep(3000);
		
	} catch (Exception e) {
		e.printStackTrace();
		return res;
	}
	res=true;
	return res;
}


public boolean createAccount() throws Throwable {
	boolean res=false;
	HtmlReportSupport.reportStep("create an account and share wishlist to others");
	try {
		Thread.sleep(3000);
		waitForElementPresent(MagentoLocators.ImageLogo, "LOGO");
		verifyTitle("Home Page");
		click(MagentoLocators.AccountLnk, "ACCOUNT");
		click(MagentoLocators.RegisterLnk, "REGISTER");
		Thread.sleep(2000);
		type(MagentoLocators.FirstName, "laxman", "FIRST NAME");
		type(MagentoLocators.LastName, "bandi", "LAST NAME");
		//type(MagentoLocators.Email, "laxman.bandi@cigniti.com", "EMAIL");
		type(MagentoLocators.Password, "9885158783", "PASSWORD");
		type(MagentoLocators.ConfirmPwd, "9885158783", "CONFIRM PASSWORD");
		click(MagentoLocators.RegisterBtn, "REGISTER BUTTON");
		Thread.sleep(3000);
	} catch (Exception e) {
		e.printStackTrace();
		return res;
	}
	return res;
	
	
}

public boolean Logout() throws Throwable{
	boolean res = false;
	HtmlReportSupport.reportStep("Logout");
	try {

		waitForElementPresent(MagicBricksLocators.SignOut,
				"LogOut");
		
		click(MagicBricksLocators.SignOut, "logOut");
		waitForElementPresent(MagicBricksLocators.Loginbtn1,
				"Login visible");
		
		if (isTextPresent("Logged out")) {
			res = true;
		}
	} catch (Exception e) {
		e.printStackTrace();
		return res;
	}

	return res;

}

public boolean BuyPropertySearch(String City, String PropertyType, String NoofRooms, String Budget) throws Throwable{
	boolean res = false;
	HtmlReportSupport.reportStep("BuyProperty");
	try {
Thread.sleep(5000);
		   

          
          driver.manage().deleteAllCookies();
          waitForElementPresent(MagicBricksLocators.MenuImage,"Logo");
          
          waitForElementPresent(MagicBricksLocators.Buy1, "Buying ");
          click(MagicBricksLocators.Buy1, "Buying ");
          
          click(MagicBricksLocators.Keyword, "click on city");
          type(MagicBricksLocators.Keyword, City, "City Name");
          
          waitForElementPresent(MagicBricksLocators.ProType, "Property to load");
          click(MagicBricksLocators.ProType, "Poerty field");
          click(By.xpath(MagicBricksLocators.Residential.replace("#", PropertyType)), "choose flat");
          click(By.xpath(MagicBricksLocators.RoomSelection.replace("#", NoofRooms)), "choose BHK");
          click(MagicBricksLocators.ProType, "Poerty field");
          //Thread.sleep(10000);
          waitForElementPresent(MagicBricksLocators.Budget, "price range");
          click(MagicBricksLocators.Budget, "click on Price range");
          
          click(By.xpath(MagicBricksLocators.BudgetSelection.replace("#", Budget)), "choose Budget");
          
          click(MagicBricksLocators.Searchbtn1, "click on search");
          
          
          for (int i=0;i<15;i++){
        	  
        	  driver.findElement(By.className("proDetail")).sendKeys(Keys.PAGE_DOWN);
        	  
          }
          
         for (int i=0;i<15;i++){
        	  
        	  driver.findElement(By.className("proDetail")).sendKeys(Keys.PAGE_UP);
        	  
          }
		
		int proCount = driver.findElements(By.xpath("//div[@class='proDetail']")).size();
		
		String proDet[][] = new String[proCount][4];
		
		
		
		WebElement proDetail = driver.findElement(By.className("proDetail"));
		System.out.println(proDetail.getSize());
		
		
        for(int i = 0; i<proCount;i++){
        	for(int j=0;j<4;j++){
        		
            if(i%10==0){
            	
            	driver.findElement(By.xpath("//body/descendant::div[@class='proDetail']["+(i+1)+"]/descendant::p[@class='proHeading']")).sendKeys(Keys.PAGE_DOWN);
            }
              	if(j==0){
        		proDet[i][j]=driver.findElement
        				(By.xpath("//body/descendant::div[@class='proDetail']["+(i+1)+"]/descendant::p[@class='proHeading']")).getText();
        		}else if(j==1){
        			proDet[i][j]=driver.findElement
            				(By.xpath("//body/descendant::div[@class='proDetail']["+(i+1)+"]/descendant::div[@class='proPrice']")).getText();
        		}else if(j==2){
        			proDet[i][j]=driver.findElement
            				(By.xpath("//body/descendant::div[@class='proDetail']["+(i+1)+"]/descendant::div[@class='proDetailLine']")).getText();
        		}else if(j==3){
        			proDet[i][j]=driver.findElement
            				(By.xpath("//body/descendant::div[@class='proDetail']["+(i+1)+"]/descendant::div[@class='amenitiesListing']")).getText();
        	}
        }
     }
        
        for(int i = 0; i<proCount;i++){
        	for(int j=0;j<4;j++){
        		if(j==0){
        		System.out.println("proName "+proDet[i][j]);
        		xlsrdr3.setCellData(configProps.getProperty("sheetName3"), "ProDesc", (i+2), proDet[i][j]);
        		}else if(j==1){
        			System.out.println("proPrice "+proDet[i][j]);
        			xlsrdr3.setCellData(configProps.getProperty("sheetName3"), "ProPrice", (i+2), proDet[i][j]);
        		}else if(j==2){
        			System.out.println("proLoc "+proDet[i][j]);
        			xlsrdr3.setCellData(configProps.getProperty("sheetName3"), "ProLoc", (i+2), proDet[i][j]);
        		}else if(j==3){
        			System.out.println("proLoc "+proDet[i][j]);
        			xlsrdr3.setCellData(configProps.getProperty("sheetName3"), "ProAmenities", (i+2), proDet[i][j]);
        	}
        }
          
       		
		
			res = true;
        }
        
        click(MagicBricksLocators.MenuImage,"Logo");	
		Thread.sleep(10000);
	
		
	} catch (Exception e) {
		e.printStackTrace();
		return res;
	}
	

	return res;

}

public boolean RentPropertySearch(String City, String PropertyType, String NoofRooms, String Budget) throws Throwable{
	boolean res = false;
	HtmlReportSupport.reportStep("Property");
	
	ExcelReader xlsrdr3 = new ExcelReader(configProps.getProperty("TestData"),
			configProps.getProperty("sheetName4"));
	try {
Thread.sleep(5000);
		
          driver.manage().deleteAllCookies();
          waitForElementPresent(MagicBricksLocators.MenuImage,"Logo");
          waitForElementPresent(MagicBricksLocators.Rent1, "Renting ");
          click(MagicBricksLocators.Rent1, "choose Rent option");
          click(MagicBricksLocators.Keyword, "click on city");
          type(MagicBricksLocators.Keyword,  City, "City Name");
          
          waitForElementPresent(MagicBricksLocators.RentProType, "Property to load");
          click(MagicBricksLocators.RentProType, "Property field");
          click(By.xpath(MagicBricksLocators.RentResidential.replace("#", PropertyType)), "choose flat");
          
          
          click(By.xpath(MagicBricksLocators.RentRoomSelection.replace("#", NoofRooms)), "choose BHK");
          click(MagicBricksLocators.RentProType, "Property field");
          //Thread.sleep(10000);
          waitForElementPresent(MagicBricksLocators.RentBudget, "price range");
          click(MagicBricksLocators.RentBudget, "click on Price range");
          click(By.xpath(MagicBricksLocators.RentBudgetSelection.replace("#", Budget)), "choose Range");;
          
          click(MagicBricksLocators.Searchbtn1, "click on search");
          
            for (int i=0; i<10;i++){
        	  
            	 driver.findElement(By.className("proDetail")).sendKeys(Keys.PAGE_DOWN);
        	  
          }
            for (int i=0;i<15;i++){
          	  
          	  driver.findElement(By.className("proDetail")).sendKeys(Keys.PAGE_UP);
          	  
            }
          
		
		int proCount = driver.findElements(By.xpath("//div[@class='proDetail']")).size();
		
		String proDet[][] = new String[proCount][4];
		
		
		
		WebElement proDetail = driver.findElement(By.className("proDetail"));
		System.out.println(proDetail.getSize());
		
        for(int i = 0; i<proCount;i++){
        	for(int j=0;j<4;j++){
        		
        		if(i%10==0){
                	
                	driver.findElement(By.xpath("//body/descendant::div[@class='proDetail']["+(i+1)+"]/descendant::p[@class='proHeading']")).sendKeys(Keys.PAGE_DOWN);
                }
               	
              		
        		
        		if(j==0){
        		proDet[i][j]=driver.findElement
        				(By.xpath("//body/descendant::div[@class='proDetail']["+(i+1)+"]/descendant::p[@class='proHeading']")).getText();
        		}else if(j==1){
        			proDet[i][j]=driver.findElement
            				(By.xpath("//body/descendant::div[@class='proDetail']["+(i+1)+"]/descendant::div[@class='proPrice']")).getText();
        		}else if(j==2){
        			proDet[i][j]=driver.findElement
            				(By.xpath("//body/descendant::div[@class='proDetail']["+(i+1)+"]/descendant::div[@class='proDetailLine']")).getText();
        		}else if(j==3){
        			proDet[i][j]=driver.findElement
            				(By.xpath("//body/descendant::div[@class='proDetail']["+(i+1)+"]/descendant::div[@class='amenitiesListing']")).getText();
        	}
        }
      }  
        for(int i = 0; i<proCount;i++){
        	for(int j=0;j<4;j++){
        		if(j==0){
        		System.out.println("proName "+proDet[i][j]);
        		xlsrdr3.setCellData(configProps.getProperty("sheetName4"), "ProDesc", (i+2), proDet[i][j]);
        		}else if(j==1){
        			System.out.println("proPrice "+proDet[i][j]);
        			xlsrdr3.setCellData(configProps.getProperty("sheetName4"), "ProPrice", (i+2), proDet[i][j]);
        		}else if(j==2){
        			System.out.println("proLoc "+proDet[i][j]);
        			xlsrdr3.setCellData(configProps.getProperty("sheetName4"), "ProLoc", (i+2), proDet[i][j]);
        		}else if(j==3){
        			System.out.println("proLoc "+proDet[i][j]);
        			xlsrdr3.setCellData(configProps.getProperty("sheetName4"), "ProAmenities", (i+2), proDet[i][j]);
        	}
        }
        
        
				
			res = true;
        }
        
        click(MagicBricksLocators.MenuImage,"Logo");
		Thread.sleep(10000);
        
	} catch (Exception e) {
		e.printStackTrace();
		return res;
	}
	

	return res;

}


}
