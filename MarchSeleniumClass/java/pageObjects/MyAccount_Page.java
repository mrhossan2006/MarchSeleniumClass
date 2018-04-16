package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccount_Page {
	private static WebElement element = null;
	public static WebElement link_Logout(WebDriver driver){
		element = driver.findElement(By.xpath(xpathExpression))
	}

}
