package Actions;

import PageObjects.BaseClass;
import PageObjects.WeatherSitePageObjects;
import StepDefinitions.Hooks;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WeatherSiteActions extends BaseClass {
    public WeatherSiteActions(WebDriver driver) {
        super(driver);
    }

    private WeatherSitePageObjects weatherObjects = new WeatherSitePageObjects(Hooks.driver);


    public void checkCityFieldDefaultValue(){
        Assert.assertEquals("Glasgow", weatherObjects.cityField().getAttribute("defaultValue") );
    }

    public void checkFiveDayForecastIsDisplayed(){
        List<WebElement> forecastDays = weatherObjects.forecastSummaryDiv().findElements(By.cssSelector("div.summary"));
        Assert.assertEquals(5, forecastDays.size() );
    }

    //For some reason, .clear() didnt work as expected so passed in keystrokes.  No time to debug. Need to get this sent off.
    public void clearConentsOfCityField(){
        weatherObjects.cityField().sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE, Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE);
    }

    public void enterUnknownCity(){
        weatherObjects.cityField().sendKeys("QWERTY");
    }

    public void submitForm(){
        weatherObjects.cityField().click();
        weatherObjects.cityField().submit();
    }

    public void checkErrorMessage(){
        Assert.assertEquals("Error retrieving the forecast", weatherObjects.cityErrorMessage().getAttribute("innerText"));
    }

    public void expandDayOne(){
        //get dimensions of the details element before click
        Dimension beforeClick = driver.findElement(By.cssSelector("#root > div > div:nth-child(2) > div.details")).getSize();
        //Assert that prior to clicking the summary, that the details area is hidden from user
        Assert.assertEquals(0, beforeClick.getHeight());
        //perform click
        weatherObjects.dayOneSummary().click();
        //wait for the 'clientHeight' value to change following the click
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.attributeToBe(weatherObjects.dayOneDetail(), "clientHeight", "116"));
        //Assert that following the click on the day summary, that the expanded view is displayed
        Dimension afterClick = driver.findElement(By.cssSelector("#root > div > div:nth-child(2) > div.details")).getSize();
        Assert.assertEquals(116, afterClick.getHeight());
    }

    public void checkThreeHourlyForecastsAreDisplayed(){
        List<WebElement> hourlyForecast = weatherObjects.forecastSummaryDiv().findElements(By.cssSelector("div.details"));
        Assert.assertEquals(3, hourlyForecast.size());

    }


}
