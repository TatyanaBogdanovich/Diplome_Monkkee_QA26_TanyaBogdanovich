package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {

    private static final By EMAIL_INPUT = By.id("login");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.xpath("//button//div");
    private static final By ERROR_MESSAGE = By.xpath("//div[normalize-space(text()) = 'Mandatory field']");
    private static final By ERROR_LOGIN = By.xpath("//div[@class='alert alert-danger']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Заполнить поле User")
    public void setEmailValue(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    @Step("Заполнить поле Password")
    public void setPasswordValue(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    @Step("Нажать на кнопку Login")
    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Сообщение об ошибке")
    public void isDisplayMessageError() {
        driver.findElement(ERROR_MESSAGE).isDisplayed();
    }

    @Step("Сообщение об ошибке")
    public void isDisplayLoginMessageError() {
        driver.findElement(ERROR_LOGIN).isDisplayed();
    }

    @Step("Сообщение об ошибке")
    public String getErrorText() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Сообщение об ошибке, при невалидном логине или пароле")
    public String getErrorLoginText() {
        return driver.findElement(ERROR_LOGIN).getText();
    }

    @Step("Ввести валидные логин и пароль")
    public void login(String email, String password) {
        log.info("Login {} , {}", email, password);
        setEmailValue(email);
        setPasswordValue(password);
        clickLoginButton();
    }

    @Step("Логин и пароль для теста на смену пароля")
    public void changeLogin(String changeLogin, String changePassword) {
        log.debug("changeLogin {} , {}", changeLogin, changePassword);
        setEmailValue(changeLogin);
        setPasswordValue(changePassword);
        clickLoginButton();
    }
}