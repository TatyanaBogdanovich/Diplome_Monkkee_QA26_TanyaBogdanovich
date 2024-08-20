package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class LoginTest extends BaseTest {

    @Test(groups = {"regression" , "smoke"}, description = "Успешная авторизация в приложении")
    public void positiveLoginTest() {
        loginPage.login(PropertyReader.getProperty("login"), PropertyReader.getProperty("password"));
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
    }

    @DataProvider(name = "emptyLoginTest")
    public Object[][] emptyLoginTest() {
        return new Object[][]{
                {"", "asdasd0123.", "Mandatory field"},
                {"anna007", "", "Mandatory field"}
        };
    }

    @DataProvider(name = "negativeLoginTest")
    public Object[][] negativeLoginTest() {
        return new Object[][]{
                {"anna000", "asdasd0123.", "Login failed"},
                {"anna007", "asdasd01230", "Login failed"}
        };
    }

    @Test(groups = "negative", dataProvider = "negativeLoginTest", description = "Негативные тесты на авторизацию")
    public void negativeLoginTest(String email, String password, String expectedErrorMessage) {
        loginPage.login(email, password);
        loginPage.isDisplayLoginMessageError();
        Assert.assertEquals(loginPage.getErrorLoginText(), expectedErrorMessage);
    }

    @Test(groups = "negative", dataProvider = "emptyLoginTest", description = "Негативные тесты на авторизацию")
    public void emptyLoginTest(String email, String password, String expectedErrorMessage) {
        loginPage.login(email, password);
        loginPage.isDisplayMessageError();
        Assert.assertEquals(loginPage.getErrorText(), expectedErrorMessage);
    }
}