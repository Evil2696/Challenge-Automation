package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage{

    private WebDriver driver;
    private String firstName = "Pedro";
    private String lastName = "Gonzalez";
    private String postalCode = "1616";

    @FindBy(id = "first-name")
    private WebElement input_FirstName;
    @FindBy(id = "last-name")
    private WebElement input_LastName;
    @FindBy(id = "postal-code")
    private WebElement input_PostalCode;
    @FindBy(id = "continue")
    private WebElement btn_Continue;

    @FindBy(id = "Error Intencional")
    private WebElement btn_finish;


    public String getFirstName(){ return firstName; }
    public String getLastName(){ return lastName; }
    public String getPostalCode(){ return postalCode; }
    public WebElement getInput_FirstName(){ return input_FirstName; }
    public WebElement getInput_LastName(){ return input_LastName; }
    public WebElement getInput_PostalCode(){ return input_PostalCode; }
    public WebElement getBtn_Continue(){ return btn_Continue; }
    public WebElement getBtn_finish(){ return btn_finish; }


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
