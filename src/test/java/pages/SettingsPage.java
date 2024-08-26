package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SettingsPage extends BasePage {

    public static final By LIST_SETTINGS = By.id("settings-menu");
    public static final By PASSWORD_BUTTON = By.xpath("//a[@href='#/settings/password']");
    public static final By PASSWORD_DESCRIPTION = By.xpath("//p[@class='ng-binding']");
    public static final By OLD_PASSWORD = By.xpath("//*[@id='old-password']");
    public static final By NEW_PASSWORD = By.xpath("//*[@id='password']");
    public static final By REPEAT_PASSWORD = By.xpath("//*[@id='password-confirmation']");
    public static final By HINT_PASSWORD = By.xpath("//*[@id='password-hint']");
    public static final By SAVE_BUTTON = By.xpath("//button[@class='btn btn-default']");
    public static final By SUCCESS_MASSAGE = By.xpath(" //div[@class='alert alert-success']");
    public static final By LOGOUT_BUTTON = By.xpath("//span[text() ='Logout']");

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть страницу настроек")
    public SettingsPage isOpenSettingsPage() {
        driver.findElement(LIST_SETTINGS).isDisplayed();
        return this;
    }

    @Step("Выбрать раздел меню Пароль")
    public SettingsPage clickPasswordButton() {
        driver.findElement(PASSWORD_BUTTON).click();
        return this;
    }

    @Step("Описание раздела Пароль")
    public SettingsPage isPasswordDescription() {
        driver.findElement(PASSWORD_DESCRIPTION).getText();
        return this;
    }

    @Step("Ввести старый пароль")
    public SettingsPage setOldPasswordValue(String oldPassword) {
        driver.findElement(OLD_PASSWORD).sendKeys(oldPassword);
        return this;
    }

    @Step("Ввести новый пароль")
    public SettingsPage setNewPasswordValue(String newPassword) {
        driver.findElement(NEW_PASSWORD).sendKeys(newPassword);
        return this;
    }

    @Step("Повторить новый пароль")
    public SettingsPage setRepeatPasswordValue(String repeatPassword) {
        driver.findElement(REPEAT_PASSWORD).sendKeys(repeatPassword);
        return this;
    }

    @Step("Ввести подсказку к паролю")
    public SettingsPage setHintPasswordValue(String hintPassword) {
        driver.findElement(HINT_PASSWORD).sendKeys(hintPassword);
        return this;
    }

    @Step("Нажать кнопку Ок")
    public SettingsPage clickSaveButton() {
        driver.findElement(SAVE_BUTTON).click();
        return this;
    }

    @Step("Изменить пароль")
    public SettingsPage changePassword(String oldPassword, String newPassword, String repeatPassword, String hintPassword) {
        setOldPasswordValue(oldPassword);
        setNewPasswordValue(newPassword);
        setRepeatPasswordValue(repeatPassword);
        setHintPasswordValue(hintPassword);
        clickSaveButton();
        return this;
    }

    @Step("Сообщение об успешном изменении пароля")
    public boolean isSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_MASSAGE));
        return driver.findElement(SUCCESS_MASSAGE).isDisplayed();
    }

    @Step("Нажать кнопку Logout")
    public void clickLogoutButton() {
        try {
            driver.findElement(LOGOUT_BUTTON).click();
        } catch (Exception exception) {
            try {
                driver.findElement(LOGOUT_BUTTON).click();
            } catch (Exception exception1) {
            }
        }
    }
}