package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class DashboardPage extends BasePage {

    public static final By ITEM_CONTAINER = By.className("ng-scope");
    public static final By SETTINGS_BUTTON = By.className("user-menu__btn");
    public static final By CREATE_ENTRY_BUTTON = By.id("create-entry");
    public static final By CHECK_ENTRY = By.xpath("//div[@class = ' body']");
    public static final By FIRST_ENTRY = By.cssSelector("a.entry div.body");
    public static final By SELECT_DATE = By.id("datepicker");
    public static final By SELECT_DAY = By.xpath("//div[contains(@class, 'datepicker-days')]//tbody//td[contains(., '16')]");
    public static final By ENTRIES_ON_DATE = By.xpath("//span[@class ='ng-binding search-parameter']");
    public static final By RESET_BUTTON = By.id("reset-search");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public boolean isDashboardDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_BUTTON));
        return driver.findElement(ITEM_CONTAINER).isDisplayed();
    }

    @Step ("Нажать кнопку Settings")
    public SettingsPage clickSettingsButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_BUTTON));
        driver.findElement(SETTINGS_BUTTON).click();
        return new SettingsPage(driver);
    }

   @Step("Нажать кнопку создать запись")
    public EntriesPage clickCreateEntryButton() {
        driver.findElement(CREATE_ENTRY_BUTTON).click();
        return new EntriesPage(driver);
    }

    @Step("Редактировать запись")
    public EntriesPage clickEditEntry() {
        driver.findElement(FIRST_ENTRY).click();
        return new EntriesPage(driver);
    }

    @Step("Проверить, что ссылка добавлена в запись")
    public String getCheckEntry() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver.findElement(CHECK_ENTRY).getText();
    }

    @Step("Найти первую запись из списка")
    public DashboardPage findFirstEntry() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_BUTTON));
        driver.findElement(FIRST_ENTRY).isDisplayed();
        return this;
    }

    @Step("Нажать на инпут календаря")
    public DashboardPage clickSelectDate()  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_BUTTON));
        driver.findElement(SELECT_DATE).click();
        return this;
    }

    @Step("Проверка ввода не валидного формат даты")
    public DashboardPage setDateValue(String dateValue) {
        driver.findElement(SELECT_DATE).sendKeys(dateValue);
        return this;
    }

    @Step("Выбрать дату из календаря")
    public DashboardPage clickSelectDay() {
        driver.findElement(SELECT_DAY).click();
        return this;
    }

    @Step("Проверка отображения записей согласно установленному фильтру")
    public DashboardPage getEntriesDate() {
        driver.findElement(ENTRIES_ON_DATE).getText();
        return this;
    }

    @Step("Сбросить фильтр по дате")
    public DashboardPage clickResetFilter() {
        driver.findElement(RESET_BUTTON).click();
        return this;
    }
}