package lesson07.f_customized_waits_nullpointer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomizedWaits {

    protected WebDriver driver;

    /*public static void waiter(By someXpathLocator){
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(someXpathLocator));
    }*/
    void listNthElementHasText(By locator, int elNo, String expText) {
        try {

            (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.numberOfElementsToBeMoreThan(locator,2));
            (new WebDriverWait(driver, 10))
                    .until((ExpectedCondition<Boolean>) (notnull) ->
                    {
                        return driver.findElements(locator).get(elNo).getText().equals(expText)&&driver.findElements(locator).size()>=elNo;
                    });
        }
        catch (IndexOutOfBoundsException ex)
        {
            System.out.println("Index out of bounds: "+driver.findElements(locator).size());
        }
    }

    public CustomizedWaits(WebDriver driver) {
        this.driver = driver;
    }
}
