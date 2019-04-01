package lesson07.f_customized_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomizedWaits {

    protected WebDriver driver;

    public CustomizedWaits(WebDriver driver) {
        this.driver = driver;
    }
    public int timeOut=100;

    public void listNthElementHasText(By locator, int elNo, String expText) {
        try
        {
            (new WebDriverWait(driver, timeOut))
                    .until(ExpectedConditions.and(ExpectedConditions.numberOfElementsToBeMoreThan(locator,elNo-1),
                            (ExpectedCondition<Boolean>) (driver) -> driver.findElements(locator).get(elNo-1).getText().equals(expText)));
        }
        catch (IndexOutOfBoundsException ex)
        {
            System.out.println("Index out of bounds: only "+driver.findElements(locator).size()+" elements are present in the list");
        }
    }

    public void pageIsLoaded(String expUrl, String expTitle) {
        (new WebDriverWait(driver, timeOut))
                .until(ExpectedConditions.and(ExpectedConditions.titleIs(expTitle),ExpectedConditions.urlToBe(expUrl)));
    }

    public void stalenessOfElement(WebElement elToBeDisappeared) {
        (new WebDriverWait(driver, timeOut))
                .until(ExpectedConditions.stalenessOf(elToBeDisappeared));
    }

    public void textInElement(By element, String text) {
        (new WebDriverWait(driver,timeOut))
                .until(ExpectedConditions.textToBePresentInElementLocated(element, text));
    }

    public void pageOpen(String xPath) {
        (new WebDriverWait(driver, timeOut))
               .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xPath))))
                .click();
    }
}
