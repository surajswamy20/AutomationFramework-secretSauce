package base;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class resorces  {

	static String url = "https://www.saucedemo.com/";
	public static String k = "Sauce Labs Backpack";

	public static String username = "standard_user";
	public static String password = "secret_sauce";

	@DataProvider(name = "k")
	Object[][] data() {

		Object d[][] = { { "standard_user", "secret_sauce" } };

		return d;
	}
	
	
	//reading data from sxcel sheet 
	void datareaderfromsheet() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"data_from sheet\\Workbook1.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(file);
		 XSSFSheet sheet =  workbook.getSheet("sheet1");
		 int totalrows = sheet.getLastRowNum();
		 int totalcell=	sheet.getRow(1).getLastCellNum();
		 
		 System.out.println("nuber of rows"+ totalrows);
		 System.out.println("nuber of colums"+ totalcell);
		 
		 for(int r =0; r<=totalrows; r++) {
			 for(int c =0; c<totalcell;c++) {
				 
			 }
		 }
		 

	}

}
