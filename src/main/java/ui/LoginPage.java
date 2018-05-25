package ui;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends BasePage {

    private static final By LOGIN_FILD_LOCATOR = By.xpath("//*[@id='fm-login-id']");
    private static final By PASSWORD_FILD_LOCATOR = By.xpath("//*[@id='fm-login-password']");
    private static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//*[@id='fm-login-submit']");
    private static final By SLIDER_BUTTON_LOCATOR = By.xpath("//div[@id='nocaptcha']//div[@class='nc_scale']/span");
    private static final By SLIDER_MODULE_LOCATOR = By.id("nc_1_n1z");
    private static final By LOGIN_BOX_LOCATOR     = By.id("alibaba-login-box");
    private static final String frameName         = "alibaba-login-box";




    public  void setCredentials(String login, String password){
        driver.switchTo().frame(frameName);
        driver.findElement(LOGIN_FILD_LOCATOR).sendKeys(login);
        driver.findElement(PASSWORD_FILD_LOCATOR).sendKeys(password);
        driver.findElement(SUBMIT_BUTTON_LOCATOR).click();
    }

    public  void moveSlider () throws InterruptedException {
        WebElement slider = Driver.get().findElement(SLIDER_BUTTON_LOCATOR);
        Actions builder = new Actions(Driver.get());
        Driver.waitForElementVisible(SLIDER_MODULE_LOCATOR, 5);
        Action seriesOfActions = builder.moveToElement(Driver.get().findElement(SLIDER_BUTTON_LOCATOR)).clickAndHold().moveByOffset(285,0).build();
        seriesOfActions.perform();
        driver.switchTo().parentFrame();
    }

     public  boolean noCapture(){
         return Driver.isElementPresent(LOGIN_BOX_LOCATOR);

     }

}
