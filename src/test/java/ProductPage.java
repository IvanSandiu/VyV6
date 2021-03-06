import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageObject{
    @FindBy(xpath = "//span[contains(text(),'Products')]")
    private WebElement products_label;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCart_SauceBackpack;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement cart_badge;

    @FindBy(xpath = "//div[@class='error-message-container error']")
    private WebElement error_message;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuColapsable;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutBtn;

    public ProductPage(WebDriver driver){
        super(driver);
    }

    public String getTitle(){
        return this.products_label.getText();
    }

    public void addToCarBackpack(){
        this.addToCart_SauceBackpack.click();
    }

    public String getCardBadge(){
        return this.cart_badge.getText();
    }

    public String getErrorMsg(){
        return this.error_message.getText();
    }

    public void openMenuColapsable(){
        this.menuColapsable.click();
    }

    public void logoutSession(){
        this.logoutBtn.click();
    }


}
