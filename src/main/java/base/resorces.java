package base;

import org.testng.annotations.DataProvider;

public class resorces {

	static String url = "https://www.saucedemo.com/";
	public static String k = "Sauce Labs Backpack";

	public static String username = "standard_user";
	public static String password = "secret_sauce";

	@DataProvider(name = "k")
	Object[][] data() {

		Object d[][] = { { "standard_user", "secret_sauce" } };

		return d;
	}

}
