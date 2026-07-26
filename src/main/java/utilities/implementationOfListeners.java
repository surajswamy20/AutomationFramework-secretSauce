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

//public class implementationOfListeners implements ITestListener {
//	
//	public ExtentSparkReporter sparkreport;
//	public ExtentReports report;
//	public ExtentTest test;
//	
//	public void onStart(ITestContext context) {
//		System.out.println("test started...");
//		sparkreport = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myreprts.html");
//		sparkreport.config().setDocumentTitle("automation report");
//		sparkreport.config().setReportName("testing website secret sauce");
//		sparkreport.config().setTheme(Theme.DARK);
//		
//		report = new ExtentReports();
//		report.attachReporter(sparkreport);
//		
//		report.setSystemInfo("computer name", "localhost - SURAJ");
//		report.setSystemInfo("environment", "QA");
//		report.setSystemInfo("tester name", "suraj s");
//		report.setSystemInfo("os", "windows");
//		report.setSystemInfo("brwser name", "chrome");
//		report.setSystemInfo("chrome version", "149...");	
//		
//
//	}
//	
//
//	
//	public void onTestSuccess(ITestResult result) {
//		System.out.println("test passed...");
//		test = report.createTest(result.getName());
//		test.log(Status.PASS, "test cases passed is" +result.getName());
//		
//		File src = ((TakesScreenshot)driverfactory.getdriver()).getScreenshotAs(OutputType.FILE);
//		System.out.println("taking screenshot");
//		try {
//			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"/screenshots/"+result.getName()+".png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		test.addScreenCaptureFromPath(System.getProperty("user.dir")+"/screenshots/"+result.getName()+".png");
//		
//	}
//	
//	@Parameters({ "browser" })
//	public void onTestFailure(ITestResult result, String br) {
//		System.out.println("test failed ...");
//		
//		test= report.createTest(result.getName());
//		test.log(Status.FAIL, "test case failed " + result.getName());
//		test.log(Status.FAIL, "test case failed cause is" + result.getThrowable());
//		File src = ((TakesScreenshot)driverfactory.getdriver(br)).getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"./Screenshots/error.png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		
//		
//		
//	}
//	
//	public void onTestSkipped(ITestResult result) {
//		System.out.println("test skipped...");
//		test = report.createTest(result.getName());
//		test.log(Status.SKIP, "test case has skipped" +  result.getName());
//	}
//
//
//	public void onTestStart(ITestResult result) {
//		System.out.println("this is onstart before exe the tests.... test satrted");
//	}
//	
//	//mandetory method to perform for generating an extent reprot 
//
//	public void onFinish(ITestContext context) {
//		System.out.println("test execution is completed....");
//		
//		report.flush();
//		
//	}
//	}

public class implementationOfListeners implements ITestListener{
	
	private ThreadLocal<ExtentSparkReporter> sparkreport = new ThreadLocal<>();
	public ThreadLocal<ExtentReports> report = new ThreadLocal<>();
	public ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	
//	public void OnStart(ITestContext context) {
//		
//	}
	
	public void onStart(ITestContext context) {
	    // not implemented
		String whichbrowser =context.getCurrentXmlTest().getParameter("browser");
		sparkreport.set( new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/"+whichbrowser+"_reprot.html"));
		sparkreport.get().config().setDocumentTitle("Automation-Test Lib");
		sparkreport.get().config().setReportName("Testing- SecreSauce");
		sparkreport.get().config().setTheme(Theme.DARK);
		report.set( new ExtentReports());
		report.get().attachReporter(sparkreport.get());
		report.get().setSystemInfo("System", "SURI");
		report.get().setSystemInfo("Device", "Windows");
		report.get().setSystemInfo("browser", whichbrowser);
		report.get().setSystemInfo("Version", "149");		
		
		
	  }
	
	
	public void onTestSuccess(ITestResult result) {
		test.set(report.get().createTest(result.getMethod().getMethodName()));
		test.get().log(Status.PASS, "test has been passed " + " "+result.getTestClass().getName()+" "+result.getName());
		System.out.println("taking screenshot");
		File src = ((TakesScreenshot)driverfactory.getdriver().get()).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"/screenshot/"+driverfactory.gerBrowserName()+"/"+result.getName()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.get().addScreenCaptureFromPath(System.getProperty("user.dir")+"/screenshot/"+driverfactory.gerBrowserName()+"/"+result.getName()+".png");
		
	    // not implemented
	  }

	
	public void onTestFailure(ITestResult result) {
		test.set( report.get().createTest(result.getMethod().getMethodName()));
		test.get().log(Status.FAIL, "test case has been fialed" +result.getName()	);
	//	File src = ((TakesScreenshot)driverfactory.getdriver()).getScreenshotAs(OutputType.FILE);
		File src = ((TakesScreenshot)driverfactory.getdriver().get()).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"/screenshot/"+driverfactory.gerBrowserName()+"/"+result.getName()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.get().addScreenCaptureFromPath(System.getProperty("user.dir")+"/screenshot/"+driverfactory.gerBrowserName()+"/"+result.getName()+".png");
		
	}
	
	//public  void onTestFailure(ITestResult result) {
	   
	//  }

	
	public void onTestSkipped(ITestResult result) {
		System.out.println("test skipped...");
		test.set( report.get().createTest(result.getMethod().getMethodName()));
		test.get().log(Status.SKIP, "test case has skipped" +  result.getName());
		File src = ((TakesScreenshot)driverfactory.getdriver().get()).getScreenshotAs(OutputType.FILE);
		

		try {
			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"/screenshot/"+driverfactory.gerBrowserName()+"/"+result.getName()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.get().addScreenCaptureFromPath(System.getProperty("user.dir")+"/screenshot/"+driverfactory.gerBrowserName()+"/"+result.getName()+".png");
		
	}

	
//	public void OnTestStart(ITestResult result)
//	{
//		
//	}
	public void onTestStart(ITestResult result) {
	System.out.println("this is onstart before exe the tests.... test satrted");

	  }
	
	

	
	public void onFinish(ITestContext context) {
		report.get().flush();
	}
	
}
