package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {

	WebDriver driver;

	// Constructor
	public loginPage(WebDriver driver) {
		this.driver = driver;

	}

	// locator
	// username
	By username = By.id("user-name");
	// password
	By password = By.id("password");
	// login
	By login = By.id("login-button");

	// actionmethods
	public void loginUser(String user, String passkey) {
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(passkey);
		driver.findElement(login).click();

	}

}
