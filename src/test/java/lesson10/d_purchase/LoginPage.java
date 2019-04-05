package lesson10.d_purchase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    protected WebDriver driver;
    Waiters waiters;

    public LoginPage(WebDriver driver, Waiters waiters) {
        PageFactory.initElements(driver, this);
        this.waiters=waiters;
    }

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "passwd")
    WebElement pwd;

    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]/span")
    WebElement signInConfirmButton;

    public CartPage logIn(String username, String password) {
        waiters.clickable(signInConfirmButton);
        email.sendKeys(username);
        pwd.sendKeys(password);
        signInConfirmButton.click();
        return new CartPage(driver,waiters);
    }
}
