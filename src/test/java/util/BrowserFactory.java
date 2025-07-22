package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BrowserFactory {
    private static BrowserFactory browserFactory;

    private  BrowserFactory(){

    }

    public static BrowserFactory getBrowserFactory(){
        if(browserFactory == null){
            browserFactory = new BrowserFactory();
        }
        return browserFactory;
    }

    ThreadLocal<WebDriver> tlDriver = ThreadLocal.withInitial(()->{
        String browser = "chrome";
        WebDriver driver = switch (browser){
            case "chrome"-> WebDriverManager.chromedriver().create();
            case "firefox"->WebDriverManager.firefoxdriver().create();
            default -> throw new RuntimeException("Unsupported browser !");
        };
        driver.manage().window().maximize();
        return driver;
    });

    public WebDriver getWebDriver(){
        return tlDriver.get();
    }

    public void quitDriver(){
        if(getWebDriver()!=null){
            getWebDriver().quit();
            tlDriver.remove();
        }
    }
}
