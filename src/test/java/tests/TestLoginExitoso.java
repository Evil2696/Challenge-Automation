package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class TestLoginExitoso extends BaseTest{

    @Test
    public void loginExitoso(){

        WebDriver driver = getDriver();

        LoginPage login = new LoginPage(driver);

        login.getInput_Username().clear();
        login.getInput_Username().sendKeys(login.getUsuarioValido());

        login.getInput_Password().clear();
        login.getInput_Password().sendKeys(login.getPassword());

        login.getBtn_Login().click();

        ProductsPage products = new ProductsPage(driver);

        Assert.assertTrue(products.get_Txt_Body().contains("Products"), "Products no está visible en la página.");
    }
}
