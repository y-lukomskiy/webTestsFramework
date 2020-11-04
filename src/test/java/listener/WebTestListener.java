package listener;

import core.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class WebTestListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		Log.info("Test Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	}

	@Override
	public void onTestFailure(ITestResult result) {
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public synchronized void onStart(ITestContext context) {
		Log.info("The test is started");

	}

	@Override
	public void onFinish(ITestContext context) {
		// close the browser
		Log.info("The test is finished");
	}
}
