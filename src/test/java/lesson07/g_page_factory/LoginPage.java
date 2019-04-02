package lesson07.g_page_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

protected WebDriver driver;
    @FindBy(xpath = "//*[@id='header']//a[@class='login']")
    WebElement signInButton;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "passwd")
    WebElement pwd;

    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]/span")
    WebElement signInConfirmButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public LoginPage enterUsername(String username) {
        email.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        pwd.sendKeys(password);
        return this;
    }

    public LoginPage clickSignInBtn() {
        signInConfirmButton.click();
        return this;
    }

    public AccountPage logIn(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSignInBtn();
        return new AccountPage(driver);
    }
}
