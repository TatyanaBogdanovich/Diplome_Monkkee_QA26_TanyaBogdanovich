package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchEntriesTest extends BaseTest {

    @Test(groups = {"userLogin", "smoke"}, description = "Поиск записи по тексту")
    public void searchEntriesTest() {
        String enterTextSearch = "Редкие фото.";
        dashboardPage.isDashboardDisplayed();
        dashboardPage.clickSearchInput();
        dashboardPage.setTextSearchEntry(enterTextSearch);
        dashboardPage.clickSearchButton();
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
        Assert.assertTrue(dashboardPage.getCheckSearchEntry(), enterTextSearch);
    }
}