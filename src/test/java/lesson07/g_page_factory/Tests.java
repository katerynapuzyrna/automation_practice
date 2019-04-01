package lesson07.g_page_factory;

import org.junit.*;
import org.openqa.selenium.By;

public class Tests extends BaseTest{

    @Ignore @Test
    public void logIn () {
        driver.findElement(By.xpath("//*[@id='header']//a[@class='login']")).click();
        loginPage.logIn("kateryna.puzyrna@gmail.com","12345");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText().equals("MY ACCOUNT"));
    }

    @Test
    public void logInChain () {
        driver.findElement(By.xpath("//*[@id='header']//a[@class='login']")).click();
        loginPage.enterUsername("kateryna.puzyrna@gmail.com");
        loginPage.enterPassword("12345");
        loginPage.clickSignInBtn();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText().equals("MY ACCOUNT"));
    }

    @Test
    public void logOut () {
        driver.findElement(By.xpath("//*[@id='header']//a[@class='login']")).click();
        loginPage.logIn("kateryna.puzyrna@gmail.com","12345");
        accountPage.signOut();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='header']//a[@class='login']")).isDisplayed());
    }
}


