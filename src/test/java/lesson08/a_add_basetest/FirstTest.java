package lesson08.a_add_basetest;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FirstTest extends BaseTest{

    @Test
    public void verifyFirstTip() {
        String query1 = "Dress";
        String query2 = "T-shirt";
        LandingPage landingPage = new LandingPage(driver);

        landingPage.searchFor(query1);
        assertThat(ExpectedConditions
                .textToBePresentInElementLocated(landingPage.firstTipLocator, query1));

        assertThat(ExpectedConditions
                .textToBePresentInElementLocated(landingPage.firstTipLocator, query2));

    }
   void assertThat(ExpectedCondition<Boolean> condition, long timeout){
       (new WebDriverWait(driver, timeout))
               .until(condition);
   }

    void assertThat(ExpectedCondition<Boolean> condition){
        assertThat(condition, 10);
    }

}