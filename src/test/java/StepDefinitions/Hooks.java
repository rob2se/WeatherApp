package StepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;


public class Hooks
{
    public static WebDriver driver;

    @Before
        public void launchFrontEnd() {

        //Launch site
        System.setProperty("webdriver.chrome.driver",  "/Users/robthomson/Development/chromedriver");

        driver = new ChromeDriver();
        driver.get("https://weather-acceptance.herokuapp.com");
    }

    @After
/**
 * Embed a screenshot in test report if test is marked as failed
 */
    public void embedScreenshot(Scenario scenario)  {
        if(scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            }
            catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
        driver.quit();
    }
}
