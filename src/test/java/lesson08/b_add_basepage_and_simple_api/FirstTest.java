package lesson08.b_add_basepage_and_simple_api;

import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest extends BaseTest {

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