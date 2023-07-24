package jav.pages;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class LoginPopup {
    SHAFT.GUI.WebDriver driver;
    private String url = "https://www.demoblaze.com/";

    //Locators ...
    private By loginUserName=By.id("loginusername");
    private By loginPassword=By.id("loginpassword");
    private By loginButton=By.xpath("//button[@onclick=\"logIn()\"]");

    //button[@onclick="register()"]
    public LoginPopup(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    public LoginPopup navigate(){
        driver.browser().navigateToURL(url);
        return this;
    }

    public LoginPopup typeUsername(String username) {
        driver.element().clear(loginUserName);
        driver.element().type(loginUserName,username);
        return this;
    }
    public LoginPopup typePassword(String password){
        driver.element().typeAppend(loginPassword, password);
        return this;
    }
    public LoginPopup clickOnLogin(){
        driver.element().click(loginButton);
        return this;
    }
}