package jav.pages;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ProductPage {
    SHAFT.GUI.WebDriver driver;
    //Locators ...
    private String url = "https://www.demoblaze.com/prod.html";
    private By addToCart =By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
    public ProductPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    public ProductPage navigate(){
        driver.browser().navigateToURL(url);
        return this;
    }
    public ProductPage clickOnAddToCart(){
        driver.element().click(addToCart);
        return this;
    }

}