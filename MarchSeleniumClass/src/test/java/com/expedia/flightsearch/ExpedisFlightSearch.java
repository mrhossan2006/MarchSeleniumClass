package com.expedia.flightsearch;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Verify;

public class ExpedisFlightSearch {



	@Test
	public void f() throws InterruptedException {

		//Load www.expedia.com and validate title of the web page
		System.setProperty("webdriver.gecko.driver","C:\\Eclipse Java\\FirefoxDriver\\geckodriver.exe");        
		//Load www.expedia.com and validate title of the web page
		//System.setProperty("webdriver.gecko.driver","C:\\Eclipse Java\\FirefoxDriver\\geckodriver.exe");		
		FirefoxDriver driver=new FirefoxDriver();
		String baseUrl="https://www.expedia.com";
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		String expectedTitle="Expedia Travel: Vacations, Cheap Flights, Airline Tickets & Airfares";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		//Click on Flights tab from the menu bar and validate that Search Flights text does exist
		driver.findElement(By.xpath(".//*[@id='primary-header-flight']")).click();
		Thread.sleep(5000);
		boolean flight1=driver.findElement(By.xpath(".//div/div/section/div/h1[contains(text(),'Search Flights')]")).isDisplayed();
		System.out.println(flight1);
		Assert.assertTrue(flight1);

		/*Click on Roundtrip tab and enter Flying from "New York, NY (JFK-John F. Kennedy Intl.) " and
					Flying to "Miami, FL (MIA-All Airports)"*/

		driver.findElement(By.xpath(".//*[@id='flight-type-roundtrip-label-flp']")).click();
		driver.findElement(By.xpath(".//*[@id='flight-origin-flp']")).sendKeys("JFK-John F. Kennedy Intl.");
		driver.findElement(By.xpath(".//*[@id='flight-destination-flp']")).sendKeys("Miami, FL (MIA-Miami Intl.)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Enter departing date today and Returning date tomorrow and Adults value to 1
		driver.findElement(By.id("#package-departing-hp-package")).sendKeys("04/09/2017");
		Thread.sleep(2000);
		driver.findElement(By.id("#package-departing-hp-package")).clear();		
		driver.findElement(By.id("#package-departing-hp-package")).sendKeys("04/10/2017");
		Thread.sleep(2000);		

		Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='flight-adults-flp']")));
		dropdown.selectByVisibleText("2");

		//Click on Search button and validate that Flights search results are returned
		driver.findElement(By.xpath(".//*[@id='gcw-flights-form-flp']/div/label/button/span[text()='Search']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean flightresult1=driver.findElement(By.xpath(".//*[@id='titleBar']/h1/div/span[text()='Select your departure to Miami']")).isDisplayed();
		System.out.println(flightresult1);
		Verify.verify(flightresult1);
		driver.quit();
	}
}
