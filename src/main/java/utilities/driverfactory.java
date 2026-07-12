
package utilities;

import java.time.Duration;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

public class driverfactory {

	public static WebDriver driver;
	// commenting this legacy webdriver since the thread execution is paralle. so to
	// avoid share threading we have to implement the threadlocal class;

	// public static ThreadLocal <WebDriver> driver = new ThreadLocal<>();

	public static WebDriver getdriver(String br) {
		switch (br.toLowerCase()) {
		case "chrome":
			if (driver == null)
				driver = new ChromeDriver();
			// driver.set(new ChromeDriver());
			break;

		case "edge":
			if (driver == null)
				driver = new EdgeDriver();
			// driver.set(new EdgeDriver());;
			break;

		case "firefox":
			if (driver == null)
				driver = new FirefoxDriver();
			// driver.set(new FirefoxDriver());
			break;

		default:
			System.out.println("Invalid browser");
			return null;

		}
		return driver;

	}

	public static void quitdriver() {

		if (driver != null) {
			System.out.println("Teardown Executing");
			// driver.quit;
			driver.quit();
			driver = null;

		}

	}
	

	public static WebDriver getdriver() {
		
		return driver;
	}

}
