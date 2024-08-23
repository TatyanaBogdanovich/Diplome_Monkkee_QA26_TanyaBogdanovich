package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateEntryTest extends BaseTest {

    public static String URL_IMAGE = "https://realt.by/uploads/pics/a1_a6f9cd.jpg";
    public static String PATH_IMAGE = System.getProperty("user.dir") + "\\src\\test\\resources\\minsk.jpg";
    public static String PATH_PDF = System.getProperty("user.dir") + "\\src\\test\\resources\\Приложение к выписке.pdf";

    @Test(groups = {"userLogin", "smoke"}, description = "Создать запись + добавить картинку по ссылке")
    public void createEntryImageUrlTest() {
        String enterText = faker.harryPotter().spell();
        dashboardPage.isDashboardDisplayed();
        dashboardPage.clickCreateEntryButton();
        entriesPage.setEnterTextInput(enterText);
        entriesPage.clickImageButton();
        entriesPage.setUrlImage(URL_IMAGE);
        entriesPage.clickUploadButton();
        entriesPage.clickHomeButton();
        Assert.assertEquals(dashboardPage.getCheckEntry(), enterText);
    }

    @Test(groups = {"userLogin", "regression"}, description = "Создать запись + добавить картинку из файла")
    public void createEntryImageFileTest() {
        String enterText = faker.harryPotter().spell() + faker.book().publisher();
        dashboardPage.isDashboardDisplayed();
        dashboardPage.clickCreateEntryButton();
        entriesPage.setEnterTextInput(enterText);
        entriesPage.clickImageButton();
        entriesPage.setSelectFile(PATH_IMAGE);
        entriesPage.clickUploadButton();
        entriesPage.clickHomeButton();
        Assert.assertEquals(dashboardPage.getCheckEntry(), enterText);
    }

    @Test(groups = {"userLogin", "negative"}, description = "Негативный тест добавить файл в формате PDF (не поддерживаемый)")
    public void negativeCreateEntryTest() {
        String enterText = faker.book().title();
        dashboardPage.isDashboardDisplayed();
        dashboardPage.clickCreateEntryButton();
        entriesPage.setEnterTextInput(enterText);
        entriesPage.clickImageButton();
        entriesPage.setSelectFile(PATH_PDF);
        entriesPage.clickUploadButton();
        Assert.assertEquals(entriesPage.getAlertText(), "Image source URL is missing.");
        entriesPage.acceptAlert();
    }
}