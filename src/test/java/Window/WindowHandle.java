package Window;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandle {

    @Test
    public void openInNewTabbedWindow() {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Windows.html");
        driver.findElement(By.xpath("//a[text()='Open New Tabbed Windows ']"));
        System.out.println(driver.getTitle());
        String parentWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//button[text()='    click   ']")).click();
        System.out.println(driver.getTitle());
        Set<String> windowHandles = driver.getWindowHandles();
        for (String window : windowHandles) {
            if (!window.equalsIgnoreCase(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        System.out.println(driver.getTitle());
        driver.switchTo().window(parentWindow);
        System.out.println(driver.getTitle());
    }

    @Test
    public void openNewSeperateWindow() {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Windows.html");
        driver.findElement(By.xpath("//a[text()='Open New Seperate Windows']")).click();
        System.out.println(driver.getTitle());
        String parentWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//button[text()='click']")).click();
        System.out.println(driver.getTitle());
        Set<String> windowHandles = driver.getWindowHandles();
        for (String window : windowHandles) {
            if (!window.equalsIgnoreCase(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        System.out.println(driver.getTitle());
        driver.switchTo().window(parentWindow);
        System.out.println(driver.getTitle());


    }


}