package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;
    private String usuarioValido = "standard_user";
    private String usuarioInvalido = "standard";
    private String password = "secret_sauce";
    private String invalidPassword = "123456";


    @FindBy(css = "h3[data-test='error']")
    public WebElement msg_error;
    @FindBy(id = "user-name")
    private WebElement input_Username;
    @FindBy(id = "password")
    private WebElement input_Password;
    @FindBy(id = "login-button")
    private WebElement btn_Login;


    public String getInvalidPassword(){ return invalidPassword; }
    public String getUsuarioInvalido(){
        return usuarioInvalido;
    }
    public String getUsuarioValido() {
        return usuarioValido;
    }
    public String getPassword() { return password; }
    public WebElement getInput_Username(){
        return this.input_Username;
    }
    public WebElement getInput_Password(){
        return this.input_Password;
    }
    public WebElement getBtn_Login(){
        return this.btn_Login;
    }


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}


