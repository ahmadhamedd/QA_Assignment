package jav.pages;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

import javax.lang.model.element.Element;

public class HomePage {
    SHAFT.GUI.WebDriver driver;
    //Locators ...
    private String url = "https://www.demoblaze.com/";
    private By phonesCategory =By.xpath("//*[@id=\"itemc\"][1]");
    private By laptopsCategory =By.xpath("//*[@id=\"itemc\"][2]");
    private By monitorsCategory =By.xpath("//*[@id=\"itemc\"][3]");
    private By categoryElements =By.xpath("//*[@id=\"tbodyid\"]/div");
    private By firstElement =By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/a");
    public HomePage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    public HomePage navigate(){
        driver.browser().navigateToURL(url);
        return this;
    }
    public HomePage clickOnPhonesCategory(){
        driver.element().click(phonesCategory);
        return this;
    }
    public HomePage clickOnLaptopsCategory(){
        driver.element().click(laptopsCategory);
        return this;
    }
    public HomePage clickOnMonitorsCategory(){
        driver.element().click(monitorsCategory);
        return this;
    }
    public int ElementsCount (){
        return driver.element().getElementsCount(categoryElements);
    }
    public ProductPage clickOnAnyItem(){
        driver.element().click(firstElement);
        return new ProductPage(driver);
    }
}