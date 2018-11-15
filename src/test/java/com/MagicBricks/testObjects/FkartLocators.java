package com.MagicBricks.testObjects;

import org.openqa.selenium.By;

public class FkartLocators {
	
	// Flipkart Login
	public static By MenuImage=By.xpath(".//*[@id='fk-mainhead-id']/descendant::a/img");
	public static By Loginlnk=By.xpath(".//*[@id='fk-mainhead-id']/descendant::ul/li[8]/a[1]");
	public static By Emailid=By.xpath("//input[@class='fk-input login-form-input user-email']");
	public static By Password=By.xpath("//input[@class='fk-input login-form-input user-pwd']");
	public static By LogOn=By.xpath("//input[@class='submit-btn login-btn btn']");
	
	public static By Moveto_accName=By.xpath("//div[@id='fk-mainhead-id']/descendant::ul/li[7]/a");
	public static By LogOut=By.xpath("//div[@id='fk-mainhead-id']/descendant::ul/li[7]/ul/li[10]/a");
	
	public static By login=By.xpath("//*[@id=\"homepage\"]/header/div[1]/div/nav/ul/li[4]/a/span");
	public static By UName=By.xpath("//*[@id=\"user_email\"]");
	public static By Pwd=By.xpath("//*[@id=\"user_password\"]");
	public static By LogIn=By.xpath("//*[@id=\"new_user\"]/div[3]/input");
	

}
