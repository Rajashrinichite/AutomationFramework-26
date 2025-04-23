package genericUtilities;

/*import java.awt.event.ItemListener;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementation  implements ITestListener{
	
 public void onTestStart(ITestResult result) {
	 String methodName = result.getMethod().getMethodName();
	 System.out.println(methodName="-->@Test execution Starts");
 }
 public void onTestSuccess(ITestResult result) {
	 String methodName = result.getMethod().getMethodName();
	 System.out.println(methodName="-->@Test is Pass");

 }
  public void onTestFailure(ITestResult result) {
		 String methodName = result.getMethod().getMethodName();
		 System.out.println(methodName="-->@Test is Fail");	
		 //Capture the exception
		 System.out.println(result.getThrowable());
		 
		 //
}
  public void onTestSkipped(ITestResult result) {
		 String methodName = result.getMethod().getMethodName();
		 System.out.println(methodName="-->@Test is Skip");	
		//Capture the exception
		 System.out.println(result.getThrowable());
		 //capture ScreenShot
		 SeleniumUtility s= new SeleniumUtility();
		 javautility j= new javautility();
		  
		 String screenshotName = methodName+"-"+j.getSystemDateInFormat();
		 try {
			    s.captureScreenShot(BaseClass.sdriver, screenshotName);
			    
			 }catch(IOException e) {
				 //TODO Auto Generated catch block
				 e.printStackTrace();
			 }
		 }

  
@Override
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}
@Override
public void onTestFailedWithTimeout(ITestResult result) {
	
}
public void onStart(ITestContext context)
{
	  System.out.println("Suit execution start");
	  
}
public void onFinish(ITestContext context)
{
	  System.out.println("Suit execution Finish");
	  
}*/


import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class ListenersImplementation implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " -> @Test execution started");
		
		//Intimate Extent report for Test
		test = report.createTest(methodName);

	}

	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " -> @Test is pass");
		
		//Log the Test result as PASS in Extent Report
		test.log(Status.PASS, methodName + " -> @Test is pass");

	}

	public void onTestFailure(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " -> @Test is Fail");
		
		//Log the status as FAIL in extent report
		test.log(Status.FAIL, methodName + " -> @Test is Fail");

		// Capture the exception
		System.out.println(result.getThrowable());
		
		//Log the exception in extent report
		test.log(Status.WARNING, result.getThrowable());
		
		//Capture Screenshot
		SeleniumUtility s = new SeleniumUtility();
		javautility j = new javautility();
		
		String screenshotName = methodName+"-"+j.getSystemDateInFormat();
		
		try {
			
			String path = s.captureScreenShot(BaseClass.sdriver, screenshotName);
			
			//Attach the screenshot to extent reports
			test.addScreenCaptureFromPath(path);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public void onTestSkipped(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " -> @Test is skip");
		
		//Log the status as Skip in extent report
		test.log(Status.SKIP, methodName + " -> @Test is skip");

		// Capture the exception
		System.out.println(result.getThrowable());
		
		//Log the exception in extent report
		test.log(Status.WARNING, result.getThrowable());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

		System.out.println("Suite Execution Started");
		
		//Configure the extent reports
        ExtentSparkReporter esr = new ExtentSparkReporter(".ExtentReports\\Report - "+new javautility().getSystemDateInFormat()+".html");
		esr.config().setDocumentTitle("Swag labs Execution report");
		esr.config().setReportName("Execution Report");
		esr.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Env", "Testing");
		report.setSystemInfo("Reporter name", "Chaitra");
          
	}

	public void onFinish(ITestContext context) {

		System.out.println("Suite Execution Finished");
		
		//Generate extent reports
		report.flush();

	}

}
 
