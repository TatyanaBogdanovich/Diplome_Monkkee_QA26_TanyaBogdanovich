package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PrintEntryTest extends BaseTest {

    @Test(groups = {"userLogin", "regression"}, description = "Печать записи")
    public void printEntryTest() {
        String mainWindowHandle = driver.getWindowHandle();
        dashboardPage.isDashboardDisplayed();
        dashboardPage.findFirstEntry();
        dashboardPage.clickEditEntry();
        dashboardPage.getCheckEntry();
        entriesPage.clickPrintButton();
        String  mainDateEntry = driver.findElement(By.xpath("//time[@class = 'ng-binding']")).getText();
        String  mainTextEntry = driver.findElement(By.xpath("//p[normalize-space()][1]")).getText();
        Assert.assertTrue(newWindowPage.verifyWindowPrint());
        Assert.assertEquals(newWindowPage.isDateEntryDisplayed(),mainDateEntry);
        Assert.assertEquals(newWindowPage.isTextEntryDisplayed(),mainTextEntry);
        Assert.assertEquals(newWindowPage.closeWindowPrint(mainWindowHandle),mainWindowHandle);
    }
}