package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class FilterEntriesDataTest extends BaseTest {

    @Test(groups = "regression", description = "Установить фильтр записей по дате")
    public void positiveFilterDateTest() throws InterruptedException {
        loginPage.login(PropertyReader.getProperty("login"), PropertyReader.getProperty("password"));
        dashboardPage.isDashboardDisplayed();
        dashboardPage.clickSelectDate();
        dashboardPage.clickSelectDay();
        dashboardPage.getEntriesDate(CHECK_DATE);
        dashboardPage.clickResetFilter();
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
    }

    @Test(groups = "negative", description = "Установить невалидную дату в фильтр")
    public void negativeFilterDateTest() throws InterruptedException {
        loginPage.login(PropertyReader.getProperty("login"), PropertyReader.getProperty("password"));
        dashboardPage.isDashboardDisplayed();
        dashboardPage.clickSelectDate();
        dashboardPage.setDateValue(DATE_VALUE);
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
    }
}