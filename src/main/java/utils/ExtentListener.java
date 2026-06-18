package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

public class ExtentListener implements ITestListener {

	private static final ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                ExtentManager.getInstance()
                        .createTest(result.getMethod().getMethodName());

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentTest extentTest = test.get();

        if (extentTest != null) {
            extentTest.pass("Test Passed");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTest extentTest = test.get();

        if (extentTest != null) {
            extentTest.fail(result.getThrowable());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentTest extentTest = test.get();

        if (extentTest != null) {
            extentTest.skip(result.getThrowable());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getInstance().flush();
    }
 }
