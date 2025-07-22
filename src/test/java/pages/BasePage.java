package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import util.ExtentReportManager;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public EbayHomePage initApp(){
        driver.get("https://www.ebay.com/");
        ExtentReportManager.logPass("Successfully navigated to EBay.");
        return PageFactory.initElements(driver, EbayHomePage.class);
    }
}
