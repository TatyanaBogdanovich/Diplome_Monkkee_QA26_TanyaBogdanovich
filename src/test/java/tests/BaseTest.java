package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import utils.DriverFactory;
import utils.InvokedListener;
import utils.PropertyReader;
import utils.TestListener;

@Listeners({TestListener.class, InvokedListener.class})
public abstract class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected SettingsPage settingsPage;
    protected EntriesPage entriesPage;
    protected NewWindowPage newWindowPage;
    static Faker faker = new Faker();

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browserName"})
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) throws Exception {
        driver = DriverFactory.getDriver(browser);
        testContext.setAttribute("driver", driver);
        this.loginPage = new LoginPage(driver);
        this.dashboardPage = new DashboardPage(driver);
        this.settingsPage = new SettingsPage(driver);
        this.entriesPage = new EntriesPage(driver);
        this.newWindowPage = new NewWindowPage(driver);

        loginPage.open();
    }

    @BeforeMethod(onlyForGroups = "userLogin", alwaysRun = true)
    public void userLogin() {

        loginPage.login(PropertyReader.getProperty("login"), PropertyReader.getProperty("password"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}