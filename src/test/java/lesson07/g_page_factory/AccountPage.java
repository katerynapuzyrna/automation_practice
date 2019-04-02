package lesson07.g_page_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    protected WebDriver driver;

    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='header']//a[@class='logout']")
    WebElement logOut;

    @FindBy(xpath = "//*[@id=\"center_column\"]/h1")
    WebElement myAccountHeading;

    public LoginPage signOut()
    {
        logOut.click();
       return new LoginPage(driver);
    }
}
