package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.ExtentReportManager;

public class DressResultPage extends BasePage{
    public DressResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='India']")
    private WebElement chkIndia;

    public void clickOnIndiaCheckBox(){
        try {
            chkIndia.click();
            ExtentReportManager.logPass("Click on "+chkIndia.getSize());
        }catch (Exception e){
            ExtentReportManager.logFail("Can not find the locator "+chkIndia.getSize());
        }

    }
}
