import com.shaft.driver.SHAFT;
import jav.pages.HomePage;
import jav.pages.Navbar;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests {
    private  SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;
    HomePage homePage;
    @Test(description = "Verify That Phones Category Has Items",priority = 1)
    public void verifyThatCategory1HasItems() {
      homePage.clickOnPhonesCategory();
      SHAFT.Validations.assertThat().object(homePage.ElementsCount()).doesNotEqual(0).perform();
    }
    @Test(description = "Verify That Laptops Category Has Items",priority = 2)
    public void verifyThatCategory2HasItems() {
        homePage.clickOnLaptopsCategory();
        SHAFT.Validations.assertThat().object(homePage.ElementsCount()).doesNotEqual(0).perform();
    }
    @Test(description = "Verify That Monitors Category Has Items",priority = 3)
    public void verifyThatCategory3HasItems() {
        homePage.clickOnMonitorsCategory();
        SHAFT.Validations.assertThat().object(homePage.ElementsCount()).doesNotEqual(0).perform();
    }
    @BeforeClass(description = "")
    public void beforeClass(){

    }

    @BeforeMethod(description = "Setup.")
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
        homePage=new HomePage(driver);
        homePage.navigate();
    }

    @AfterMethod(description = "Teardown.")
    public void afterMethod() {
        driver.quit();
    }
}