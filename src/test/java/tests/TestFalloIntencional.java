package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.Screenshot;
import utils.TimeHelper;

import java.util.List;

@Listeners(Screenshot.class)
public class TestFalloIntencional extends BaseTest {

    @Test
    public void loginExitoso(){

        LoginPage login = new LoginPage(getDriver());
        login.getInput_Username().sendKeys(login.getUsuarioValido());
        login.getInput_Password().sendKeys(login.getPassword());
        login.getBtn_Login().click();

        ProductsPage products = new ProductsPage(getDriver());
        Assert.assertTrue(products.get_Txt_Body().contains("Products"), "Products no está visible en la página.");
    }

    @Test (dependsOnMethods = "loginExitoso")
    public void addToCart(){

        ProductsPage products = new ProductsPage(getDriver());

        TimeHelper.waitUntilByVisible(products.getBtn_AddToCart(), 10);

        List<WebElement> elementos = getDriver().findElements(By.cssSelector("button.btn.btn_primary.btn_small.btn_inventory"));

        // Itera sobre la lista de elementos y realiza click en cada uno
        for (WebElement elemento : elementos) {
            elemento.click();
        }

        products.getBtn_Cart().click();
        products.getBtn_Checkout().click();

        CheckoutPage checkout = new CheckoutPage(getDriver());

        checkout.getInput_FirstName().sendKeys(checkout.getFirstName());
        checkout.getInput_LastName().sendKeys(checkout.getLastName());
        checkout.getInput_PostalCode().sendKeys(checkout.getPostalCode());
        checkout.getBtn_Continue().click();
        checkout.getBtn_finish().click();
    }

}
