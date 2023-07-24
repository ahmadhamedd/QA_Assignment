package jav.pages;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SignUpPopup {
    SHAFT.GUI.WebDriver driver;

    //Locators ...
    private By signUpUserName=By.id("sign-username");
    private By signUpPassword=By.id("sign-password");
    private By signUpButton=By.xpath("//button[@onclick=\"register()\"]");

    public SignUpPopup(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    public SignUpPopup typeUsername(String username){
        driver.element().clear(signUpUserName).type(signUpUserName,username);
        return this;
    }
    public SignUpPopup typePassword(String password){
        driver.element().clear(signUpPassword).type(signUpPassword, password);
        return this;
    }
    public SignUpPopup clickOnSignUp(){
        driver.element().click(signUpButton);
        return this;
    }
}