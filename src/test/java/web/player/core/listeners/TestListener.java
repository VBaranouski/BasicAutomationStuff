package web.player.core.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println(iTestResult.getClass() + ": '" + iTestResult.getName() + "' test has started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println(iTestResult.getClass() + ": '" + iTestResult.getName() + "' test is PASSED");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println(iTestResult.getName() + ": failed!");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }
}
