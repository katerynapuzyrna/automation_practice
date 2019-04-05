package lesson10.d_purchase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    protected WebDriver driver;
    Waiters waiters;

    public CartPage(WebDriver driver, Waiters waiters) {
        PageFactory.initElements(driver, this);
        this.waiters=waiters;
    }

    @FindBy(xpath = "//*[@id='layer_cart']//a/span")
    WebElement proceedToCheckoutInCartButton;

    @FindBy(xpath = "//*[@id='center_column']/p[2]/a[1]/span")
    WebElement proceedToCheckoutInSummaryButton;

    @FindBy(xpath = "//*[@id='center_column']/form/p/button/span")
    WebElement proceedToCheckoutInAddressButton;

    @FindBy(xpath = "//*[@id='form']/p/button/span")
    WebElement proceedToCheckoutInShippingButton;

    @FindBy(xpath =  "//*[@id='cgv']")
    WebElement termsOfServiceAgreeButton;

    @FindBy(xpath =  "//*[@id='HOOK_PAYMENT']/div[1]//span")
    WebElement payByBankWireButton;

    @FindBy(xpath =  "//*[@id='cart_navigation']/button/span")
    WebElement proceedToCheckoutInPaymentButton;

    @FindBy(xpath =  "//*[@id='center_column']/p/a")
    WebElement backToOrdersButton;

    @FindBy(xpath =  "//*[@id='center_column']/div")
    WebElement orderDetails;

    @FindBy(xpath =  "//*[@id='layer_cart']/div[1]/div[2]/div[2]/span")
    WebElement orderShippingPrice;

    public String getOrderShippingPrice() {
        waiters.clickable(proceedToCheckoutInCartButton);
        return orderShippingPrice.getText();
    }

    public void proceedToCheckoutInCart() {
        waiters.clickable(proceedToCheckoutInCartButton);
        proceedToCheckoutInCartButton.click();
    }

    public LoginPage proceedToCheckoutInSummary(){
        waiters.clickable(proceedToCheckoutInSummaryButton);
        proceedToCheckoutInSummaryButton.click();
        return new LoginPage(driver,waiters);
    }

    public void proceedToCheckoutInAddress(){
        waiters.clickable(proceedToCheckoutInAddressButton);
        proceedToCheckoutInAddressButton.click();
    }

    public void proceedToCheckoutInShipping(){
        waiters.clickable(proceedToCheckoutInShippingButton);
        termsOfServiceAgreeButton.click();
        proceedToCheckoutInShippingButton.click();
    }

    public void payByBankWire(){
        waiters.clickable(payByBankWireButton);
        payByBankWireButton.click();
    }

    public void proceedToCheckoutInPayment(){
        waiters.clickable(proceedToCheckoutInPaymentButton);
        proceedToCheckoutInPaymentButton.click();
    }

    public String saveOrderDetails(){
        waiters.clickable(backToOrdersButton);
        return orderDetails.getText();
    }

    public OrderPage backToOrders(){
        waiters.clickable(backToOrdersButton);
        backToOrdersButton.click();
        return new OrderPage(driver,waiters);
    }
}
