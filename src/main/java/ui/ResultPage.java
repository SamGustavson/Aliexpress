package ui;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ui.BasePage;


public class ResultPage extends BasePage {
    private static Actions actions = new Actions(driver);

//    public static final By FILTER_MIN_PRICE_LOCATOR = By.id("filter-price-from");
//    public static final By FILTER_MAX_PRICE_LOCATOR = By.id("filter-price-to");
//    public static final By SORT_MENU_LOCATOR        = By.xpath("//div[@id=\"sortBySelect\"]/div");
//    public static final By LOW_TO_HIGH_MENU_LOCATOR = By.xpath("//a[@data-filter-type=\"price-desc\"]");
//    public static final By HIGH_TO_LOW_MENU_LOCATOR = By.xpath("//a[@data-filter-type=\"price-asc\" and contains (text(), 'High')]");
//    public static final By FIRST_RESULT_PRICE_LOCATOR = By.xpath("//span[@class=\"price price-m\"]");



    @FindBy(id= "filter-price-from")
    public WebElement minField ;

    @FindBy(how = How.ID, using = "filter-price-to" )
    public static WebElement maxField;

    @FindBy(how = How.XPATH, using = "//div[@id=\"sortBySelect\"]/div")
    public static WebElement sortElement;

    @FindBy(how = How.XPATH, using = "//a[@data-filter-type=\"price-desc\"]")
    public static WebElement low_toHigh;

    @FindBy(how = How.XPATH, using = "//a[@data-filter-type=\"price-asc\" and contains (text(), 'High')]")
    public static WebElement highToLow;

    @FindBy (how = How.XPATH, using = "//span[@class=\"price price-m\"]")
    public static WebElement firstItemPrice;


    public void setMinPrice() {
        minField.click();
        minField.sendKeys("50");
        minField.sendKeys(Keys.TAB);

    }

    public  void setMaxPrice() {
        maxField.sendKeys("90");
        maxField.sendKeys(Keys.ENTER);

    }

    public  void setSortFromLowToHI() {
        sortElement.click();
        actions.moveToElement(low_toHigh).click().build().perform();
    }

    public  void setSortFromHiToLow()  {
        sortElement.click();
//        Thread.sleep(500);
        actions.moveToElement(highToLow).click().build().perform();

    }

    public  String getFirstItemPrice() {
        String dol = firstItemPrice.getText();
        String[] part = dol.split("(?<=\\D)(?=\\d)");
        System.out.println(part[1]);
        return part[1];

    }


}
