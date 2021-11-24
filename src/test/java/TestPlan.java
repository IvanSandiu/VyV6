import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPlan {

    private static final WebDriver driver= new ChromeDriver();

    @BeforeSuite
    public static void main(String [] args){
        System.setProperty("webdriver.chrome.driver",Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Login successfully")
    public static void loginSuccessfully(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm= new LoginForm(driver);
        loginForm.enterUsername();
        loginForm.enterPassword();
        loginForm.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ProductPage productPage= new ProductPage(driver);
        Assert.assertEquals(productPage.getTitle(),"PRODUCTS");
    }

    @Test(testName = "Add one item to cart")
    public static void verifyItemAdded(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm= new LoginForm(driver);
        loginForm.enterUsername();
        loginForm.enterPassword();
        loginForm.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ProductPage productPage= new ProductPage(driver);
        productPage.addToCarBackpack();
        Assert.assertEquals(productPage.getCardBadge(),"1");
    }

    /*
    Credenciales incorrectas - Verificar login no válido (TC 1)
        Ir a la URL de saucedemo
        Ingresar en Username un usuario que no existe
        Ingresar en Password una contraseña no válida
        Click en Login
     */
    @Test(testName = "Invalid Login")
    public static void invalidLogin(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm= new LoginForm(driver);
        loginForm.enterFalseUsername();
        loginForm.enterFalsePassword();
        loginForm.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ProductPage productPage= new ProductPage(driver);
        Assert.assertEquals(productPage.getErrorMsg(),"Epic sadface: Username and password do not match any user in this service");
    }

    /*
    Desloguearse correctamente (TC 2)
        Ir a la URL de saucedemo
        Ingresar un username válido
        Ingresar un password válido
        Click en Login
        Abrir el menú colapsable
        Click en Logout
     */

    @Test(testName = "Logout Successfully")
    public static void logoutSuccessfully(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm= new LoginForm(driver);
        loginForm.enterUsername();
        loginForm.enterPassword();
        loginForm.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ProductPage productPage= new ProductPage(driver);
        productPage.openMenuColapsable();
        productPage.logoutSession();
    }

    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }


}
