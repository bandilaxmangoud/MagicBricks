package com.MagicBricks.testObjects;

import org.openqa.selenium.By;

public class IndigoLocators {
	
	//Main page Locators
	
	public static By IndigoLogoImage=By.xpath(".//*[@id='logoimg']/a/img");
	public static By LogInlnk=By.xpath("//a[@name='LogIn']");
	
	//LogIn Locators
	public static By LoginUserID=By.xpath(".//*[@id='memberLogin_Username']");
	public static By LoginPassword=By.xpath(".//*[@id='memberLogin_Password']");
	public static By LogInbtn=By.xpath(".//*[@id='memberLogin_Submit']");
	
	//Edit Profile
	public static By EditProfile=By.xpath("//a[@id='btnMemEditProfile']");
	public static By EditProfileAddr1=By.xpath(".//*[@id='indiGoMemberProfile_Member_HomeAddress_AddressLine1']");
	public static By EditProfileAddr2=By.xpath(".//*[@id='indiGoMemberProfile_Member_HomeAddress_AddressLine2']");
	public static By UpdateProfile=By.xpath("//a[@id='indiGoMemberProfile_Submit']");
	public static By Reset=By.xpath(".//*[@id='memberProfile']/div[4]/div/div[1]/a");
	
	//Logout
		public static By LogOut=By.xpath(".//*[@id='memlogout']/a");
	
	//Registration
	public static By RegisterMember=By.xpath("//a[contains(.,'Register member.')]");
	public static By RegistrationUserID=By.xpath(".//*[@id='indiGoRegisterMember_Member_Username']");
	public static By RegistrationPassword=By.xpath(".//*[@id='indiGoRegisterMember_Member_Password']");
	public static By RegistrationPasswordConfirm=By.xpath(".//*[@id='indiGoRegisterMember_Member_NewPasswordConfirmation']");
	public static By RegistrationTitle=By.xpath(".//*[@id='indiGoRegisterMember_Member_Name_Title']");
	public static By TitleMr=By.xpath(".//*[@id='indiGoRegisterMember_Member_Name_Title']/option[3]");
	public static By FirstName=By.xpath(".//*[@id='indiGoRegisterMember_Member_Name_First']");
	public static By LastName=By.xpath(".//*[@id='indiGoRegisterMember_Member_Name_Last']");
	public static By RegDOBDate=By.xpath(".//*[@id='indiGoRegisterMember_Member_dobDay']");
	public static By DOBDate=By.xpath(".//*[@id='indiGoRegisterMember_Member_dobDay']/option[8]");
	public static By RegDOBMonth=By.xpath(".//*[@id='indiGoRegisterMember_Member_dobMonth']");
	public static By DOBMonth=By.xpath(".//*[@id='indiGoRegisterMember_Member_dobMonth']/option[5]");
	public static By RegDOBYear=By.xpath(".//*[@id='indiGoRegisterMember_Member_dobYear']");
	public static By DOBYear=By.xpath(".//*[@id='indiGoRegisterMember_Member_dobYear']/option[19]");
	public static By StreetAddr1=By.xpath(".//*[@id='indiGoRegisterMember_Member_HomeAddress_AddressLine1']");
	public static By StreetAddr2=By.xpath(".//*[@id='indiGoRegisterMember_Member_HomeAddress_AddressLine2']");
	public static By Country=By.xpath(".//*[@id='indiGoContact_CountryCode_DropDown']");
	public static By CountryIndia=By.xpath(".//*[@id='indiGoContact_CountryCode_DropDown']/option[101]");
	public static By State=By.xpath(".//*[@id='indiGoRegisterMember_Member_HomeAddress_CountryProvinceState']");
	public static By StateTS=By.xpath(".//*[@id='indiGoRegisterMember_Member_HomeAddress_CountryProvinceState']/option[34]");
	public static By Zipcode=By.xpath(".//*[@id='indiGoRegisterMember_Member_HomeAddress_PostalCode']");
	public static By City=By.xpath(".//*[@id='indiGoRegisterMember_Member_HomeAddress_City']");
	public static By PassengerMobile=By.xpath(".//*[@id='indiGoRegisterMember_Member_HomePhoneNumber_Number']");
	public static By AlternateMobile=By.xpath(".//*[@id='indiGoRegisterMember_Member_MobilePhoneNumber_Number']");
	public static By EmergencyNo=By.xpath(".//*[@id='indiGoRegisterMember_Member_WorkPhoneNumber_Number']");
	public static By Email=By.xpath(".//*[@id='indiGoRegisterMember_Member_PersonalEmailAddress_EmailAddress']");
	public static By Registerbtn=By.xpath(".//*[@id='indiGoRegisterMember_Submit']");
	
	
	
		
	//Search Flights
	public static By BookFlight=By.xpath("//a[@name='BookFlight']");
	public static By Oneway=By.xpath(".//*[@id='Oneway_']");
	public static By RoundTrip=By.xpath(".//*[@id='RoundTrip_']");
	public static By MultiCity=By.xpath(".//*[@id='Multicity_']");
	
	public static By OnewayAlert=By.xpath("//input[@type='submit' and @value='OK']");
	
	public static By From=By.xpath(".//*[@id='txtOriginStationRound']");
	public static By To=By.xpath(".//*[@id='txtDestinationStationRound']");
	
		
	public static By Departing=By.xpath(".//*[@id='indiGoRoundTripSearch_DepartureDate']");
	public static By Returning=By.xpath(".//*[@id='indiGoRoundTripSearch_ReturnDate']");
	
	//Adult
	public static By Adult=By.xpath("//div[@class='spinner adult']/em");
	public static By AdultDecrese=By.xpath("//div[@class='spinner adult']/i[1]");
	public static By AdultIncrease=By.xpath("//div[@class='spinner adult']/i[2]");
	
	//Child
	public static By Child=By.xpath("//div[@class='spinner nonAdult']/em");
	public static By ChildDecrease=By.xpath("//div[@class='spinner nonAdult']/i[1]");
	public static By ChildIncrease=By.xpath("//div[@class='spinner nonAdult']/i[2]");
	
	//Infant
	public static By Infant=By.xpath(".//*[@id='emChild']");
	public static By InfantDecrease=By.xpath("//div[@class='spinner infant']/i[1]");
	public static By InfantIncrease=By.xpath("//div[@class='spinner infant']/i[2]");
	
	public static By SearchFlights=By.xpath(".//*[@id='indiGoRoundTripSearch_Submit']");
	
	public static By SelectFlightlnk=By.xpath("//span[contains(.,'Select Flights')]");
	public static By SelectAndContinuebtn=By.xpath("//input[@id='indiGoAvailability_Submit']");
	
	//Login with Twitter
	public static By TwitterImage=By.xpath("//a[@name='Twitter']");
	public static By TwitterLoginlnk=By.xpath(".//*[@id='signin-link']");
	public static By TwitterLoginUsername=By.xpath(".//*[@id='signin-email']");
	public static By TwitterLoginPassword=By.xpath(".//*[@id='signin-password']");
	public static By TwitterLoginbtn=By.xpath("//input[@value='Log in']");
	public static By TwitterHome=By.xpath(".//*[@id='global-nav-home']/a");
	public static By TwitterSettings=By.xpath(".//*[@id='user-dropdown-toggle']");
	public static By TwitterLogout=By.xpath(".//*[@id='signout-button']/button");
	
	//Login with Face book
	public static By FBImage=By.xpath("//a[@name='Facebook']");
	public static By FBLogo=By.xpath("//i[@class='fb_logo img sp_7XMX65Pq0E7 sx_ccd1d2']");
	public static By FBUserName=By.xpath(".//*[@id='email']");
	public static By FBPassword=By.xpath(".//*[@id='pass']");
	public static By FBLoginbtn=By.xpath(".//*[@id='loginbutton']");
	
	//Schedules
	public static By Schedulelnk=By.xpath("//a[@name='Schedule']");
	public static By ScheduleOrigin=By.xpath(".//*[@id='txtOriginStationsclDm']");
	public static By ScheduleDestination=By.xpath(".//*[@id='txtDestinationStationsclDm']");
	public static By ScheduleSearchFlightslnk=By.xpath(".//*[@id='sclDmSubmit']/a");
	public static By FlightSchedule=By.xpath(".//*[@id='content']/div/div[1]");
	public static By ExportToExcel=By.xpath(".//*[@id='btnExport']/a");
	public static By ExportToPdf=By.xpath(".//*[@id='btnExpdf']/a");
	
	

}
