package lesson07.g_page_factory;

import org.junit.*;
import static org.hamcrest.CoreMatchers.notNullValue;

public class Tests extends BaseTest{

    @Test
    public void logIn () {
        loginPage.signInButton.click();
        loginPage.logIn("kateryna.puzyrna@gmail.com","12345");
        Assert.assertEquals("MY ACCOUNT", accountPage.myAccountHeading.getText());
    }

    @Ignore @Test
    public void logInChain () {
        loginPage.signInButton.click();
        loginPage
                .enterUsername("kateryna.puzyrna@gmail.com")
                .enterPassword("12345")
                .clickSignInBtn();
        Assert.assertEquals("MY ACCOUNT", accountPage.myAccountHeading.getText());
    }

    @Test
    public void logOut () {
        loginPage.signInButton.click();
        loginPage.logIn("kateryna.puzyrna@gmail.com","12345");
        accountPage.signOut();
        Assert.assertThat(loginPage.signInButton, notNullValue());
    }
}


