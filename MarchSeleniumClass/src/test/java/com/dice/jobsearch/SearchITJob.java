package com.dice.jobsearch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class SearchITJob {
	@Test
	public void f() throws InterruptedException {
		//System.setProperty("webdriver.gecko.driver","C:\\Eclipse Java\\FirefoxDriver\\geckodriver.exe");
		//WebDriver driver=new FirefoxDriver();
		ChromeDriverManager.getInstance().setup();
		WebDriver driver = new ChromeDriver();   
		driver.manage().deleteAllCookies();
		String baseUrl="http://www.dice.com/";
		driver.get(baseUrl);
		String expectedTitle="Tech Jobs | US Contract and Permanent IT Jobs | Dice.com";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		//click on teach career and then job search
		driver.findElement(By.xpath(".//*[@id='newNav']/div/div/ul/li/a[@style='cursor:pointer;']")).click();
		driver.findElement(By.xpath(".//*[@id='newNav']/div/div/ul/li/ul/li/a[contains(text(),'Job Search')]")).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//click on contract check box, type ITon the text box,and enter zip code-33126 and click the jpb search button  
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='job']")).sendKeys("IT");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='location']")).clear();
		driver.findElement(By.xpath(".//*[@id='location']")).sendKeys("33126");
		boolean contracts = driver.findElement(By.xpath(".//*/div/div/span/input[@value='Contracts']")).isSelected();
		//Thread.sleep(5000);
		if (!contracts){
			driver.findElement(By.xpath(".//*/div/div/span/input[@value='Contracts']")).click();
		}
		driver.findElement(By.xpath(".//*[@id='searchJob']/div/div/input[@type='button']")).click();
		Thread.sleep(5000);
		boolean isDisplayed=driver.findElement(By.xpath(".//*[@id='resultSec']/div/div/div/h1")).isDisplayed();
		if(isDisplayed){
			System.out.println("text isDisplayed" );
		}
		else{
			System.out.println("text is not Displayed");
		}
		//Assert.assertTrue(textpresent);
		driver.findElement(By.xpath(".//*[@id='positionTitle']/div/span")).getLocation();//title plus sign
		driver.findElement(By.xpath(".//*[@id='positionTitle']/div/span")).click();
		//dropdown.selectByVisibleText("");
		driver.findElement(By.xpath(".//*/div/div/input[@chkval='Project+Manager']")).getLocation();//project manager
		driver.findElement(By.xpath(".//*/div/div/input[@chkval='Project+Manager']")).click();
		boolean ProjectManagerDisplayed=driver.findElement(By.xpath(".//*[@id='resultSec']/div/div/div/h1")).isDisplayed();
		if(ProjectManagerDisplayed){
			System.out.println("text Displayed");
		}
		else{
			System.out.println("text not Displayed");
		}
	}
}
