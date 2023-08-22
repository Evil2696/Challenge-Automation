package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.TimeHelper;

public class TestLoginInvalido extends BaseTest{

    @Test
    public void loginInvalido() {

        WebDriver driver = getDriver();

        LoginPage login = new LoginPage(driver);

        login.getInput_Username().clear();
        login.getInput_Username().sendKeys(login.getUsuarioInvalido());

        login.getInput_Password().clear();
        login.getInput_Password().sendKeys(login.getInvalidPassword());

        login.getBtn_Login().click();

        TimeHelper.waitUntilByVisible(login.msg_error, 10);

        Assert.assertTrue(login.msg_error.isDisplayed(), "El elemento no está visible.");
    }
}
