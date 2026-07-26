package tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.resorces;
import base.setup_teardown_utility;
import pages.cart;
import pages.loginPage;
import pages.product;
import utilities.driverfactory;

public class ProductTest {

	ThreadLocal<WebDriver> driver;

	product p;

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser" })
	void setup(@Optional("chrome") String br) {
		String b = br;
		driver = setup_teardown_utility.setup(b);
		loginPage login = new loginPage(driver);
		login.loginUser(resorces.username, resorces.password);
		System.out.println("methods of productpagetesting starts here");

	}

	@Test(groups = { "sanity", "regression", "tedx" })
	void verifyProductPagetitle() throws InterruptedException {
		p = new product(driver);

		//Thread.sleep(Duration.ofSeconds(3));


//    	WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//    	Wait.until(ExpectedConditions.visibilityOfElementLocated(null));
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(p.getitle(), "Products", "title passed ");

		sa.assertAll();

	}

	@Test(priority = 8, groups = "sanity")
	void backtoprroduct() throws InterruptedException {
		p = new product(driver);
		cart c = new cart(driver);
		c.clickCart();
		p.backtoshoping();
		//Thread.sleep(Duration.ofSeconds(30));
		Assert.assertEquals(p.getitle(), "Products", "title passed ");

	}

	@Test(priority = 3)
	void verifyProductPagelogo() {
		p = new product(driver);
		Assert.assertEquals(p.getlogo(), "Swag Labs");

	}

	@Test(priority = 1, alwaysRun = true)
	void inventryitems() {
		p = new product(driver);

		if (p.getitems().contains(resorces.k)) {
			p.additem();
			System.out.println("item gets added");
		} else
			System.out.println("item doesn't exist");

		p.clickCart();
		Assert.assertTrue(p.getitems().contains(resorces.k));
	}

	@Test(priority = 2)
	void removeitems() {
		p = new product(driver);

		if (p.getitems().contains(resorces.k)) {
			p.additem();
			System.out.println("item gets added");
		} else
			System.out.println("item doesn't exist");

		cart c = new cart(driver);
		c.clickCart();
		for (WebElement l : c.itemcanremover()) {
			if (l.getText().contains(resorces.k)) {
				// System.out.println(l.getText());
				l.findElement(By.className("cart_button")).click();
			}

		}

		Assert.assertFalse(c.itemcanremover().contains(resorces.k));

	}

	@AfterMethod(alwaysRun = true)
	void teardown() {
		setup_teardown_utility.teardown();
		System.out.println("methods of productpagetesting ends here");
	}

//    @BeforeClass
//	void bc() {
//		System.out.println(" producttest class starts here");
//	}
//	
//	
//	@AfterClass
//	void ac() {
//		System.out.println(" producttest class ends here");
//	}
//    

}