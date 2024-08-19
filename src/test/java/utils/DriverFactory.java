package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class DriverFactory {
    public static WebDriver getDriver(String browserName) throws Exception {
        WebDriver driver;
        switch (browserName) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                //options.addArguments("--headless");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-infobars");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
                break;
            case "edge":
                EdgeOptions options1 = new EdgeOptions();
                //options1.addArguments("--headless");
                options1.addArguments("--disable-extensions");
                options1.addArguments("--disable-infobars");
                options1.addArguments("--disable-popup-blocking");
                options1.addArguments("--disable-notifications");
                driver = new EdgeDriver(options1);
                break;
            default:
                throw new Exception("Unsupported browser");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}
