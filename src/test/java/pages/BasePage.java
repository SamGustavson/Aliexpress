package pages;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected static WebDriver driver ;

    BasePage() {
        driver = Driver.get();
        PageFactory.initElements(driver, this);
    }

    public static boolean isElementPresent(By locator) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        List<WebElement> elements = driver.findElements(locator);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return elements.size() > 0 && elements.get(0).isDisplayed();
    }

    public static void waitForElementVisible(WebElement locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public static void waitForElementClickable(WebElement locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForElementNotVisible(WebElement locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.invisibilityOf(locator));
    }
}


