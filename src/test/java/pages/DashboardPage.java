package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    public static final By ITEM_CONTAINER = By.className("ng-scope");
    public static final By SETTINGS_BUTTON = By.className("user-menu__btn");
    public static final By CREATE_ENTRY_BUTTON = By.id("create-entry");
    public static final By CHECK_ENTRY = By.xpath("//div[@class = ' body']");
    public static final By FIRST_ENTRY = By.cssSelector("a.entry div.body");
    public static final By FILTER_INPUT = By.id("datepicker");
    public static final String SELECT_DATE = "//td[text()='%s']";
    public static final By ENTRIES_ON_DATE = By.xpath("//span[@class ='ng-binding search-parameter']");
    public static final By RESET_BUTTON = By.id("reset-search");
    public static final By COUNT_ALL_ENTRY = By.xpath("//div[@class= 'entry-container clearfix ng-scope']");
    public static final By SEARCH_INPUT = By.id("appendedInputButton");
    public static final By SEARCH_BUTTON = By.xpath("//button[@title='Search']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public boolean isDashboardDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ITEM_CONTAINER));
        return driver.findElement(ITEM_CONTAINER).isDisplayed();
    }

    @Step("Нажать на инпут поля Поиск ")
    public void clickSearchInput() {
        driver.findElement(SEARCH_INPUT).click();
    }

    @Step("Нажать кнопку Поиск")
    public void clickSearchButton() {
        driver.findElement(SEARCH_BUTTON).click();
    }

    @Step("Нажать кнопку Settings")
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

    @Step("Проверить текста в записи")
    public String getCheckEntryText() {
        return driver.findElement(CHECK_ENTRY).getText();
    }

    @Step("Проверка поиска записей по тексту")
    public boolean getCheckSearchEntry() {
     return driver.findElement(CHECK_ENTRY).isDisplayed();
    }

    @Step("Найти первую запись из списка")
    public DashboardPage findFirstEntry() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_BUTTON));
        driver.findElement(FIRST_ENTRY).isDisplayed();
        return this;
    }

    @Step("Нажать на инпут календаря")
    public DashboardPage clickSelectDate() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_BUTTON));
        driver.findElement(FILTER_INPUT).click();
        return this;
    }

    @Step("Проверка ввода не валидного формат даты")
    public DashboardPage setDateValue(String dateValue) {
        driver.findElement(FILTER_INPUT).sendKeys(dateValue);
        return this;
    }

    @Step("Календарь")
    public void clickSelectDayInCalendar(String calendar) {
        driver.findElement(By.xpath(String.format(SELECT_DATE, calendar))).click();

    }

    @Step("Проверка установки фильтра")
    public boolean isEntriesDateDisplayed() {
        try {
            driver.findElement(ENTRIES_ON_DATE).isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
        return true;
    }

    @Step("Сбросить фильтр по дате")
    public void clickResetFilter() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(RESET_BUTTON));
        driver.findElement(RESET_BUTTON).click();
    }

    @Step("Фильтр не установлен")
    public boolean isResetButtonVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ITEM_CONTAINER));
        return driver.findElement(RESET_BUTTON).isDisplayed();
    }

    @Step("Количество всех записей")
    public Integer getCountAllEntries() {
        return driver.findElements(COUNT_ALL_ENTRY).size();
    }

    @Step("Ввести текст в поле Поиск")
    public void setTextSearchEntry(String enterTextSearch) {
        driver.findElement(SEARCH_INPUT).sendKeys(enterTextSearch);
    }
}