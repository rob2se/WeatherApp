package PageObjects;

import Helper.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WeatherSitePageObjects extends BaseClass {
    public WeatherSitePageObjects(WebDriver driver) {
        super(driver);
    }

    public WebElement cityField(){
        return this.getElement(Locator.Id, "city");
    }

    public WebElement forecastSummaryDiv(){
        return this.getElement(Locator.CssSelector, "#root > div");
    }

    public WebElement cityErrorMessage(){
        return this.getElement(Locator.CssSelector, "#root > div > div");
    }

    public WebElement dayOneSummary(){
        return this.getElement(Locator.CssSelector, "#root > div > div:nth-child(2)");
    }

    public WebElement dayOneDetail(){
        return this.getElement(Locator.CssSelector, "#root > div > div:nth-child(2) > div.details");
    }
}
