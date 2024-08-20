package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class EntriesPage extends BasePage {

    public static final By ENTER_TEXT_INPUT = By.id("editable");
    public static final By HOME_BUTTON = By.id("back-to-overview");
    public static final By DELETE_BUTTON = By.id("delete-entry");
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
    public EntriesPage setEnterTextInput(String enterTextInput) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_IMAGE_BUTTON));
        driver.findElement(ENTER_TEXT_INPUT).sendKeys(enterTextInput);
        return this;
    }

    @Step("Нажать кнопку HOME")
    public EntriesPage clickHomeButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(HOME_BUTTON));
        driver.findElement(HOME_BUTTON).click();
        return this;
    }

    @Step("Редактировать текст записи")
    public EntriesPage clickEditEntryTable() {
        driver.findElement(ENTER_TEXT_INPUT).click();
        return this;
    }

    @Step("Нажать кнопку Image")
    public EntriesPage clickImageButton() {
        driver.findElement(ADD_IMAGE_BUTTON).click();
        return this;
    }

    @Step("Ввести ссылку  картинки")
    public EntriesPage setUrlImage(String urlImage) {
        driver.findElement(URL_IMAGE).sendKeys(urlImage);
        return this;
    }

    @Step("Выбрать картинку из файла")
    public EntriesPage setSelectFile(String pathImage) {
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe")));
        driver.findElement(SELECT_FILE_BUTTON).sendKeys(pathImage);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.switchTo().defaultContent();
        return this;
    }

    @Step("Нажать кнопку OK")
    public EntriesPage clickUploadButton() {
        driver.findElement(UPLOAD_BUTTON_OK).click();
        return this;
    }

    @Step("Нажать кнопку развернуть панель инструментов")
    public EntriesPage clickExpandToolbarButton() {
        driver.findElement(EXPAND_TOOLBAR_BUTTON).click();
        return this;
    }

    @Step("Нажать кнопку Ссылка")
    public EntriesPage clickArticleLinkButton() {
        driver.findElement(ARTICLE_LINK_BUTTON).click();
        return this;
    }

    @Step("Ввести название ссылки")
    public EntriesPage setAddNameLinkInput(String displayText) {
        driver.findElement(DISPLAY_TEXT_INPUT).sendKeys(displayText);
        return this;
    }

    @Step("Ввести  ссылку на статью")
    public EntriesPage setArticleLinkInput(String linkEntry) {
        driver.findElement(URL_ARTICLE_INPUT).sendKeys(linkEntry);
        return this;
    }

    @Step("Нажать кнопку OK")
    public EntriesPage clickOkLinkButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(OK_LINK_BUTTON).click();
        return this;
    }

    @Step("Нажать кнопку Удалить")
    public EntriesPage clickDeleteButton() {
        driver.findElement(DELETE_BUTTON).click();
        return this;
    }
}