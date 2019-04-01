package lesson07.f_customized_waits_nullpointer;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tests extends BaseTest {

    @Test
    public void myCreditSlips(){
        logIn("kateryna.puzyrna@gmail.com","12345");
        CustomizedWaits.listNthElementHasText( By.xpath("//*[@id='center_column']/div/div[1]/ul/li"),1,"MY CREDIT SLIPS");

    }


    static void logIn(String email, String password) {
        driver.findElement(By.xpath("//*[@id='header']//a[@class='login']")).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"email\"]"))))
                .sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
    }

}


