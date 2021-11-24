import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends PageObject{

    private final String USERNAME= "standard_user";
    private final String PASSWORD= "secret_sauce";
    private final String FUSERNAME= "false_user";
    private final String FPASSWORD= "secret_sauce_invalid";

    @FindBy(id="user-name")
    private WebElement username;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="login-button")
    private WebElement login_buttom;

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(){
        this.username.sendKeys(USERNAME);
    }

    public void enterPassword(){
        this.password.sendKeys(PASSWORD);
    }

    public void enterFalseUsername(){
        this.username.sendKeys(FUSERNAME);
    }

    public void enterFalsePassword(){
        this.password.sendKeys(FPASSWORD);
    }

    public void pressLoginButton(){
        this.login_buttom.click();
    }

}
