package lesson10.d_purchase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

    protected WebDriver driver;
    Waiters waiters;

    public OrderPage(WebDriver driver, Waiters waiters) {
        PageFactory.initElements(driver, this);
        this.waiters=waiters;
    }

    @FindBy(xpath =  "//*[@id='center_column']/h1")
    WebElement orderHistoryPageTitle;

    @FindBy(xpath =  "//*[@id=\"order-list\"]/tbody/tr[1]/td[1]/a")
    WebElement lastOrderNo;

    @FindBy(xpath =  "//*[@id='order-list']/tbody/tr[1]/td[7]/a[1]/span")
    WebElement lastOrderDetails;

    @FindBy(xpath =  "//*[@id='order-detail-content']/table/tbody/tr/td[2]/label")
    WebElement lastOrderDescription;

    @FindBy(xpath =  "//*[@id='order-detail-content']/table/tbody/tr/td[3]")
    WebElement lastOrderQuantity;

    @FindBy(xpath =  "//*[@id=\"order-detail-content\"]/table/tbody/tr/td[5]/label ")
    WebElement lastOrderPrice;

    @FindBy(xpath =  "//*[@id=\"block-order-detail\"]/table/tbody/tr/td[4]")
    WebElement lastOrderShippingPrice;

    public String getLastOrderNo(){
        waiters.textInElement(orderHistoryPageTitle, "ORDER HISTORY");
        return lastOrderNo.getText();
    }

    public void getLastOrderDetails(){
        waiters.textInElement(orderHistoryPageTitle, "ORDER HISTORY");
        lastOrderDetails.click();
    }

    public String getLastOrderDescription(){
        waiters.clickable(lastOrderDescription);
        return lastOrderDescription.getText();
    }

    public String getLastOrderQuantity(){
        waiters.clickable(lastOrderQuantity);
        return lastOrderQuantity.getText();
    }

    public String getLastOrderPrice(){
        waiters.clickable(lastOrderPrice);
        return lastOrderPrice.getText();
    }

    public String getLastOrderShippingPrice(){
        waiters.clickable(lastOrderShippingPrice);
        return lastOrderShippingPrice.getText();
    }
}
