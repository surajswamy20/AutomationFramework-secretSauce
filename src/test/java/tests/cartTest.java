package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import base.resorces;
import base.setup_teardown_utility;
import pages.cart;
import pages.loginPage;
import utilities.driverfactory;
import utilities.implementationOfListeners;


public class cartTest {

	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser" })
	void setup(@Optional("chrome") String br) {
		
		driver = setup_teardown_utility.setup(br);
		loginPage login = new loginPage(driver);
		login.loginUser(resorces.username, resorces.password);
		System.out.println("methods of carttesting starts here");

	}

	@Test(priority = 1, groups = { "sanity, regression" })
	void cartest() {
		cart c = new cart(driver);
		c.clickCart();
		// actual test starts here
		Assert.assertEquals(driver.findElement(By.className("title")).getText(), "Your Cart", "passed");

	}

	@Test(priority = 2, groups = "sanity")
	void continueshoping() {
		cart c = new cart(driver);
		c.clickCart();
		Assert.assertEquals(driver.findElement(By.name("continue-shopping")).getText(), "Continue Shopping", "passed");

	}

	@Test(priority = 6)
	void checkout() {
		cart c = new cart(driver);
		c.clickCart();
		Assert.assertEquals(driver.findElement(By.id("checkout")).getText(), "Checkout");
	}

	@AfterMethod(alwaysRun = true)
	void teardown() {
		setup_teardown_utility.teardown();
		System.out.println("methods of carttesting ends here");

	}

//	@BeforeTest
//	void bt() {
//		System.out.println("before test starts");	}
//	
//	@AfterTest
//	void at() {
//		System.out.println("after test. all tests completed");
//	}
//	
//	@BeforeSuite
//	void bs() {
//		System.out.println("suit  starts");
//	}
//	
//	@AfterSuite
//	void as() {
//		System.out.println("suite ends here");
//	}
//	
//	@BeforeClass
//	void bc() {
//		System.out.println("carttest class starts here");
//	}
//	
//	
//	@AfterClass
//	void ac() {
//		System.out.println(" carttest class ends here");
//	}

}
