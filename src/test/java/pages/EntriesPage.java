package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static tests.BaseTest.DISPLAY_TEXT;

public class EntriesPage extends BasePage {

    public static final By ENTER_TEXT_INPUT = By.id("editable");
    public static final By HOME_BUTTON = By.id("back-to-overview");
    public static final By DELETE_BUTTON = By.id("delete-entry");
    public static final By EDIT_TABLE = By.id("editable");
    public static final By ADD_IMAGE_BUTTON = By.xpath("//a[contains(@class, 'button__image')]");
    public static final By SELECT_FILE_BUTTON = By.xpath("//input[@name='txtUpload']");
    public static final By URL_IMAGE = By.xpath("//input[contains(@class,'dialog_ui_input_text')]");
    public static final By UPLOAD_BUTTON_OK = By.xpath("//a[@title = 'OK']");
    public static final By EXPAND_TOOLBAR_BUTTON = By.xpath("//a[@title='Expand toolbar']");
    public static final By ARTICLE_LINK_BUTTON = By.xpath("//a[@title ='Link (Ctrl+K)']");
    public static final By DISPLAY_TEXT_INPUT = By.xpath("//label[text()='Display Text']/following-sibling::div//input");
    public static final By URL_ARTICLE_INPUT = By.xpath("//label[text()='URL']/following-sibling::div//input");
    public static final By OK_LINK_BUTTON = By.xpath("//a[@title ='OK']");

    public EntriesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввести текст в таблицу")
    public void setEnterTextInput(String enterTextInput) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_IMAGE_BUTTON));
        driver.findElement(ENTER_TEXT_INPUT).sendKeys(enterTextInput);
    }

    @Step("Нажать кнопку HOME")
    public void clickHomeButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_IMAGE_BUTTON));
        driver.findElement(HOME_BUTTON).click();
    }

    @Step("Редактировать текст записи")
    public void clickEditEntryTable() {
        driver.findElement(EDIT_TABLE).click();
    }

    @Step("Нажать кнопку Image")
    public void clickImageButton() {
        driver.findElement(ADD_IMAGE_BUTTON).click();
    }

    @Step("Ввести ссылку  картинки")
    public void setUrlImage(String urlImage) {
        driver.findElement(URL_IMAGE).sendKeys(urlImage);
    }

    @Step("Выбрать картинку из файла")
    public void setSelectFile(String pathImage) throws InterruptedException {
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe")));
        driver.findElement(SELECT_FILE_BUTTON).sendKeys(pathImage);
        Thread.sleep(3000); // решения для загрузки пути картинки
        driver.switchTo().defaultContent(); //возвращает обратно
        // Временное решение, которое должно быть заменено , на появленеие текста в поле URL
        Thread.sleep(3000);
    }

    @Step("Нажать кнопку OK")
    public void clickUploadButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(URL_IMAGE));
        driver.findElement(UPLOAD_BUTTON_OK).click();

    }

    @Step("Нажать кнопку развернуть панель инструментов")
    public void clickExpandToolbarButton() {
        driver.findElement(EXPAND_TOOLBAR_BUTTON).click();
    }

    @Step("Нажать кнопку Ссылка")
    public void clickArticleLinkButton() {
        driver.findElement(ARTICLE_LINK_BUTTON).click();
    }

    @Step("Ввести название ссылки")
    public void setAddNameLinkInput(String displayText) {
        driver.findElement(DISPLAY_TEXT_INPUT).sendKeys(displayText);
    }

    @Step("Ввести  ссылку на статью")
    public void setArticleLinkInput(String linkEntry) {
        driver.findElement(URL_ARTICLE_INPUT).sendKeys(linkEntry);
    }

    @Step("Нажать кнопку OK")
    public void clickOkLinkButton() {
        driver.findElement(OK_LINK_BUTTON).click();
    }

    @Step("Нажать кнопку Удалить")
    public void clickDeleteButton() {
        driver.findElement(DELETE_BUTTON).click();
    }
}

