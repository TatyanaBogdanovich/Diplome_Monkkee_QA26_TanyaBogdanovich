package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class CreateEntryTest extends BaseTest {

    public static String ENTER_TEXT_INPUT = "Редкие фото. Как выглядела улица Карла Маркса в 30-х годах.";
    public static String URL_IMAGE = "https://realt.by/uploads/pics/a1_a6f9cd.jpg";
    public static String PATH_IMAGE = System.getProperty("user.dir") + "\\src\\test\\resources\\minsk.jpg";
    public static String PATH_PDF = System.getProperty("user.dir") + "\\src\\test\\resources\\Приложение к выписке.pdf";

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
    public void createEntryImageFileTest() {
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
    public void negativeCreateEntryTest() {
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