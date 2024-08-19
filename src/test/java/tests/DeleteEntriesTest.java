package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class DeleteEntriesTest extends BaseTest {

    @Test(groups = "smoke", description = "Удалить запись")
    public void deleteEntryTest() {

        loginPage.login(PropertyReader.getProperty("login"), PropertyReader.getProperty("password"));
        dashboardPage.isDashboardDisplayed();
        dashboardPage.clickCreateEntryButton();
        entriesPage.setEnterTextInput(ENTER_TEXT_INPUT);
        entriesPage.clickDeleteButton();
        entriesPage.acceptAlert();
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
    }
}
