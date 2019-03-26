package lesson07.f_customized_waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Condition {
    boolean abstractMethod(By locator, int elNo, String expText);
    boolean abstractMethod(String expUrl, String expTitle);
    boolean abstractMethod(WebElement elToBeDisappeared);
}
