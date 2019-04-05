package lesson10.d_purchase;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage{

    protected WebDriver driver;
    Waiters waiters;

    public SearchPage(WebDriver driver, Waiters waiters) {
        PageFactory.initElements(driver, this);
        this.waiters=waiters;
    }

    @FindBy(id = "search_query_top")
    WebElement searchField;

    @FindBy(xpath = "//*[@id='index']/div[2]/ul/li")
    List<WebElement> searchResults;

    @FindBy(xpath = "//*[@id='add_to_cart']/button/span")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[@id='quantity_wanted']")
    WebElement orderQuantity;

    @FindBy(xpath = "//*[@id=\"group_1\"]/option[1]")
    WebElement orderSize;

    @FindBy(xpath = "//*[@id=\"color_to_pick_list\"]/li[@class='selected']/a")
    WebElement orderColor;

    @FindBy(xpath = "//*[@id='our_price_display']")
    WebElement orderPrice;

    public void searchQuery(String query) {
        searchField.clear();
        searchField.sendKeys(query);
    }

    public void chooseNthSearchResult(int elNo, String data)
    {
        waiters.listNthElementHasText(searchResults,elNo,data);
        searchResults.get(elNo-1).click();
    }

    public CartPage addToCart()
    {
        waiters.clickable(addToCartButton);
        addToCartButton.click();
        return new CartPage(driver,waiters);
    }

    public String getOrderQuantity()
    {
        waiters.clickable(addToCartButton);
        return orderQuantity.getAttribute("value");
    }

    public String getOrderSize()
    {
        waiters.clickable(addToCartButton);
        return orderSize.getText();
    }

    public String getOrderColor()
    {
        waiters.clickable(addToCartButton);
        return orderColor.getAttribute("title");
    }

    public String getOrderPrice()
    {
        waiters.clickable(addToCartButton);
        return orderPrice.getText();
    }
}
