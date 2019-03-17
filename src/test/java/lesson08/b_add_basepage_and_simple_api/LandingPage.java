package lesson08.b_add_basepage_and_simple_api;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

class LandingPage extends  BasePage{

    private WebDriver driver;

    By searchFieldLocator = By.id("search_query_top");
    By firstTipLocator = By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]");

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    void searchFor(String query) {
        waitFor(ExpectedConditions::elementToBeClickable).click();
        $(searchFieldLocator).clear();
        $(searchFieldLocator).sendKeys(query);
    }

    void visit() {
        open("http://automationpractice.com/index.php");
    }
}