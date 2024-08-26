package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class NewWindowPage extends BasePage {

    public static final By DATE_ENTRY = By.xpath("//div[normalize-space()][3]");
    public static final By TEXT_ENTRY = By.xpath("//p[normalize-space()]");

    public NewWindowPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка отображения нового окна")
    public boolean verifyWindowPrint() {
        // Сохранение текущего окна
        String mainWindowHandle = driver.getWindowHandle();
        // Получение всех открытых окон
        Set<String> allWindowHandles;
        allWindowHandles = driver.getWindowHandles();
        // Переключение на новое окно
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        boolean isNewWindowOpen = allWindowHandles.size() == 2;
        return isNewWindowOpen;
    }

    @Step("Проверка отображения даты записи в новом окне")
    public String isDateEntryDisplayed() {
        return DATE_ENTRY.findElement(driver).getText();
    }

    @Step("Проверка отображения текста записи в новом окне")
    public String isTextEntryDisplayed() {
        return TEXT_ENTRY.findElement(driver).getText();
    }

    @Step("Закрытие нового окна")
    public String closeWindowPrint(String mainWindowHandle) {
        Set<String> windowHandles = driver.getWindowHandles();
        if (windowHandles.size() > 1) {
            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(mainWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                    driver.close();
                }
            }
        }
        driver.switchTo().window(mainWindowHandle);
        return mainWindowHandle;
    }
}