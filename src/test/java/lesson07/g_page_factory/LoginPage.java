package lesson07.g_page_factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "passwd")
    WebElement pwd;

    @FindBy(xpath = "//*[@id='header']//a[@class='login']")
    WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]/span")
    WebElement signInConfirmButton;

    @FindAll(@FindBy(xpath = "//*[@id='center_column']/div/div[1]/ul/li"))
    static
    By myAccountList;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void logIn(String emailAddress, String password) {
        signInButton.click();
        email.sendKeys(emailAddress);
        pwd.sendKeys(password);
        signInConfirmButton.click();
    }
}
