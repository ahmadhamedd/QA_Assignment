import com.shaft.driver.SHAFT;
import jav.pages.CartPage;
import jav.pages.HomePage;
import jav.pages.Navbar;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTests {
    private  SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;
    HomePage homePage;
    CartPage cartPage;
    @Test(description = "Add Item To Cart",priority = 1)
    public void addItemToCart() {
      homePage.clickOnAnyItem().clickOnAddToCart();
      SHAFT.Validations.assertThat().object(driver.alert().getAlertText()).isEqualTo("Product added").perform();
    }
    @Test(description = "Checkout Without Filling Required Fields",priority = 2)
    public void checkoutWithoutFillingRequiredField() {
        homePage.clickOnAnyItem().clickOnAddToCart();
        driver.alert().acceptAlert();
        new Navbar(driver).clickOnCart().clickOnOrderButton()
                .typeName("Name").clickPurchase();
        SHAFT.Validations.assertThat().object(driver.alert().getAlertText()).isEqualTo("Please fill out Name and Creditcard.").perform();
    }
    @Test(description = "Complete successful checkout with random item",priority = 3)
    public void checkoutSuccessfully() {
      homePage.clickOnAnyItem().clickOnAddToCart();
      driver.alert().acceptAlert();
      SHAFT.Validations.assertThat().object(new Navbar(driver)
              .clickOnCart()
              .clickOnOrderButton()
              .fillRequiredFields("tes","testCard")
              .getSuccessMessage()
)     .isEqualTo("Thank you for your purchase!").perform();
    }
    @Test(description = "Delete Item From Cart",priority = 4)
    public void deleteItemFromCart() {
        homePage.clickOnAnyItem().clickOnAddToCart();
        driver.alert().acceptAlert();
        new Navbar(driver).clickOnCart().clickOnDeleteFromCart().assertThatDeleteItemIsNotExist();
    }
    @BeforeClass(description = "")
    public void beforeClass(){

    }
    @BeforeMethod(description = "Setup")
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
        homePage=new HomePage(driver);
        homePage.navigate();
    }
    @AfterMethod(description = "Teardown")
    public void afterMethod() {
        driver.quit();
    }
}