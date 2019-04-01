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

    public void signOut()
    {
        logOut.click();
       // LoginPage loginPage = new LoginPage(driver);
       // return loginPage;
    }
}
