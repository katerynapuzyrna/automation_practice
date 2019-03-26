package lesson07.f_customized_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CustomizedWaits {

    protected static WebDriver driver;

    static void listNthElementHasText(By locator, int elNo, String expText) {
        try {
            (new WebDriverWait(driver, 10))
                    .until((ExpectedCondition<Boolean>) (locator1) ->
                    { String a = driver.findElements(locator).get(elNo).getText();
                        return a.equals(expText);
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
