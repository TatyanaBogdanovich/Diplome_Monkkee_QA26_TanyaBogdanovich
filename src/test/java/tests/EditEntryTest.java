package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class EditEntryTest extends BaseTest {

    @Test(groups = "negative", description = "Редактировать запись")
    public void editEntryTest() {

        loginPage.login(PropertyReader.getProperty("login"), PropertyReader.getProperty("password"));
        dashboardPage.isDashboardDisplayed();
        String firstText = dashboardPage.getCheckEntry();
        dashboardPage.findFirstEntry();
        dashboardPage.clickEditEntry();
        entriesPage.clickEditEntryTable();
        entriesPage.clickExpandToolbarButton();
        entriesPage.clickArticleLinkButton();
        entriesPage.setAddNameLinkInput(DISPLAY_TEXT);
        entriesPage.setArticleLinkInput(LINK_ENTRY);
        entriesPage.clickOkLinkButton();
        entriesPage.clickHomeButton();
        Assert.assertEquals(dashboardPage.getCheckEntry(), DISPLAY_TEXT + firstText);
    }
}


