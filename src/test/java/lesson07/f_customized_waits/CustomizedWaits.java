package lesson07.f_customized_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CustomizedWaits {

    protected static WebDriver driver;

    public static void waiter(By someXpathLocator){
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(someXpathLocator));
    }
    static void listNthElementHasText(By locator, int elNo, String expText) {
        try {

            (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.numberOfElementsToBeMoreThan(locator,2));
            (new WebDriverWait(driver, 10))
                    .until((ExpectedCondition<Boolean>) (notnull) ->
                    {
                        return driver.findElements(locator).get(elNo).getText().equals(expText)&&driver.findElements(locator).size()>=elNo;
                    });

                    //By locator, int el, String exp)->
                           // {return driver.findElements(locator).get(el).getText().equals(exp);});


                            //ExpectedConditions.
                            //textToBePresentInElement(driver.findElements(locator).get(elNo), expText));
        }
        catch (IndexOutOfBoundsException ex)
        {
            System.out.println("Index out of bounds: "+driver.findElements(locator).size());
        }
    }
}
