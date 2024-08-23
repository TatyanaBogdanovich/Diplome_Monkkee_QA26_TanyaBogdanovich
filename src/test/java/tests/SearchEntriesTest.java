package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchEntriesTest extends BaseTest {

    @Test(groups = {"userLogin", "smoke"}, description = "Создать запись + добавить картинку из файла")
    public void searchEntriesTest() {
        String enterTextSearch = "Редкие фото.";
        dashboardPage.isDashboardDisplayed();
        dashboardPage.clickSearchInput();
        dashboardPage.setTextSearchEntry(enterTextSearch);
        dashboardPage.clickSearchButton();
        dashboardPage.getEntriesDate();
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
        Assert.assertEquals(dashboardPage.getCheckEntry(), enterTextSearch);
    }
}