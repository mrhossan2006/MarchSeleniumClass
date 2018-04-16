package yahoo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class yahootest {
  @Test
  public void test() throws InterruptedException {
	  ChromeDriverManager.getInstance().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://www.yahoo.com/");
		System.out.println(driver.getCurrentUrl());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.findElement(By.id("uh-signin")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='mbr-login-box']/div/img"));
		Thread.sleep(5000);
		driver.findElement(By.id("login-username")).sendKeys("debazroy@yahoo.com");
		Thread.sleep(5000);
		driver.findElement(By.id("login-signin")).click();
  }
}
