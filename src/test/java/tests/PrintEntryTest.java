package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrintEntryTest extends BaseTest {

    @Test(groups = {"userLogin", "regression"}, description = "Печать записи")
    public void printEntryTest() {
        dashboardPage.isDashboardDisplayed();
        dashboardPage.findFirstEntry();
        dashboardPage.clickEditEntry();
        entriesPage.clickPrintButton();
        Assert.assertTrue(entriesPage.verifyWindowPrint());
    }
}