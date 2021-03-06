package lesson07.f_customized_waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "passwd")
    WebElement pwd;

    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]/span")
    WebElement signInConfirmButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void logIn(String emailAddress, String password) {
        email.sendKeys(emailAddress);
        pwd.sendKeys(password);
        signInConfirmButton.click();
    }
}