package PageObjects;

import Helper.Locator;
import StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseClass {
    protected static WebDriver driver = Hooks.driver;
    private static boolean bResult;
    private WebElement webElement = null;

    public BaseClass(WebDriver driver){
        BaseClass.driver = Hooks.driver;
        BaseClass.bResult = true;
    }

    public WebElement getElement(Locator locator, String value) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        switch (locator) {
            case ClassName:
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(value)));
                wait.until(ExpectedConditions.elementToBeClickable(By.className(value)));
                webElement = driver.findElement(By.className(value));
                break;
            case CssSelector:
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value)));
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(value)));
                webElement = driver.findElement(By.cssSelector(value));
                break;
            case Id:
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
                wait.until(ExpectedConditions.elementToBeClickable(By.id(value)));
                webElement = driver.findElement(By.id(value));
                break;
            case LinkText:
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(value)));
                wait.until(ExpectedConditions.elementToBeClickable(By.linkText(value)));
                webElement = driver.findElement(By.linkText(value));
                break;
            case Name:
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
                wait.until(ExpectedConditions.elementToBeClickable(By.name(value)));
                webElement = driver.findElement(By.name(value));
                break;
            case PartialLink:
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(value)));
                wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(value)));
                webElement = driver.findElement(By.partialLinkText(value));
                break;
            case TagName:
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(value)));
                wait.until(ExpectedConditions.elementToBeClickable(By.tagName(value)));
                webElement = driver.findElement(By.tagName(value));
                break;
            case Xpath:
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(value)));
                webElement = driver.findElement(By.xpath(value));
                break;
        }
        return webElement;
    }

    protected boolean isElementPresent(String value) {
        try {
            driver.findElement(By.cssSelector(value));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}