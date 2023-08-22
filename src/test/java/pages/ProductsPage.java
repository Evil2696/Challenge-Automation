package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    private WebDriver driver;

    @FindBy(tagName = "body")
    private WebElement body;

    public String get_Txt_Body(){
        String body_Text = body.getText();
        return body_Text;
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement btn_AddToCart;

    @FindBy(id = "shopping_cart_container")
    private WebElement btn_Cart;

    @FindBy(id = "checkout")
    private WebElement btn_Checkout;

    public WebElement getBtn_Checkout() { return btn_Checkout; }

    public WebElement getBtn_Cart() { return btn_Cart; }

    public WebElement getBtn_AddToCart() { return btn_AddToCart; }

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
