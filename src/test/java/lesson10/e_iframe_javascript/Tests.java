package lesson10.e_iframe_javascript;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;

public class Tests {

    public static WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void setUp() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void iframe() {
        WebElement iframeLocator = driver.findElement(By.xpath("//*[@id='facebook_block']//iframe"));
        Point p = iframeLocator.getLocation();
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+p.getY()+");");
        driver.switchTo().frame(iframeLocator);
        Assert.assertThat(driver.findElement(By.cssSelector("body > div > script")).getAttribute("innerHTML"),
        containsString("facebook.com"));
    }
}
