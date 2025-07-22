package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.ExtentReportManager;

public class MobileResultPage extends BasePage {
    public MobileResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Apple']")
    private WebElement chkApple;

    public void clickOnAppleCheckBox() {
        try {
            chkApple.click();
            ExtentReportManager.logPass("Clicked on " + chkApple.toString());
        } catch (Exception e) {
            ExtentReportManager.logFail("Can not find the locator " + chkApple.toString());
        }

    }
}
