package ui;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    private static final By CLOSE_BUTTON_LOCATOR = By.xpath("//div[@class='ui-window-content']/a");
    private static final By BACKGROUND_BUTTON_LOCATOR = By.xpath("//div[@class=\"ui-mask\"]");
    private static final By GO_TO_GLOBAL_LOCATOR = By.xpath("//div[@class=\"ng-item ng-goto-globalsite\"]/a");
    private static final By SIGNIN_BUTTON_LOCATOR = By.xpath("//span[@class=\"account-unsigned\"]/a[@data-role='sign-link']");
    private static final By CATEGORY_LOCATOR = By.xpath("//div[@class=\"categories-content-title\"]//a");
    private static final By CATEGORY_LOCATOR_2 = By.xpath("//div[@class=\"categories\"]/div");
    private static final By BAGS_AND_SHOES_LOCATOR = By.xpath("//dl[@class=\"cl-item cl-item-shoes\"]");
    private static final By SUBCATEGORY_LOCATOR = By.xpath("//a[contains(text(), 'Men') and contains(text(), \"Backpacks\")]");
    private static final By SIGNIN_BUTTON_LOCATOR2 = By.xpath("//a[@class='sign-btn']");
    private static final By ENTER_BUTTON_LOCATOR = By.xpath("//a[@class='sign-btn']");
    private static Actions actions = new Actions(Driver.get());


    @FindBy(xpath=("//div[@class='ui-window-content']/a"))
    private  WebElement el;

    public  void navigateToHomePage() {
        driver.get(System.getProperty("test.aliURL"));
    }

    public  void closeCoupon (){
        WebElement popUpWindow = Driver.get().findElement(CLOSE_BUTTON_LOCATOR);
        popUpWindow.click();
        Driver.waitForElementNotVisible(driver.findElement(BACKGROUND_BUTTON_LOCATOR), 3);


    }
    public  void changeGoToGlobalSite (){
        WebElement button = Driver.get().findElement(GO_TO_GLOBAL_LOCATOR);
        button.click();


    }

    public  void openLoginPage() {
        Driver.waitForElementVisible(CATEGORY_LOCATOR, 3);

        WebElement signIn = driver.findElement(SIGNIN_BUTTON_LOCATOR);
        actions.moveToElement(signIn).build().perform();
        Driver.waitForElementVisible(SIGNIN_BUTTON_LOCATOR2, 3);
        signIn.click();
    }

    public  boolean homePageisOpened(){
        Driver.waitForElementClickable(CLOSE_BUTTON_LOCATOR, 5);
        return Driver.isElementPresent(CLOSE_BUTTON_LOCATOR);
    }

    public  void openCategoryPage() throws InterruptedException {
        Driver.waitForElementVisible(CATEGORY_LOCATOR, 3);
        WebElement allcategory = driver.findElement(CATEGORY_LOCATOR_2);
//        WebElement bagsAndShoes = driver().findElement(BAGS_AND_SHOES_LOCATOR);
        actions.moveToElement(allcategory).build().perform();
        Driver.waitForElementVisible(BAGS_AND_SHOES_LOCATOR, 3);
        actions.moveToElement(driver.findElement(BAGS_AND_SHOES_LOCATOR)).build().perform();
        Driver.waitForElementVisible(SUBCATEGORY_LOCATOR, 3);
        actions.moveToElement(driver.findElement(SUBCATEGORY_LOCATOR)).build().perform();
        Thread.sleep(2000);
        WebElement mensLuggage = driver.findElement(SUBCATEGORY_LOCATOR);
        mensLuggage.click();

    }
    public  void changeCurrency(){
        Driver.get().findElement(By.xpath("//a[@id=\"switcher-info\"]/span")).click();
        Driver.get().findElement(By.xpath("//div[@class=\"list-title fold\"]/span")).click();
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(Driver.get().findElement(By.xpath("//div[@class=\"list-container\"]//a"))).click().build().perform();
        Driver.get().findElement(By.xpath("//div[@data-role=\"switch-currency\"]//a")).click();
//        Thread.sleep(10000);
        Driver.get().findElement(By.xpath("//div[@data-role=\"switch-currency\"]//a[contains(text() , 'US')]")).click();
        Driver.get().findElement(By.xpath("//div[@class=\"switcher-common\"]//button")).click();

    }

    public  void openCategoryPage2() throws InterruptedException {
        Thread.sleep(3000);
        WebElement allcategory = driver.findElement(CATEGORY_LOCATOR);
        allcategory.click();

    }


}
