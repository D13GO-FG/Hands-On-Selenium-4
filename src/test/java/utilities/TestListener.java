package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        Log.info("onStart: {" + context.getName() + "}");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        Log.info("onTestStart {" + result.getName() + "}");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        Log.info("onTestSuccess {" + result.getName() + "}");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        Log.error("onTestFailure {" + result.getThrowable() + "}");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        Log.warn("onTestSkipped {" + result.getSkipCausedBy() + "}");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
        Log.warn("onTestFailedButWithinSuccessPercentage {" + result.getThrowable() + "}");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
        Log.error("onTestFailedWithTimeout {" + result.getThrowable() + "}");
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        Log.info("onFinish {" + context.getName() + "}");
    }
}
