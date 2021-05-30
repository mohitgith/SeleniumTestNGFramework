package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
//		ITestListener.super.onTestStart(result);
		System.out.println("*****onTestStart*****" + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
//		ITestListener.super.onTestSuccess(result);
		System.out.println("*****onTestSuccess*****" + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
//		ITestListener.super.onTestFailure(result);
		System.out.println("*****onTestFailure*****" + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
//		ITestListener.super.onTestSkipped(result);
		System.out.println("*****onTestSkipped*****" + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
//		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
		System.out.println("*****onTestFailedButWithinSuccessPercentage*****" + result.getName());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
//		ITestListener.super.onTestFailedWithTimeout(result);
		System.out.println("*****onTestFailedWithTimeout*****" + result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		
//		ITestListener.super.onStart(context);
		System.out.println("*****onStart*****" + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		
//		ITestListener.super.onFinish(context);
		System.out.println("*****onFinish	*****" + context.getName());
	}

	
}
