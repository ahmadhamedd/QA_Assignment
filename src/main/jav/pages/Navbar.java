package jav.pages;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class Navbar {
    SHAFT.GUI.WebDriver driver;
    String url = "https://www.google.com/";

    //Locators ...
    private By signUP=By.id("signin2");
    private By signIN=By.id("login2");
    private By showCart=By.id("cartur");

    public Navbar(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    public Navbar navigate(){
        driver.browser().navigateToURL(url);
        return this;
    }
    public SignUpPopup clickOnSignUP(){
        driver.element().click(signUP);
        return new SignUpPopup(driver);
    }
    public CartPage clickOnCart(){
        driver.element().click(showCart);
        return new CartPage(driver);
    }
    public LoginPopup clickOnSignIN(){
        driver.element().click(signIN);
        return new LoginPopup(driver);
    }
}