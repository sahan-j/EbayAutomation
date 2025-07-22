package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Objects;

public class ExtentReportManager {
    private static ExtentReports extentReports;
    private static ExtentTest test;

    public static void initReport(){
        extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter =
                new ExtentSparkReporter(System.getProperty("user.dir")+"/report/ExtentReport.html");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("Ebay search Test");
        sparkReporter.config().setReportName("Ebay search Test");
        extentReports.attachReporter(sparkReporter);
    }

    public static void createTest(String testName){
        test = extentReports.createTest(testName);
    }

    public static void logPass(String message){
        if(Objects.nonNull(test)){
            test.log(Status.PASS,message);
        }
    }

    public static void logFail(String message){
        if (Objects.nonNull(test)){
            test.log(Status.FAIL,message);
        }
    }

    public static void logSkip(String message){
        if (Objects.nonNull(test)){
            test.log(Status.SKIP,message);
        }
    }

    public static void flushReport(){
        if (Objects.nonNull(test)){
            extentReports.flush();
        }
    }

}
