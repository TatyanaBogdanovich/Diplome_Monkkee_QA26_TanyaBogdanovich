package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class ChangePasswordTest extends BaseTest {

    @Test(groups = "regression", description = "Смена пароля")
    public void changePasswordTest() {

        loginPage.changeLogin(PropertyReader.getProperty("changeLogin"), PropertyReader.getProperty("changePassword"));
        dashboardPage.isDashboardDisplayed();
        dashboardPage.clickSettingsButton()
                .isOpenSettingsPage()
                .clickPasswordButton()
                .isPasswordDescription()
                .changePassword(PropertyReader.getProperty("oldPassword"), PropertyReader.getProperty("newPassword"), PropertyReader.getProperty("repeatPassword"), PropertyReader.getProperty("hintPassword"))
                .isSuccessMessage();
        dashboardPage.clickLogoutButton()
                .changeLogin(PropertyReader.getProperty("changeLogin"), PropertyReader.getProperty("newPassword"));
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
    }

    @AfterMethod(alwaysRun = true)
    public void setOldPassword() {

        dashboardPage.clickSettingsButton()
                .isOpenSettingsPage()
                .clickPasswordButton()
                .isPasswordDescription()
                .changePassword(PropertyReader.getProperty("newPassword"), PropertyReader.getProperty("oldPassword"), PropertyReader.getProperty("oldPassword"), PropertyReader.getProperty("hintPassword"));
        Assert.assertTrue(settingsPage.isSuccessMessage());
    }
}
