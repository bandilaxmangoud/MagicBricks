package com.MagicBricks.testObjects;

import org.openqa.selenium.By;

public class MagentoLocators {
	//Home page
	public static By ImageLogo=By.xpath("//a[@class='logo']");
	public static By MobileLnk=By.xpath(".//*[@id='nav']/ol/li[1]/a");
	
	//Mobile page						
	public static By SortBy=By.xpath("//select[@title='Sort By']");
	public static By SortBy_Name=By.xpath("//select/option[2]");
	public static By ProductNames=By.xpath("//h2[@class='product-name']/a");
	public static By ProductPrice=By.xpath("//div[@class='price-box']");	//product prices in mobile page
	public static By SonyXperiaLnk=By.xpath("//div[@class='category-products']/ul/li[1]/div/h2/a");//mobile page
	public static By IPhoneLnk=By.xpath("//div[@class='category-products']/ul/li[2]/div/h2/a");
	public static By SamsungGlxyLnk=By.xpath("//div[@class='category-products']/ul/li[3]/div/h2/a");
	public static By SonyXperiaAddtoCartBtn=By.xpath("//div[@class='category-products']/ul/li[1]/div/div[3]/button");
	public static By SonyXperiaAddtoCartEdit=By.xpath("//input[@class='input-text qty']");
	public static By SonyXperiaAddtoCartUpdate=By.xpath(".//*[@id='shopping-cart-table']/tbody/tr/td[4]/button");
	public static By EmptyCartLnk=By.xpath(".//*[@id='empty_cart_button']");
	public static By EmpyCartTable=By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div");
	public static By ErrMsg=By.xpath("//li[@class='error-msg']/ul/li/span");
	public static By CartEmpty=By.xpath("//div[@class='page-title']/h1");
	public static By SonyXperiaAddToCompare=By.xpath("//div[@class='category-products']/ul/li[1]/div/div[3]/ul/li[2]/a");
	public static By IPhoneAddToCompare=By.xpath("//div[@class='category-products']/ul/li[2]/div/div[3]/ul/li[2]/a");
	public static By CompareBtn=By.xpath("//div[@class='block-content']/div[1]/button");
	public static By PopUpComparePage=By.xpath(".//*[@id='top']/body/div[1]/div[1]/h1");
	
	public static By AccountLnk=By.xpath(".//*[@id='header']/div/div[2]/div/a/span[2]");
	public static By RegisterLnk=By.xpath(".//*[@id='header-account']/div/ul/li[5]/a");
	public static By FirstName=By.xpath(".//*[@id='firstname']");
	public static By LastName=By.xpath(".//*[@id='lastname']");
	public static By Email=By.xpath(".//*[@id='email_address']");
	public static By Password=By.xpath(".//*[@id='password']");
	public static By ConfirmPwd=By.xpath(".//*[@id='confirmation']");
	public static By RegisterBtn=By.xpath(".//*[@id='form-validate']/div[2]/button");

	
	//Mobile cart page
	public static By SonyXperiaPrice=By.xpath(".//*[@id='product-price-1']/span");//sony xperia price in cart page
	
	
	
}
