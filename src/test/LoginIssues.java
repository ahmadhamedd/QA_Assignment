
import com.shaft.driver.SHAFT;
import jav.pages.LoginPopup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jav.pages.Navbar;

import jav.pages.HomePage;

public class LoginIssues {
    private  SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;

   @Test(description = "",priority = 1)
    public void verifyThatUserCantLoginWithWrongCredentials() {
       new Navbar(driver).clickOnSignIN().typeUsername("Wrong").typePassword("Wrong").clickOnLogin();
       SHAFT.Validations.assertThat().object(driver.alert().getAlertText()).isEqualTo("User does not exist.").perform();
   }
    @Test(description = "",priority = 2)
    public void verifyThatUserCantLoginWithWrongPassword() {
        new Navbar(driver).clickOnSignIN().typeUsername("TestAccount2").typePassword("Wrong").clickOnLogin();;
        SHAFT.Validations.assertThat().object(driver.alert().getAlertText()).isEqualTo("Wrong password.").perform();
    }
    @Test(description = "",priority = 3)
    public void verifyThatUserCantLoginWithWrongUserName() {
        new Navbar(driver).clickOnSignIN().typeUsername("TestAccount").typePassword("TestAccount2").clickOnLogin();
        SHAFT.Validations.assertThat().object(driver.alert().getAlertText()).isEqualTo("Wrong password.").perform();
    }
    @Test(description = "",priority = 4)
    public void verifyThatUserCanLoginWithCorrectCredentials() {
        new Navbar(driver).clickOnSignIN().typeUsername("TestAccount2").typePassword("TestAccount2").clickOnLogin();
    }
    @BeforeClass(description = "")
    public void beforeClass(){

    }

    @BeforeMethod(description = "Setup Browser instance.")
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
        new HomePage(driver).navigate();
    }

    @AfterMethod(description = "Teardown Browser instance.")
    public void afterMethod() {
       driver.quit();
    }
}