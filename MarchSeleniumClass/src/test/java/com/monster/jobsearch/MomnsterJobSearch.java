package com.monster.jobsearch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Verify;

public class MomnsterJobSearch {
  @Test
  public void f() throws InterruptedException {
	  System.setProperty("webdriver.gecko.driver","C:\\Eclipse Java\\FirefoxDriver\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		String baseUrl="https://www.monster.com/";
		
		//Load www.monster.com and validate title of the page
		driver.manage().deleteAllCookies();
		driver.get(baseUrl);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String expectedTitle="Monster Jobs - Job Search, Career Advice & Hiring Resources | Monster.com | Monster.com";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		
		//click on find jobs and click on advanced search 
		driver.findElement(By.xpath(".//* /div/nav/div[2]/ul/li[1]/a[contains(text(),'Find Jobs')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//div/nav/div[2]/ul/li[1]/ul/li[1]/a[text()='Advanced Search']")) .click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//Validated advanced job search does exist
	    boolean textpresent=driver.findElement(By.xpath(".//*[@id='jsr']/div/div/div/div/div[1]/h1[contains(text(),'Advanced Job Search')]  ")).isDisplayed();
		Assert.assertTrue(textpresent);		
		//Enter job title,Location nand click on search for jobs
		driver.findElement(By.xpath(".//*[@name='txJobTitle_0']")).sendKeys("IT");
		driver.findElement(By.xpath(".//*[@id='advLocation']")).sendKeys("Orlando, Florida");
		driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_body_body_wacCenterStage_ddlDate']")).sendKeys("Yesterday");
		driver.findElement(By.xpath(" .//*[@id='submitButton']")).click();
	    boolean jobsearch=driver.findElement(By.xpath(".//*[@id='main']/div/h2[contains(text(),'202 Jobs Found')]")).isDisplayed();
	    System.out.println(jobsearch);
		Verify.verify(jobsearch);
		//driver.quit();
		
	  
  }
}
