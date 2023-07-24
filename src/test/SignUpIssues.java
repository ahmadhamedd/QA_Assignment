import com.shaft.driver.SHAFT;
import jav.pages.HomePage;
import jav.pages.Navbar;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpIssues {
    private  SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;

    @Test(description = "",priority = 1)
    public void verifyThatUserCantSignUpWithAlreadyExist() {
        new Navbar(driver).clickOnSignUP().typeUsername("TestAccount2").typePassword("TestAccount2").clickOnSignUp();
        SHAFT.Validations.assertThat().object(driver.alert().getAlertText()).isEqualTo("This user already exist.").perform();
    }

    @Test(description = "",priority = 2)
    public void signUpWithoutPassword() {
        new Navbar(driver).clickOnSignUP().typeUsername("TestAccount2").clickOnSignUp();;
        SHAFT.Validations.assertThat().object(driver.alert().getAlertText()).isEqualTo("Please fill out Username and Password.").perform();
    }
//    @Test(description = "",priority = 3)
//    public void signUpWithWrongUserName() {
//        new Navbar(driver).clickOnSignUP().typeUsername("TestAccount").typePassword("TestAccount2").clickOnSignUp();
//        SHAFT.Validations.assertThat().object(driver.alert().getAlertText()).isEqualTo("Wrong password.").perform();
//    }
    @Test(description = "",priority = 4)
    public void signUpWithCorrectCredential() {
        String random = RandomStringUtils.randomAlphabetic(8);
        new Navbar(driver).clickOnSignUP().typeUsername("TestAccount_random").typePassword("TestAccount_random").clickOnSignUp();
        SHAFT.Validations.assertThat().object(driver.alert().getAlertText()).isEqualTo("Sign up successful.").perform();
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