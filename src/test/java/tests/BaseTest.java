package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import utils.DriverFactory;
import utils.InvokedListener;
import utils.TestListener;

import java.time.Duration;

@Listeners({TestListener.class, InvokedListener.class})
public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected SettingsPage settingsPage;
    protected EntriesPage entriesPage;

    public static String ENTER_TEXT_INPUT = "Редкие фото. Как выглядела улица Карла Маркса в 30-х годах.";
    public static String URL_IMAGE = "https://realt.by/uploads/pics/a1_a6f9cd.jpg";
    public static String PATH_IMAGE = System.getProperty("user.dir") + "\\src\\test\\resources\\minsk.jpg";
    public static String PATH_PDF = System.getProperty("user.dir") + "\\src\\test\\resources\\Приложение к выписке.pdf";
    public static String LINK_ENTRY = "https://m.realt.by/news/article/40463/";
    public static String DISPLAY_TEXT = "Ссылка на статью на сайте. ";
    public static String DATE_VALUE = "16/15/2024";
    public static String CHECK_DATE = "16 Aug. 2024";

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browserName"})
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) throws Exception {
        driver = DriverFactory.getDriver(browser);
        testContext.setAttribute("driver", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://monkkee.com/app/#/");
        this.loginPage = new LoginPage(driver);
        this.dashboardPage = new DashboardPage(driver);
        this.settingsPage = new SettingsPage(driver);
        this.entriesPage = new EntriesPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}








