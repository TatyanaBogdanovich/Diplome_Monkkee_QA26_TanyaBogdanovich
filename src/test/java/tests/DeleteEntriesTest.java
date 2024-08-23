package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteEntriesTest extends BaseTest {

    @Test(groups = {"userLogin", "smoke"}, description = "Удалить запись")
    public void deleteEntryTest() {
        dashboardPage.isDashboardDisplayed();
        Integer countALL = dashboardPage.getCountAllEntries();
        dashboardPage.findFirstEntry();
        dashboardPage.clickEditEntry();
        entriesPage.clickDeleteButton();
        entriesPage.acceptAlert();
        Integer countAfterDelete = dashboardPage.getCountAllEntries();
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
        Assert.assertEquals((countALL -1), countAfterDelete);
    }
}