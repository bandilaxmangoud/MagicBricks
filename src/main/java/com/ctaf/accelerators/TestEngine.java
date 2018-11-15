package com.ctaf.accelerators;       

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import net.sf.cglib.core.ClassNameReader;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

//import com.MagicBricks.utils.BarchartUtil;
//import com.MagicBricks.utils.MailandZipUtility;
//import com.MagicBricks.workFlows.MagicBricksBusinessFuctions;
import com.ctaf.support.ActionEngineSupport;
import com.ctaf.support.ConfiguratorSupport;
import com.ctaf.support.ExcelReader;
import com.ctaf.support.HtmlReportSupport;
import com.ctaf.support.ReportStampSupport;
import com.ctaf.utilities.Reporter;


public class TestEngine extends HtmlReportSupport {
	public static Logger logger = Logger.getLogger(TestEngine.class.getName());
	public static ConfiguratorSupport configProps = new ConfiguratorSupport(
			"config.properties");
	public static ConfiguratorSupport counterProp = new ConfiguratorSupport(
			configProps.getProperty("counterPath"));
	public static String currentSuite = "";
	public static String method = "";
	public static String timeStamp = ReportStampSupport.timeStamp()
			.replace(" ", "_").replace(":", "_").replace(".", "_");
	public static boolean flag = false;
	public static WebDriver webDriver = null;
	public static EventFiringWebDriver driver=null;
	public static int stepNum = 0;
	public static int PassNum =0;
	public static int FailNum =0;
	public static int passCounter =0;
	public static int failCounter =0;
	public static String testName = "";
	public static String testCaseExecutionTime = "";
	public static StringBuffer x=new StringBuffer();
	public static String finalTime = "";
	public static boolean isSuiteRunning=false;
	public static Map<String, String> testDescription = new LinkedHashMap<String, String>();
	public static Map<String, String> testResults = new LinkedHashMap<String, String>();
	public static String url=null;
	static ExcelReader xlsrdr = new ExcelReader(configProps.getProperty("TestData"),configProps.getProperty("sheetName0"));
	/*
	 * public static Screen s; public static String url =
	 * "jdbc:mysql://172.16.6.121/"; public static String dbName = "test";
	 * public static String userName = "root"; public static Connection conn =
	 * null; public static Statement stmt = null; public static
	 * PreparedStatement pstmt = null; public static ResultSet rs = null;
	 */
	public static int countcompare = 0;
	public static String browser = null;
	static int len = 0;
	static int i = 0;
	public static ITestContext itc;
	public static String groupNames = null;

	/**
	 * Initializing browser requirements, Test Results file path and Database
	 * requirements from the configuration file
	 * 
	 * @Date 19/02/2013
	 * @Revision History
	 * 
	 */
	@BeforeSuite(alwaysRun = true)
	public static void setupSuite(ITestContext ctx) throws Throwable {
		//itc = ctx;
		//groupNames = ctx.getCurrentXmlTest().getIncludedGroups().toString();

		String strBrowserType[];

		ReportStampSupport.calculateSuiteStartTime();
		
				logger.info("Starting browser : "
						+ configProps.getProperty("browserType"));

				browser = configProps.getProperty("browserType");
		

		// browser = configProps.getProperty("browserType");
		if (browser.toString().contains(",")) {
			strBrowserType = browser.split("\\,");

		} else {
			strBrowserType = new String[] { browser };
		}
		if (browser.toString().contains(",")) {
			strBrowserType = browser.split("\\,");
		} else {
			strBrowserType = new String[] { browser };
		}
		len = strBrowserType.length;
		/*while (i < len) {

			if (strBrowserType[i].toString().equalsIgnoreCase("firefox")) {
				ProfilesIni profile = new ProfilesIni();
				FirefoxProfile ffprofile = profile.getProfile("Quickflix");
				//ffprofile.setEnableNativeEvents(true);

				webDriver = new FirefoxDriver();
				i = i + 1;
				break;

			} else if (strBrowserType[i].toString().equalsIgnoreCase("ie")) {
				File file = new File("Drivers\\IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver",
						file.getAbsolutePath());

				DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
				caps.setCapability(
				    InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,
				    true);
				webDriver = new InternetExplorerDriver(caps);
				i = i + 1;
				
				break;

			} else if (strBrowserType[i].toString().equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"Drivers\\chromedriver.exe");
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("test-type");
				  capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				
				webDriver = new ChromeDriver(capabilities);
				
				i = i + 1;
				break;

			}

		}*/
		/*driver = new EventFiringWebDriver(webDriver);

		ActionEngineSupport myListener = new ActionEngineSupport();
		driver.register(myListener);
		
				try {
					
						url = (configProps.getProperty("URL"));
					

		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println(e1);
		}
				try{
					
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		//driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.get(url);*/
		
		
		
		
		Reporter.reportCreater();
		HtmlReportSupport.currentSuit = "MagicBriks";
			/*}catch(Exception e){
				e.printStackTrace();
			}*/
		
				
}
	@BeforeClass(alwaysRun = true)
	public static void openBrowser(){
		
		/* //create object of FireFoxProfile inbuilt class to access its properties
		FirefoxProfile fprofile=new FirefoxProfile();
		 //set location to store files after downloading
		fprofile.setPreference("browser.download.dir", configProps.getProperty("downloadfilespath"));
		fprofile.setPreference("browser.download.folderList", 2);
		
		//set preference to not show file download confirmation dialogue using MIME types of different file extension types
		fprofile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				  "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;" //MIME types of MS Excel file
				  + "application/pdf;" //MIME type of PDF file
				  + "application/vnd.openxmlformats-officedocument.wordprocessingml.document;" //MIME type of MS doc file
				  + "text/plain;" //MIME type of Text file
				  + "text/csv"); //MIME file of CSV file
				  
		  fprofile.setPreference("browser.download.manager.showWhenStarting", false);
		  fprofile.setPreference("pdfjs.disabled", true);
		  
		//pass fprofile parameter in webdriver to use preferences to download file
		  webDriver=new FirefoxDriver(fprofile);
		*/
		  
		  
		
		System.setProperty("webdriver.chrome.driver",
				"Drivers\\chromedriver.exe");
		webDriver = new ChromeDriver();
		driver = new EventFiringWebDriver(webDriver);
		ActionEngineSupport myListener = new ActionEngineSupport();
		driver.register(myListener);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		//driver.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.get(configProps.getProperty("URL"));
	}
	/*@AfterClass(alwaysRun = true)
	public static void closeBrowser(){
		
		driver.quit();
	}*/

	/**
	 * De-Initializing and closing all the connections
	 * 
	 * @throws Throwable
	 */
	

	@AfterSuite(alwaysRun = true)
	public void tearDown(ITestContext ctx) throws Throwable {
		
		ReportStampSupport.calculateSuiteExecutionTime();
		
		HtmlReportSupport.createHtmlSummaryReport(browser, url);

		//driver.quit();
		closeSummaryReport();
		try {
			String sendReporMailFlag = xlsrdr.getCellValue(
					"sendReprotMailFlag", "value");
			if (sendReporMailFlag.equalsIgnoreCase("TRUE")) {
				String filePath = System.getProperty("user.dir") + "\\"
						+ filePath() + "\\SummaryResults_" + timeStamp+ ".html";
				/*MailUtility.sendReportAsMailBody(filePath,
						"Test Summary Report " + timeStamp);*/
				//MailandZipUtility.sendNotification();
				//BarchartUtil.zipFolder(configProps.getProperty("srcFolder"),"Reports");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	

	/**
	 * Write results to Browser specific path
	 * 
	 * @Date 19/02/2013
	 * @Revision History
	 * 
	 */
	// @Parameters({"browserType"})
	public static String filePath() {
		String strDirectoy = "";
		
			if (browser.equalsIgnoreCase("ie")) {
				strDirectoy = "IE\\IE";

			} else if (browser.equalsIgnoreCase("firefox")) {
				strDirectoy = "Firefox\\Firefox";

			} else {
				strDirectoy = "Chrome\\Chrome";
				
			}

		if (strDirectoy != "") {
			new File(configProps.getProperty("screenShotPath") + strDirectoy
					+ "_" + timeStamp).mkdirs();
		}
	
		File results = new File(configProps.getProperty("screenShotPath") + strDirectoy
			+ "_" + timeStamp+"\\"+"Screenshots");
		if(!results.exists())
		{
			results.mkdir();
			HtmlReportSupport.copyLogos();
		}

		return configProps.getProperty("screenShotPath") + strDirectoy + "_"
				+ timeStamp + "\\";

	}

	/**
	 * Browser type prefix for Run ID
	 * 
	 * @Date 19/02/2013
	 * @Revision History
	 * 
	 */
	public static String result_browser() {
		if (groupNames.equals("")) {
			if (configProps.getProperty("browserType").equals("ie")) {
				return "IE";
			} else if (configProps.getProperty("browserType").equals("firefox")) {
				return "Firefox";
			} else {
				return "Chrome";
			}
		} else {
			if (browser.equalsIgnoreCase("ie")) {
				return "IE";

			} else if (browser.equalsIgnoreCase("firefox")) {
				return "Firefox";

			} else {
				return "Chrome";

			}
		}
	}

	/**
	 * Related to Xpath
	 * 
	 * @Date 19/02/2013
	 * @Revision History
	 * 
	 */
	public static String methodName() {
		
			if (browser.equals("ie")) {
				return "post";
			} else {
				return "POST";
			}
		}
	@BeforeMethod(alwaysRun = true)
	public void reportHeader(Method method, ITestContext ctx) throws Throwable {
		itc = ctx;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MMM_yyyy hh mm ss SSS");
		String formattedDate = sdf.format(date);
		ReportStampSupport.calculateTestCaseStartTime();

		flag = false;

		HtmlReportSupport.tc_name = method.getName().toString() + "-"
				+ formattedDate;
		String[] ts_Name = this.getClass().getName().toString().split("\\.");
		HtmlReportSupport.packageName = ts_Name[0] + "." + ts_Name[1] + "."
				+ ts_Name[2];


			HtmlReportSupport.testHeader(HtmlReportSupport.tc_name, browser);

		stepNum = 0;
		PassNum = 0;
		FailNum = 0;
		testName = method.getName();

	}
	
	
	
	@AfterMethod(alwaysRun = true)
	public static void tearDown() throws IOException, Throwable
	{
		ReportStampSupport.calculateTestCaseExecutionTime();
		closeDetailedReport();
		if(FailNum!=0)
		{
			failCounter=failCounter+1;
			testResults.put(HtmlReportSupport.tc_name, "FAIL");
			
		}
		else
		{
			testResults.put(HtmlReportSupport.tc_name, "PASS");
			passCounter=passCounter+1;
		}
		int totalTestNo = passCounter+failCounter;
		//System.out.println("***********totalTestNo******"+totalTestNo);
		if(FailNum!=0)
		{
			System.out.println("*****totalTestNo"+totalTestNo);
			
			
		}
		else
		{
			//System.out.println("******---------totalTestNo"+totalTestNo);
			
		}
		
		driver.quit();
		//OneWayTrip.WordResult();
	}
	
	
}
