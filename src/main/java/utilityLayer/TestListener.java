package utilityLayer;

	import java.text.SimpleDateFormat;
	import java.util.Date;

	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;

	public class TestListener implements ITestListener {

		ExtentReports extentReport;
		ExtentTest extentTest;

		@Override
		public void onStart(ITestContext context) {

			String projectName = context.getSuite().getName();

			extentReport = new ExtentReports();
			// Reports

			// 2026
			SimpleDateFormat simple1 = new SimpleDateFormat("yyyy");
			String year = simple1.format(new Date());

			// Mar-2026
			SimpleDateFormat simple2 = new SimpleDateFormat("MMM-yyyy");
			String monthYear = simple2.format(new Date());

			// 12-Mar-2026
			SimpleDateFormat simple3 = new SimpleDateFormat("dd-MMM-yyyy");
			String date = simple3.format(new Date());

			// 12-Mar-2026 08:27:10_ProjectName_extentReports.html
			SimpleDateFormat simple4 = new SimpleDateFormat("dd-MMM-yyyy HH-mm-ss");
			String dateTime = simple4.format(new Date());

			String path = System.getProperty("user.dir") + "\\Reports\\" + year + "\\" + monthYear + "\\" + date + "\\"
					+ dateTime + "_" + projectName + "_extentReports.html";

			ExtentSparkReporter reporter = new ExtentSparkReporter(path);

			extentReport.attachReporter(reporter);

		}

		@Override
		public void onTestStart(ITestResult result) {

			String tcname = result.getMethod().getMethodName();

			extentTest = extentReport.createTest(tcname);

		}

		@Override
		public void onTestSuccess(ITestResult result) {

			String tcname = result.getMethod().getMethodName();

			extentTest.log(Status.PASS, tcname);

			String destinationPath = Screenshots.takeaScreenshot("PassScreenshot", tcname);

			extentTest.addScreenCaptureFromPath(destinationPath);

		}

		@Override
		public void onTestFailure(ITestResult result) {

			String tcname = result.getMethod().getMethodName();

			extentTest.log(Status.FAIL, tcname);

			String destinationPath = Screenshots.takeaScreenshot("FailScreenshot", tcname);

			extentTest.addScreenCaptureFromPath(destinationPath);

		}

		@Override
		public void onTestSkipped(ITestResult result) {

			extentTest.log(Status.SKIP, result.getMethod().getMethodName());
		}

		@Override
		public void onFinish(ITestContext context) {

			extentReport.flush();

		}


}
