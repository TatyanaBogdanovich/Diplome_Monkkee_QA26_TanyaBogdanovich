package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EditEntryTest extends BaseTest {

    public static String LINK_ENTRY = "https://m.realt.by/news/article/40463/";
    public static String DISPLAY_TEXT = "Ссылка. ";

    @Test(groups = {"userLogin", "smoke"}, description = "Редактировать запись")
    public void editEntryTest() {
        dashboardPage.isDashboardDisplayed();
        String firstText = dashboardPage.getCheckEntryText();
        dashboardPage.findFirstEntry();
        dashboardPage.clickEditEntry();
        entriesPage.clickEditEntryTable();
        entriesPage.clickExpandToolbarButton();
        entriesPage.clickArticleLinkButton();
        entriesPage.setAddNameLinkInput(DISPLAY_TEXT);
        entriesPage.setArticleLinkInput(LINK_ENTRY);
        entriesPage.clickOkLinkButton();
        entriesPage.clickHomeButton();
        Assert.assertEquals(dashboardPage.getCheckEntryText(), DISPLAY_TEXT + firstText);
    }
}