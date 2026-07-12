package tests;

import java.time.Duration;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.resorces;
import base.setup_teardown_utility;
import pages.loginPage;
import utilities.driverfactory;

public class LoginPageTest {

	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser" })
	void setup(@Optional("chrome") String br) {
		String b = br;
		driver = setup_teardown_utility.setup(b);
		System.out.println("methods of loginpagetesting starts here");

	}

	@Test(priority = 1, dataProvider = "k", dataProviderClass = resorces.class, groups = "sanity")
	void testing(String username, String password) {
		loginPage login = new loginPage(driver);
		login.loginUser(username, password);
		// driverfactory.clearalert();

		Assert.assertEquals(driver.findElement(By.className("title")).getText(), "Products");

	}

	@Test(priority = 2)
	void testinglogincred() {
		loginPage login = new loginPage(driver);
		login.loginUser("username", "password");
		// driverfactory.clearalert();

		Assert.assertEquals(driver.findElement(By.className("error-message-container")).getText(),
				"Epic sadface: Username and password do not match any user in this service");
	}

	@AfterMethod(alwaysRun = true)
	void teardown() throws InterruptedException {
		// driverfactory.clearalert();
		setup_teardown_utility.teardown();
		System.out.println("methods of loginpagetesting ends here");

	}

//    @BeforeClass
//	void bc() {
//		System.out.println(" loginpagetest class starts here");
//	}
//	
//	
//	@AfterClass
//	void ac() {
//		System.out.println(" loginpagetest class ends here");
//	}
}