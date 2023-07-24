package jav.pages;
import com.shaft.driver.SHAFT;
import org.checkerframework.checker.units.qual.N;
import org.openqa.selenium.By;

public class CartPage {
    SHAFT.GUI.WebDriver driver;
    //Locators ...
    private String url = "https://www.demoblaze.com/prod.html";
    private By addToCart =By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
    private By orderButton =By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");

    private By name =By.id("name");
    private By country =By.id("country");
    private By city =By.id("city");
    private By card =By.id("card");
    private By month =By.id("month");
    private By year =By.id("year");
    private By purchaseOrder =By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
    private By successMessage =By.xpath("//h2[text()='Thank you for your purchase!']");
    private By deleteFromCart=By.xpath("//*[contains(text(),'Delete')]");

    public CartPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    public CartPage navigate(){
        driver.browser().navigateToURL(url);
        return this;
    }
    public CartPage clickOnAddToCart(){
        driver.element().click(addToCart);
        return this;
    }
    public CartPage clickOnOrderButton(){
        driver.element().click(orderButton);
        return this;
    }
    public CartPage fillCheckoutFields(String Name, String Country, String City, String Card, String Month, String Year){
        driver.element().clear(name);
        driver.element().type(name,Name);
        driver.element().type(country,Country);
        driver.element().type(city,City);
        driver.element().type(card,Card);
        driver.element().type(month,Month);
        driver.element().type(year,Year);
        return this;
    }
    public CartPage fillRequiredFields(String Name, String Card){
        this.typeName(Name);
        driver.element().type(card,Card);
        this.clickPurchase();
        return this;
    }
    public CartPage typeName(String Name){
        driver.element().clear(name);
        driver.element().type(name,Name);
        return this;
    }
    public String getSuccessMessage() {
        return driver.element().getText(successMessage);
    }
    public CartPage clickPurchase() {
        driver.element().click(purchaseOrder);
        return this;
    }
    public CartPage clickOnDeleteFromCart(){
        driver.element().click(deleteFromCart);
        return this;
    }
    public CartPage assertThatDeleteItemIsNotExist(){
        driver.assertThat().element(deleteFromCart).doesNotExist().perform();
        return new CartPage(driver);
    }
}