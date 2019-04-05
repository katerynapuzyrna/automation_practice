package lesson10.d_purchase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.AssumptionViolatedException;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utils.EventHandler;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected static WebDriver driver;

    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);

    Waiters waiters = new Waiters(driver);
    LoginPage loginPage = new LoginPage(driver, waiters);
    SearchPage searchPage = new SearchPage(driver, waiters);
    CartPage cartPage = new CartPage(driver, waiters);
    OrderPage orderPage = new OrderPage(driver,waiters);

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            LOGGER.info(String
                    .format("Test '%s' - PASSED", description.getMethodName()));
            super.succeeded(description);
        }

        @Override
        protected void failed(Throwable e, Description description) {
            LOGGER.info(String
                    .format("Test '%s' - FAILED due to: %s",
                            description.getMethodName(),
                            e.getMessage()));
            super.failed(e, description);
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            LOGGER.info(String
                    .format("Test '%s' - SKIPPED", description.getMethodName()));
            super.skipped(e, description);
        }

        @Override
        protected void starting(Description description) {
            LOGGER.info(String
                    .format("Test '%s' - is starting...", description.getMethodName()));
            super.starting(description);
        }
    };

    @BeforeClass
    public static void setUp() {
        EventFiringWebDriver wd = new EventFiringWebDriver(new ChromeDriver());
        wd.register(new EventHandler());

        driver = wd;
        LOGGER.debug("WebDriver has been started");
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
        LOGGER.debug("WebDriver has been shut down");
    }
}