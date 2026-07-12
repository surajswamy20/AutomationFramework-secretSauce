package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class product {

	WebDriver driver;

	// constructor
	public product(WebDriver driver) {
		this.driver = driver;
	}

	// locators
	By title = By.className("title");
	By logo = By.className("app_logo");

	By items = By.className("inventory_item_name");

	By itemadd = By.id("add-to-cart-sauce-labs-backpack");
	By cartdirection = By.className("shopping_cart_link");

	By continueshoping = By.className("back-image");

	// action methods

	public String getitle() {
		return driver.findElement(title).getText();

	}

	public String getlogo() {
		return driver.findElement(logo).getText();
	}

	public List<String> getitems() {
		List<WebElement> a = driver.findElements(items);
		List<String> b = new ArrayList<>();

		for (WebElement i : a) {
			// System.out.println(i.getText());
			b.add(i.getText());
		}

		return b;

	}

	public void additem() {
		driver.findElement(itemadd).click();

	}

	public void backtoshoping() {
		driver.findElement(continueshoping).click();

	}

	public void clickCart() {
		driver.findElement(cartdirection).click();
	}

}
