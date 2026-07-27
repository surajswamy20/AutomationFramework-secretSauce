package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {

	private int count =0; private final int maxtry =2;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<=maxtry) {
			count++;
			System.out.println("retrying method"+result.getMethod().getMethodName()
					+"with count"+count);
			
			return true;
		}
		
		return false;
	}
	
	
	

}
