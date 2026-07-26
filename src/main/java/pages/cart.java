package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class cart {

	ThreadLocal<WebDriver> driver;
	String k = "Sauce Labs Backpack";

	// costuctor

	public cart(ThreadLocal<WebDriver> driver) {
		this.driver = driver;

	}

	// locators
	By cartdirection = By.className("shopping_cart_link");

	// By pricebar = By.className("item_pricebar");
	
	
	

	By item = By.className("cart_item_label");

	// action methods

	public void clickCart() {
		//explicitWait
		WebDriverWait wait = new WebDriverWait(driver.get(),Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartdirection));
		driver.get().findElement(cartdirection).click();
	}

	public List<WebElement> itemcanremover() {
		List<WebElement> p = driver.get().findElements(item);
		return p;
	}

}
