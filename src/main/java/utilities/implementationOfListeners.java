package utilities;

import java.io.File;
import java.io.IOException;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class implementationOfListeners implements ITestListener {

	private ThreadLocal<ExtentSparkReporter> sparkreport = new ThreadLocal<>();
	public ThreadLocal<ExtentReports> report = new ThreadLocal<>();
	public ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	public void onStart(ITestContext context) {

		String whichbrowser = context.getCurrentXmlTest().getParameter("browser");
		sparkreport.set(
				new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/" + whichbrowser + "_reprot.html"));
		sparkreport.get().config().setDocumentTitle("Automation-Test Lib");
		sparkreport.get().config().setReportName("Testing- SecreSauce");
		sparkreport.get().config().setTheme(Theme.DARK);
		report.set(new ExtentReports());
		report.get().attachReporter(sparkreport.get());
		report.get().setSystemInfo("System", "SURI");
		report.get().setSystemInfo("Device", "Windows");
		report.get().setSystemInfo("browser", whichbrowser);
		report.get().setSystemInfo("Version", "149");

	}

	public void onTestSuccess(ITestResult result) {
		test.set(report.get().createTest(result.getMethod().getMethodName()));
		test.get().log(Status.PASS,
				"test has been passed " + " " + result.getTestClass().getName() + " " + result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		test.set(report.get().createTest(result.getMethod().getMethodName()));
		test.get().log(Status.FAIL, "test case has been fialed" + result.getName());
		// File src =
		// ((TakesScreenshot)driverfactory.getdriver()).getScreenshotAs(OutputType.FILE);
		System.out.println("taking screenshot as the test has failed ");
		File src = ((TakesScreenshot) driverfactory.getdriver().get()).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "/screenshot/"
					+ driverfactory.gerBrowserName() + "/" + result.getName() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.get().addScreenCaptureFromPath(System.getProperty("user.dir") + "/screenshot/"
				+ driverfactory.gerBrowserName() + "/" + result.getName() + ".png");

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("test skipped...");
		test.set(report.get().createTest(result.getMethod().getMethodName()));
		test.get().log(Status.SKIP, "test case has skipped" + result.getName());
		System.out.println("taking screenshot as the test has skipped ");
		File src = ((TakesScreenshot) driverfactory.getdriver().get()).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "/screenshot/"
					+ driverfactory.gerBrowserName() + "/" + result.getName() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.get().addScreenCaptureFromPath(System.getProperty("user.dir") + "/screenshot/"
				+ driverfactory.gerBrowserName() + "/" + result.getName() + ".png");

	}

	public void onTestStart(ITestResult result) {
		System.out.println("this is onstart before execution of the tests.... test started");

	}

	public void onFinish(ITestContext context) {
		report.get().flush();
	}

}
