package lesson07.f_customized_waits;

import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected static WebDriver driver;

    CustomizedWaits customizedWaits = new CustomizedWaits(driver);

    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            System.out.println(String
                    .format("Test '%s' - PASSED", description.getMethodName()));
            super.succeeded(description);
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println(String
                    .format("Test '%s' - FAILED due to: %s",
                            description.getMethodName(),
                            e.getMessage()));
            super.failed(e, description);
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            System.out.println(String
                    .format("Test '%s' - SKIPPED", description.getMethodName()));
            super.skipped(e, description);
        }

        @Override
        protected void starting(Description description) {
            System.out.println(String
                    .format("Test '%s' - is starting...", description.getMethodName()));
            super.starting(description);
        }
    };

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id='header']//a[@class='login']")).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn("kateryna.puzyrna@gmail.com","12345");
    }

    @Before
    public void mainPage() {
        driver.get("http://automationpractice.com/index.php?controller=my-account");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}