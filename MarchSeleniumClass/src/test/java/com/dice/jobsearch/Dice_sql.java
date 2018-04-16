package com.dice.jobsearch;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class Dice_sql {
  @Test
  public void f() {
	  ChromeDriverManager.getInstance().setup();
	  ChromeDriver driver = new ChromeDriver();
	  driver.get("http://www.dice.com/");
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }
}
