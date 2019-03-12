package lesson07.d_be_careful_with_cached_el;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver= new ChromeDriver();

        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void verifyFirstTip(){
        String query1="Dress";
        String query2="T-shirt";
        LandingPage landingPage = new LandingPage(driver);

        landingPage.searchFor(query1);

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions
                        .textToBePresentInElement(landingPage.firstTip, query1));


        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions
                        .textToBePresentInElementLocated(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]"), "Dress"));

        (new WebDriverWait(driver, 10)).ignoring(StaleElementReferenceException.class)
                .until(webDriver ->webDriver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]")).getText().contains("Dress"));
        /*Assert.assertThat(driver.
                        findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]")).getText(),
                containsString("Dress"));*/

        //driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).clear();
        driver.findElement(By.id("search_query_top")).sendKeys("T-shirt");
        /*Assert.assertThat(driver.
                        findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]")).getText(),
                containsString("T-shirt"));*/
        (new WebDriverWait(driver, 10)).ignoring(StaleElementReferenceException.class)
                .until(webDriver ->webDriver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]")).getText().contains("T-shirt"));

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions
                        .textToBePresentInElement(searchRes, "T-shirt"));

    }
    class LandingPage {
        @CacheLookup
        @FindBy(id="search_query_top")
        WebElement searchField;

        //@CacheLookup
        @FindBy(xpath="//*[@id=\"index\"]/div[2]/ul/li[1]")
        WebElement firstTip;

        public LandingPage(WebElement searchField) {
            PageFactory.initElements(driver,this);
        }

        void searchFor(String query) {
            searchField.clear();
            searchField.sendKeys(query);
        }
    }

}


