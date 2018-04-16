package com.ebay.purches;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Verify;

public class purchesproduct {
  @Test
  public void f() throws InterruptedException {
	//1. Open http://www.ebay.com/ and Validate the title of the page.
		System.setProperty("webdriver.gecko.driver","C:\\Eclipse Java\\FirefoxDriver\\geckodriver.exe");        

			WebDriver driver=new FirefoxDriver();
			//ChromeDriverManager.getInstance().setup();
			//WebDriver driver = new ChromeDriver(); 

			// InternetExplorerDriverManager.getInstance().setup();
			// WebDriver driver = new InternetExplorerDriver(); 

			driver.manage().deleteAllCookies();
			String baseUrl="http://www.ebay.com/";
			driver.get(baseUrl);
			driver.manage().window().maximize();
			String expectedTitle="Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay";
			String actualTitle=driver.getTitle();
			Assert.assertEquals(actualTitle,expectedTitle);


			//2. Once the home page is loaded,  validate that Motors, Fashion, Electronics, Sporting Goods, Toys, Music and Deals Menu bar does exist

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//Thread.sleep(5000);
			boolean motors = driver.findElement(By.xpath(".//*[@id='w0-container']/li/a[text()='Motors']")).isDisplayed();
			System.out.println(motors);
			Assert.assertTrue(motors);

			boolean fashion = driver.findElement(By.xpath(".//*[@id='w0-container']/li/a[text()='Fashion']")).isDisplayed();
			System.out.println(fashion);
			Assert.assertTrue(fashion);
			boolean electronics = driver.findElement(By.xpath(".//*[@id='w0-container']/li/a[text()='Electronics']")).isDisplayed();
			System.out.println(electronics);
			Assert.assertTrue(electronics);
			boolean sporting = driver.findElement(By.xpath(".//*[@id='w0-container']/li/a[text()='Sporting Goods']")).isDisplayed();
			System.out.println( sporting);
			Assert.assertTrue(sporting);
			boolean toys = driver.findElement(By.xpath(".//*[@id='w0-container']/li/a[text()='Toys']")).isDisplayed();
			System.out.println(toys);
			Assert.assertTrue(toys);
			boolean music = driver.findElement(By.xpath(".//*[@id='w0-container']/li/a[text()='Music']")).isDisplayed();
			System.out.println(music);
			Assert.assertTrue(music);
			boolean deals = driver.findElement(By.xpath(".//*[@id='w0-container']/li/a[text()='Deals']")).isDisplayed();
			System.out.println(deals);
			Assert.assertTrue(deals);

			//3. Now click now Electronics and select Cell Phones & Accessories and once the page is loaded validate that Cell Phones & Accessories text does exist.
			driver.findElement(By.xpath(".//*[@id='w0-container']/li/a[text()='Electronics']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(".//*[@id='mainContent']/div/ul/div/li/ul/li/a[contains(text(),'Cell')]")).click();
			//Thread.sleep(5000);
			boolean cellphones = driver.findElement(By.xpath(".//*[@id='mainContent']/div/ul/div/li/ul/li/ul/a[@href='http://www.ebay.com/rpp/cell-phone-pda']")).isDisplayed();
			Assert.assertTrue(cellphones);

			//4. Click Cell Phones & Smartphones from shop by category

			driver.findElement(By.xpath(".//*[@id='mainContent']/div/ul/div/li/ul/li/ul/li/a/span[text()='Cell Phones & Smartphones']")).click();
			//Thread.sleep(10000);



			//5. Click on Apple from Shop by Brand and click on iPhone 7. Now validate that 32GB, 128GB and 256GB is listed
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(".//*[@id='w2-xCarousel-x-carousel-items']/ul/li/a/p[text()='Apple']")).click();
			driver.findElement(By.xpath(".//*[@id='w2-xCarousel-x-carousel-items']/ul/li/a/p[text()='iPhone 7']")).click();
			Thread.sleep(5000);
			boolean gb1 = driver.findElement(By.xpath(".//*/ul/li/a/p[text()='32GB']")).isDisplayed();
			Assert.assertTrue(gb1);
			boolean gb2 = driver.findElement(By.xpath(".//*/ul/li/a/p[text()='128GB']")).isDisplayed();
			Assert.assertTrue(gb2);
			boolean gb3 = driver.findElement(By.xpath(".//*/ul/li/a/p[text()='256GB']")).isDisplayed();
			Assert.assertTrue(gb3);

			//6. Click on 128GB and click on Verizon and click on the 1st item from Best Selling section

			driver.findElement(By.xpath(".//*/ul/li/a/p[text()='128GB']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(".//*/ul/li/a/p[text()='Verizon']")).click();

			//7. Now click on Buy it Now from Brand New Lowest Price and click on Continue as a guest
			driver.findElement(By.xpath(".//*[@id='w2-xCarousel-x-carousel-items']/ul/li/a/div/div[@class='b-info__title']")).click();
			driver.findElement(By.xpath(".//*[@id='binBtn_btn']")).click();
	         driver.findElement(By.xpath(".//*[@id='gtChk']")).click();
			//8. Validate that Guest checkout text does exist
			boolean checkout=driver.findElement(By.xpath("html/body/h1")).isDisplayed();
			Verify.verify(checkout);
			driver.quit();
		}
	
  }

