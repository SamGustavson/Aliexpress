package ui;
import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private static final String frameName   = "alibaba-login-box";

    @FindBy(xpath = "//*[@id='fm-login-id']")
    private static WebElement loginFild;

    @FindBy(xpath = "//*[@id='fm-login-password']")
    private static WebElement passwordFild;

    @FindBy(xpath = "//*[@id='fm-login-submit']")
    private static WebElement submitButton;

    @FindBy(xpath = "//div[@id='nocaptcha']//div[@class='nc_scale']/span")
    private static WebElement sliderButton;

    @FindBy(id = "nc_1_n1z")
    private static WebElement sliderModule;

    @FindBy(id = "alibaba-login-box")
    private static WebElement loginBox;

    private static final By SLIDER_MODULE = By.id("nc_1_n1z");
    private static final By LOGIN_BOX = By.id("alibaba-login-box");

    public  void setCredentials(String login, String password){
        driver.switchTo().frame(frameName);
        loginFild.sendKeys(login);
        passwordFild.sendKeys(password);
        submitButton.click();
    }

    public  void moveSlider () {
        Actions builder = new Actions(Driver.get());
        if (isElementPresent(SLIDER_MODULE)) {
            Action seriesOfActions = builder.moveToElement(sliderButton).clickAndHold().moveByOffset(285,0).build();
            seriesOfActions.perform();
            driver.switchTo().parentFrame();
        }
    }

     public  boolean noCapture(){
         return BasePage.isElementPresent(LOGIN_BOX);
     }
}
