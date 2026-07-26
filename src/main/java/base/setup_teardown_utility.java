package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

import utilities.driverfactory;

public class setup_teardown_utility {

	public static ThreadLocal <WebDriver> driver;

	public static ThreadLocal<WebDriver> setup(String br) {
		String b = br;
		driver = driverfactory.getdriver(b);
		
		driver.get().get(resorces.url);
		return driver;
	}

	public static void teardown() {
		driverfactory.quitdriver();
	}

}