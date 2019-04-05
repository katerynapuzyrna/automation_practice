package lesson10.d_purchase;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {

    protected WebDriver driver;
    public int timeOut=100;

    public Waiters(WebDriver driver) {
        this.driver = driver;
    }
    public Waiters(WebDriver driver, int timeOut) {
        this.driver = driver;
        this.timeOut=timeOut;
    }

    public void textInElement(WebElement element, String text) {
        (new WebDriverWait(driver,timeOut))
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void clickable(WebElement element) {
        (new WebDriverWait(driver,timeOut))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void listNthElementHasText(List<WebElement> locator, int elNo, String expText) {
        try
        {
            (new WebDriverWait(driver, timeOut))
                    .until(ExpectedConditions.and((ExpectedCondition<Boolean>) (driver) -> locator.size()>=elNo,
                            (ExpectedCondition <Boolean>) (driver) -> locator.get(elNo-1).getText().contains(expText)));
        }
        catch (IndexOutOfBoundsException ex)
        {
            System.out.println("Index out of bounds: only "+locator.size()+" elements are present in the list");
        }
    }
}
