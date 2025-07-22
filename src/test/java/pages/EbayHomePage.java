package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import util.ExtentReportManager;

public class EbayHomePage extends BasePage{
    public EbayHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gh-ac")
    private WebElement searchField;

    @FindBy(id="gh-cat")
    private WebElement selectCategory;

    @FindBy(xpath = "//span[text()='Search']")
    private  WebElement clickOnSearch;

    String categoryName;

    public void fillSearchField(String searchText){
        try{
            searchField.sendKeys(searchText);
            ExtentReportManager.logPass(searchText+ "typed in :"+searchField.toString());
        }catch (Exception e){
            ExtentReportManager.logFail("Can not find the locator "+searchField.toString());
        }

    }

    public void selectCategoryFromDD(String category){
        categoryName = category;
        try{
            new Select(selectCategory).selectByVisibleText(category);
            ExtentReportManager.logPass("Category "+category+" is selected in "+selectCategory.toString());

        }catch (Exception e){
            ExtentReportManager.logFail("Can not find the locator "+selectCategory.toString());
        }

    }

    public <T> T clickOnSearchButton(){
        try{
            clickOnSearch.click();
            ExtentReportManager.logPass("Click on "+clickOnSearch.toString());
        }catch (Exception e){
            ExtentReportManager.logFail("Can not find the locator "+clickOnSearch.toString());
        }

        if(categoryName.equalsIgnoreCase(" Cell Phones & Accessories")){
            return (T) PageFactory.initElements(driver, MobileResultPage.class);
        } else if (categoryName.equalsIgnoreCase(" Clothing, Shoes & Accessories")) {
            return (T) PageFactory.initElements(driver, DressResultPage.class);
        }
        return null;
    }

}