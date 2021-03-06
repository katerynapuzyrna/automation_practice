package lesson11.a_new_basetest;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;

public class LoginTest extends BaseGUITest {
    private LoginPage loginPage;
    @Before
    public void openLoginPage(){
        loginPage = new LoginPage(driver);
        loginPage.visit();
    }
    @Test
    public void Verify_That_Login_Page_Can_Be_Opened(){
        // assert
        Assert.assertThat(
                loginPage.getPageTitle(),
                containsString("Login"));
    }
    @Test
    public void Verify_That_User_Can_Login_Into_Private_Cabinet(){
        // act
        loginPage.logIn("kateryna.puzyrna@gmail.com", "12345");
        // assert
        Assert.assertThat(
                loginPage.getPageTitle(),
                containsString("My account"));
    }

    @Test
    public void Verify_That_User_Can_Login_Into_Private_Cabinet_FAILED(){
        // act
        loginPage.logIn("trandafilov.vladimir@gmail.com", "password");
        // assert
        Assert.assertThat(
                loginPage.getPageTitle(),
                containsString("My account1"));
    }
}