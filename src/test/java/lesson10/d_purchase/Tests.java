package lesson10.d_purchase;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;

public class Tests extends BaseTest{

    @Test
    public void purchase() {
        String dataToSearch="Printed Summer Dress";
        searchPage.searchQuery(dataToSearch);
        searchPage.chooseNthSearchResult(1, dataToSearch);
        String orderQuantity = searchPage.getOrderQuantity();
        String orderSize = searchPage.getOrderSize();
        String orderColor = searchPage.getOrderColor();
        String orderPrice = searchPage.getOrderPrice();
        String orderDescription = dataToSearch+" - Color : "+orderColor+", Size : "+orderSize;
        searchPage.addToCart();
        String orderShippingPrice = cartPage.getOrderShippingPrice();
        cartPage.proceedToCheckoutInCart();
        cartPage.proceedToCheckoutInSummary();
        loginPage.logIn("kateryna.puzyrna@gmail.com","12345");
        cartPage.proceedToCheckoutInAddress();
        cartPage.proceedToCheckoutInShipping();
        cartPage.payByBankWire();
        cartPage.proceedToCheckoutInPayment();
        String orderDetails = cartPage.saveOrderDetails();
        cartPage.backToOrders();
        String orderNo = orderPage.getLastOrderNo();
        Assert.assertThat(orderDetails, containsString(orderNo));
        orderPage.getLastOrderDetails();
        String lastOrderDescription = orderPage.getLastOrderDescription();
        String lastOrderQuantity = orderPage.getLastOrderQuantity();
        String lastOrderPrice = orderPage.getLastOrderPrice();
        String lastOrderShippingPrice = orderPage.getLastOrderShippingPrice();
        Assert.assertEquals(lastOrderDescription, orderDescription);
        Assert.assertEquals(lastOrderQuantity, orderQuantity);
        Assert.assertEquals(lastOrderPrice, orderPrice);
        Assert.assertEquals(lastOrderShippingPrice, orderShippingPrice);
    }
}
