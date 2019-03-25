package lesson07.f_customized_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CustomizedWaits {

    protected static WebDriver driver;

    static void listNthElementHasText(By locator, int elNo, String expText) {
        List<WebElement> list = driver.findElements(locator);
        System.out.println(list.get(elNo).getText());
        try {

            (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions
                            .textToBePresentInElement(list.get(elNo), expText));
        }
        catch (IndexOutOfBoundsException ex)
        {
            System.out.println("Index out of bounds: "+list.size());
        }
    }
}
