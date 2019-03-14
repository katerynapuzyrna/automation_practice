package lesson08.b_add_basepage_and_simple_api;

import org.openqa.selenium.WebDriver;

public abstract class BasePage extends SimpleAPI {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    WebDriver getDriver() {
        return driver;
    }
}
