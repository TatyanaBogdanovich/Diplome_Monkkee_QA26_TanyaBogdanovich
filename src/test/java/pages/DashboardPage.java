package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    public static final By ITEM_CONTAINER = By.className("ng-scope");
    public static final By SETTINGS_BUTTON = By.className("user-menu__btn");
    public static final By LOGOUT_BUTTON = By.xpath("//button[@class = 'user-menu__btn']");
    public static final By CREATE_ENTRY_BUTTON = By.id("create-entry");
    public static final By CHECK_ENTRY = By.xpath("//div[@class = ' body']");
    public static final By EDIT_ENTRY = By.cssSelector("a.entry div.body");
    public static final By FIRST_ENTRY = By.cssSelector("a.entry div.body");
    public static final By SELECT_DATE = By.id("datepicker");
    public static final By SELECT_DAY = By.xpath("//div[1]/table/tbody/tr[3]/td[5]");
    public static final By ENTRIES_ON_DATE = By.xpath("//span[@class ='ng-binding search-parameter']");
    public static final By RESET_BUTTON = By.id("reset-search");


    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_BUTTON));
        return driver.findElement(ITEM_CONTAINER).isDisplayed();
    }

    public SettingsPage clickSettingsButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_BUTTON));
        driver.findElement(SETTINGS_BUTTON).click();
        return new SettingsPage(driver);
    }

    public LoginPage clickLogoutButton() {
        driver.findElement(LOGOUT_BUTTON).click();
        return new LoginPage(driver);
    }

    @Step("Нажать кнопку создать запись")
    public void clickCreateEntryButton() {
        driver.findElement(CREATE_ENTRY_BUTTON).click();
    }

    @Step("Редактировать запись")
    public void clickEditEntry() {
        driver.findElement(EDIT_ENTRY).click();
    }

    @Step("Проверить, что ссылка добавлена в запись")
    public String getCheckEntry() {
        return driver.findElement(CHECK_ENTRY).getText();
    }


    @Step("Выбор первой записи из списка")
    public void findFirstEntry() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_BUTTON));
        driver.findElement(FIRST_ENTRY).isDisplayed();
    }

    @Step("Нажать на инпут календаря")
    public void clickSelectDate() throws InterruptedException {
        driver.findElement(SELECT_DATE).click();
        Thread.sleep(3000);
    }

    @Step("Ввести в поле календаря значение 16/15/2024")
    public void setDateValue(String dateValue) {
        driver.findElement(SELECT_DATE).sendKeys(dateValue);
    }

    @Step("Выбрать дату из календаря")
    public void clickSelectDay() {
        driver.findElement(SELECT_DAY).click();
    }

    @Step("Проверить, что записи от 16 Aug. 2024")
    public void getEntriesDate(String checkDate) {
        driver.findElement(ENTRIES_ON_DATE).getText();
    }

    @Step("Сбросить фильтр по дате")
    public void clickResetFilter() {
        driver.findElement(RESET_BUTTON).click();
    }
}

