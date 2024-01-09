package ReportsPackage;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerClassExamples implements ITestListener {

	public ExtentSparkReporter reporter;//UI of the Report(title of the report,rportname,theme)
	public ExtentReports extent;//populate the common information about the user (
	public ExtentTest test;//create the testcase entries into thr report (pass/fail/skip

	public void onStart(ITestContext context) {
		
		//give the report target location
		reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/newReport.html");
	
		//title of the report
		reporter.config().setDocumentTitle("Automation Testing Report");
		//reportname
		reporter.config().setReportName("Functional Testing");
		//set the Theme
		reporter.config().setTheme(Theme.DARK);
		
		//user information
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("hostname", "LocalHost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester", "Kiran");
		extent.setSystemInfo("OS", "Windows 10");
	}
	
	public void onTestSuccess(ITestResult tr) {
		
		test=extent.createTest(tr.getName());//create the new entry to the report
	    test.log(Status.PASS,"Testcases is success:"+ tr.getName());
	}
	
	public void onTestFailure(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.FAIL, "Testcase is failed:" + tr.getName());
		test.log(Status.FAIL, "exception is : "+ tr.getThrowable());
	}
   public void onTestSkip(ITestResult tr) {
	   test=extent.createTest(tr.getName());
	   test.log(Status.SKIP, "Testcase is Skipped: "+ tr.getName());
   }
   
   public void onFinish(ITestContext context) {
	   extent.flush();
   }

}
