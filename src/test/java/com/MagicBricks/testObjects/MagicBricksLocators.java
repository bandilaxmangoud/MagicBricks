package com.MagicBricks.testObjects;

import org.openqa.selenium.By;

public class MagicBricksLocators {
	
	//MagicBricks Login
	

    public static By MenuImage = By.xpath("//div[@class='middleData']/descendant::a[@class='sitLogo'][1]");
	public static By Loginbtn = By.xpath("//a[@class='loginLink']");
	public static By Emailid = By.xpath("//input[@id='j_username']");
	public static By password1 = By.xpath("//input[@id='j_password']");
	public static By LogOn = By.xpath("//input[@class='login_btn']");
	public static By SignOut = By.xpath("//a[text()='Sign Out']");
	public static By Loginbtn1 = By.xpath("//a[text()='Login']");
	public static By MainPageSearchbtn = By.xpath("//input[@id='btnPropertySearch']");
	
	public static By Buy = By.xpath("//input[@id='buyRentType']");
	
	public static By City = By.xpath("//body/descendant::span[contains(@class,'ui-combobox')][1]/input");
	public static By TypeofProp = By.xpath("//input[@id='prop_new_propertyType']");
	public static By NoofBedrooms = By.xpath("//input[@id='prop_bedrooms']");
	public static By MinValue = By.xpath("//span[@class='selectMenuArrow priceMinArrow']");
	public static By MaxValue = By.xpath("//span[@class='selectMenuArrow priceMaxArrow']");
	public static By Searchbtn = By.xpath("//input[@class='btnInternalSearch']");
	
	
	public static By Buy1 = By.xpath("//a[@id='buyTab']");
	public static By Rent1 = By.xpath("//a[@id='rentTab']");
	public static By Keyword = By.xpath("//input[@id='keyword']");
	public static By ProType = By.xpath("//div[@id='buy_propertyType']");
	public static By RentProType = By.xpath("//div[@id='rent_propertyType']");
	public static By flat1 = By.xpath("//label[@id='10002_10003_10021_10022']");
	
	public static By Rentflat1 = By.xpath("//label[@id='10002_10003_10021_10022_10020']");
	public static By Room1 = By.xpath("//div[@id='propType_buy']/div[1]/div[3]/div/ul/li[3]/label");
	public static By RentRoom1 = By.xpath("//div[@id='propType_rent']/div[1]/div[3]/div/ul/li[3]/label");
	public static By Budget = By.xpath("//input[@id='buy_budget_lbl']");
	public static By RentBudget = By.xpath("//input[@id='rent_budget_lbl']");
	public static By Range = By.xpath("//span[@id='11803-11804']");
	public static By RentRange = By.xpath("//span[@id='11853-11854']");
	public static By Searchbtn1 = By.xpath("//input[@id='btnPropertySearch']");
	
	public static By Flat = By.xpath("//div[@id='child_prop_new_propertyType9000']/ul/li[1]/label");
	public static By Room = By.xpath("//div[@id='child_prop_bedrooms']/ul/li[3]/label");
	public static By Min = By.xpath("//form[@id='searchFormBean']/div/div[8]/div/div/div[2]/div/div/div/ul/li[2]");
	public static By Max = By.xpath("//form[@id='searchFormBean']/div/div[10]/div/div/div[2]/div/div/div/ul/li[3]");
	
	public static String Residential = "//body/descendant::label[contains(text(),'#')][1]";
	public static String RoomSelection = "//body/descendant::label[contains(text(),'#')][1]";
	public static String BudgetSelection = "//body/descendant::span[contains(text(),'#')]";
	
	public static String RentResidential = "//body/descendant::label[contains(text(),'#')][2]";
	public static String RentRoomSelection = "//input[@id='#']";
	public static String RentBudgetSelection = "//body/descendant::span[contains(text(),'#')]";
	
	
}

//div[@id='accts']/div[1]/div[1]/div[4]