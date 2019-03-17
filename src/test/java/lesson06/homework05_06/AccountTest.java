package lesson06.homework05_06;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AccountTest{

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver= new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        logIn("kateryna.puzyrna@gmail.com","12345");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Before
    public void myPage() {
        driver.get(" http://automationpractice.com/index.php?controller=my-account");
    }

    @Test
    public void orderHistoryAndDetails(){
        pageOpen("//*[@id='center_column']/div/div[1]/ul/li[1]");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText().contains("ORDER HISTORY"));
    }
    @Test
    public void myCreditSlips(){
        pageOpen("//*[@id='center_column']/div/div[1]/ul/li[2]");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText().contains("CREDIT SLIPS"));
    }
    @Test
    public void myAddresses(){
        pageOpen("//*[@id='center_column']/div/div[1]/ul/li[3]");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText().contains("MY ADDRESSES"));
    }
    @Test
    public void myPersonalInformation(){
        pageOpen("//*[@id='center_column']/div/div[1]/ul/li[4]");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/h1")).getText().contains("YOUR PERSONAL INFORMATION"));
    }
    @Test
    public void myWishlists(){
        pageOpen("//*[@id='center_column']/div/div[2]//span");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"mywishlist\"]/h1")).getText().contains("MY WISHLISTS"));
    }

    private void pageOpen(String xPath) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xPath))))
                .click();
        }

    private static void logIn(String email, String password) {
        driver.findElement(By.xpath("//*[@id='header']//a[@class='login']")).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"email\"]"))))
                .sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
    }

}


