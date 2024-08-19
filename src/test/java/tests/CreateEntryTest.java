package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class CreateEntryTest extends BaseTest {

    @Test(groups = "smoke", description = "Создать запись + добавить картинку по ссылке")
    public void createEntryImageUrlTest() {
        loginPage.login(PropertyReader.getProperty("login"), PropertyReader.getProperty("password"));
        dashboardPage.isDashboardDisplayed();
        dashboardPage.clickCreateEntryButton();
        String enterTextInput = ENTER_TEXT_INPUT;
        entriesPage.setEnterTextInput(enterTextInput);
        entriesPage.clickImageButton();
        entriesPage.setUrlImage(URL_IMAGE);
        entriesPage.clickUploadButton();
        entriesPage.clickHomeButton();
        Assert.assertEquals(dashboardPage.getCheckEntry(), enterTextInput);
    }

    @Test(groups = "regression", description = "Создать запись + добавить картинку из файла")
    public void createEntryImageFileTest() throws InterruptedException {
        loginPage.login(PropertyReader.getProperty("login"), PropertyReader.getProperty("password"));
        dashboardPage.isDashboardDisplayed();
        dashboardPage.clickCreateEntryButton();
        String enterTextInput = ENTER_TEXT_INPUT;
        entriesPage.setEnterTextInput(enterTextInput);
        entriesPage.clickImageButton();
        entriesPage.setSelectFile(PATH_IMAGE);
        entriesPage.clickUploadButton();
        entriesPage.clickHomeButton();
        Assert.assertEquals(dashboardPage.getCheckEntry(), enterTextInput);
    }

    @Test(groups = "negative", description = "Негативный тест добавить файл в формате PDF (не поддерживаемый)")
    public void negativeCreateEntryTest() throws InterruptedException {
        loginPage.login(PropertyReader.getProperty("login"), PropertyReader.getProperty("password"));
        dashboardPage.isDashboardDisplayed();
        dashboardPage.clickCreateEntryButton();
        String enterTextInput = ENTER_TEXT_INPUT;
        entriesPage.setEnterTextInput(enterTextInput);
        entriesPage.clickImageButton();
        entriesPage.setSelectFile(PATH_PDF);
        entriesPage.clickUploadButton();
        Assert.assertEquals(entriesPage.getAlertText(), "Image source URL is missing.");
        entriesPage.acceptAlert();
    }
}
