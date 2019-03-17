package lesson06.homework05_06;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.containsString;

public class AccountTest {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver= new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id='header']//a[@class='login']")).click();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("kateryna.puzyrna@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("12345");
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
       // driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[1]")).click();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Before
    public void myPage() {
        driver.get(" http://automationpractice.com/index.php?controller=my-account");
    }

    @Test
    public void orderHistoryAndDetails(){
        driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[1]")).click();
        //System.out.println(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText());

        //*[@id="columns"]/div[1]/span[3]
        //*[@id="center_column"]/h1
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText().contains("ORDER HISTORY"));
    }
    @Test
    public void myCreditSlips(){
        driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[2]")).click();
        //System.out.println(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText());

        //*[@id="columns"]/div[1]/span[3]
        //*[@id="center_column"]/h1
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText().contains("CREDIT SLIPS"));
    }
    @Test
    public void myAddresses(){
        driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[3]")).click();
        //System.out.println(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText());

        //*[@id="columns"]/div[1]/span[3]
        //*[@id="center_column"]/h1
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText().contains("MY ADDRESSES"));
    }
    @Test
    public void myPersonalInformation(){
        driver.findElement(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[4]")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText());

        //*[@id="columns"]/div[1]/span[3]
        //*[@id="center_column"]/h1
       // Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText().contains("YOUR PERSONAL INFORMATION"));
    }
    @Test
    public void myWishlists(){
        driver.findElement(By.xpath("//*[@id='center_column']/div/div[2]//span")).click();
        //System.out.println(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText());

        //*[@id="columns"]/div[1]/span[3]
        //*[@id="center_column"]/h1
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"mywishlist\"]/h1")).getText().contains("MY WISHLISTS"));
    }
}


