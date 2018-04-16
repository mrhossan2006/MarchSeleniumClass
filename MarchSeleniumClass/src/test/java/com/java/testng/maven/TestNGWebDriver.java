package com.java.testng.maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGWebDriver {
	//	public WebDriver driver=new FirefoxDriver();
	//	public String baseUrl="https://www.youtube.com/";

	@Test
	public  void VerifyHomePageTitle(){
		//	 WebDriver driver=new FirefoxDriver();
		//	 String baseUrl="https://www.youtube.com/";
		System.setProperty("webdriver.gecko.driver","C:\\Eclipse Java\\FirefoxDriver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		String baseUrl="https://www.monster.com/";
		driver.get(baseUrl);
		String expectedTitle="Monster Jobs - Job Search, Career Advice & Hiring Resources | Monster.com | Monster.com";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.quit();
	}


}
