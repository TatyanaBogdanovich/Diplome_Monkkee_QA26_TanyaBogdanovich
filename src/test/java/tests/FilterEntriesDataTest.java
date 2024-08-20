package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class FilterEntriesDataTest extends BaseTest {

    public static String DATE_VALUE = "16/15/2024";

    @Test(groups = "regression", description = "Установить фильтр записей по дате")
    public void positiveFilterDateTest() {
        loginPage.login(PropertyReader.getProperty("login"), PropertyReader.getProperty("password"));
        dashboardPage.isDashboardDisplayed();
        dashboardPage.clickSelectDate()
                .clickSelectDay()
                .getEntriesDate()
                .clickResetFilter();
                Assert.assertTrue(dashboardPage.isDashboardDisplayed());
    }

    @Test(groups = "negative", description = "Установить невалидную дату в фильтр")
    public void negativeFilterDateTest() {
        loginPage.login(PropertyReader.getProperty("login"), PropertyReader.getProperty("password"));
        dashboardPage.isDashboardDisplayed();
        dashboardPage.clickSelectDate()
                .setDateValue(DATE_VALUE);
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
    }
}