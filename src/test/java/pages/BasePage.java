package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        log.info("Webdriver is {}", driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Step("alert")
    public String getAlertText() { //возвращает текст алерта
        return driver.switchTo().alert().getText();
    }

    @Step("closeAlert")
    public void acceptAlert() {     //закрываем алерт кнопкой ОК, если алерт существует, если алерт отстув. ничего не делаем
        boolean foundAlert = false;
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
        } catch (TimeoutException ignored) {
        }
        if (foundAlert) {
            driver.switchTo().alert().accept();
        }
    }
}

