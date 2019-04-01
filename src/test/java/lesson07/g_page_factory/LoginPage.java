package lesson07.g_page_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

protected WebDriver driver;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "passwd")
    WebElement pwd;

    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]/span")
    WebElement signInConfirmButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void enterUsername(String username) {
        email.sendKeys(username);
    }

    public void enterPassword(String password) {
        pwd.sendKeys(password);
    }

    public void clickSignInBtn() {
        signInConfirmButton.click();
    }

    public void logIn(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSignInBtn();
        //AccountPage accountPage = new AccountPage(driver);
        //return accountPage;
    }
}
