package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import util.BrowserFactory;
import util.ExtentReportManager;

import java.nio.file.WatchEvent;

public class BaseTest {
    protected WebDriver driver;

    protected BrowserFactory browserFactory = BrowserFactory.getBrowserFactory();

    @BeforeSuite
    public void initRepoter() {
        ExtentReportManager.initReport();
    }

    @BeforeMethod
    public void init() {
        driver = browserFactory.getWebDriver();
    }

    @AfterMethod
    public void tearDown() {
        browserFactory.quitDriver();
    }

    @AfterSuite
    public void flushReporter() {
        ExtentReportManager.flushReport();
    }
}
