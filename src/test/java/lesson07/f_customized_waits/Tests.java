package lesson07.f_customized_waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.containsString;

public class Tests extends BaseTest {

    @Test
    public void myCreditSlips(){
        //Verify that the right page is loaded after choosing MY CREDIT SLIPS option && listNthElementHasText(By locator, int elNo, String expText)
        customizedWaits.listNthElementHasText( By.xpath("//*[@id='center_column']/div/div[1]/ul/li"),2,"MY CREDIT SLIPS");
        customizedWaits.pageOpen("//*[@id='center_column']/div/div[1]/ul/li[2]");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText().contains("CREDIT SLIPS"));
    }

    @Test
    public void orderHistoryAndDetails (){
        //Verify that orders are saved in order history && pageIsLoaded(String expUrl, String expTitle)
        customizedWaits.pageOpen("//*[@id='center_column']/div/div[1]/ul/li[1]");
        customizedWaits.pageIsLoaded("http://automationpractice.com/index.php?controller=history", "Order history - My Store");
        Assert.assertTrue(driver.findElement(By.id("order-list")).isDisplayed());
    }

    @Test
    public void searchTest (){
        //Verify that element was disappeared from search after entering the new one && stalenessOfElement(WebElement elToBeDisappeared)
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.id("search_query_top")).clear();
        driver.findElement(By.id("search_query_top")).sendKeys("Dress");
        customizedWaits.textInElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]"), "Dress");
        driver.findElement(By.id("search_query_top")).clear();
        driver.findElement(By.id("search_query_top")).sendKeys("T-shirt");
        customizedWaits.stalenessOfElement(driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[position()=1 and contains(text(), \"Dress\")]")));
        Assert.assertThat(driver
                        .findElement(By.xpath("//*[@id=\"index\"]/div[2]/ul/li[1]")).getText(),
                containsString("T-shirt"));
    }
}


