package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.*;

public class ExtentManager {

    private static ExtentReports extent;

    private ExtentManager() {}

    public static ExtentReports getInstance() {

    	if (extent == null) {

            String timestamp = new SimpleDateFormat(
                    "dd_MM_yyyy_HH_mm_ss")
                    .format(new Date());

            String reportPath =
                    System.getProperty("user.dir")
                    + "/reports/Report_"
                    + timestamp
                    + ".html";

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(reportPath);

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }

        return extent;
    }
}
