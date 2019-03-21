package lesson10.a_add_wd_event_listener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends SimpleAPI {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Override
	WebDriver getDriver() {
		return driver;
	}
}
