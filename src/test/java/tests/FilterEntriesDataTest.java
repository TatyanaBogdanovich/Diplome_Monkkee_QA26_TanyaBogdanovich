package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterEntriesDataTest extends BaseTest {

    public static String DATE_VALUE = "16/99/2024";

    @Test(groups = {"userLogin", "smoke"}, description = "Установка и сброс фильтра по дате")
    public void positiveFilterDateTest() {
        String calendar = "16";
        dashboardPage.isDashboardDisplayed();
        dashboardPage.clickSelectDate();
        dashboardPage.clickSelectDayInCalendar(calendar);
        dashboardPage.clickResetFilter();
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
        Assert.assertFalse(dashboardPage.isResetButtonVisible());
    }

    @Test(groups = {"userLogin", "negative"}, description = "Установить невалидную дату в фильтр")
    public void negativeFilterDateTest() {
        dashboardPage.isDashboardDisplayed();
        dashboardPage.clickSelectDate()
                .setDateValue(DATE_VALUE);
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
        Assert.assertFalse(dashboardPage.isEntriesDateDisplayed());
    }
}
