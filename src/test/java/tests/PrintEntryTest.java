package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrintEntryTest extends BaseTest {

    @Test(groups = {"userLogin", "regression"}, description = "Печать записи")
    public void printEntryTest() {
        String mainWindowHandle = driver.getWindowHandle();
        dashboardPage.isDashboardDisplayed();
        dashboardPage.findFirstEntry();
        dashboardPage.clickEditEntry();
        entriesPage.clickPrintButton();
        String mainDateEntry = entriesPage.getDateEntryMainWindowText();
        String mainTextEntry = entriesPage.getEntryMainWindowText();
        Assert.assertTrue(printEntryPage.verifyWindowPrint());
        Assert.assertEquals(printEntryPage.getDateEntryText(),mainDateEntry);
        Assert.assertEquals(printEntryPage.getEntryText(),mainTextEntry);
        Assert.assertEquals(printEntryPage.closeWindowPrint(mainWindowHandle),mainWindowHandle);
    }
}