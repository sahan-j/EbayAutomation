package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.DressResultPage;
import pages.EbayHomePage;
import pages.MobileResultPage;
import util.ExtentReportManager;

public class EbayTest extends BaseTest{
    @Test
    public void searchMobilePhoneTest(){
//        ExtentReportManager.createTest(Thread.currentThread().getStackTrace()[2].getMethodName());
        ExtentReportManager.createTest("searchMobilePhoneTest");
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        EbayHomePage ebayHomePage = basePage.initApp();
        ebayHomePage.fillSearchField("Iphone");
        ebayHomePage.selectCategoryFromDD(" Cell Phones & Accessories");
        MobileResultPage mobileResultPage = ebayHomePage.clickOnSearchButton();
        mobileResultPage.clickOnAppleCheckBox();
    }

    @Test
    public void searchDressTest(){
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        EbayHomePage ebayHomePage = basePage.initApp();
        ebayHomePage.fillSearchField("frock");
        ebayHomePage.selectCategoryFromDD(" Clothing, Shoes & Accessories");
        DressResultPage dressResultPage = ebayHomePage.clickOnSearchButton();
        dressResultPage.clickOnIndiaCheckBox();
    }
}
