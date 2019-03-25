package lesson06.homework05_06;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchTest {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void searchPrintedSummerDress(){
        driver.findElement(By.id("search_query_top")).clear();
        driver.findElement(By.id("search_query_top")).sendKeys("Printed Summer Dress");
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[@id='center_column']/ul/li"), 2));
        List<WebElement> list = driver.findElements(By.xpath("//*[@id='center_column']/ul/li/div/div[2]/h5/a"));
        Assert.assertEquals(3,list.size());
        Assert.assertEquals("Printed Summer Dress",list.get(1).getText());
    }
}
