package pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class SearchResultPage extends BasePage {

    private static Actions actions = new Actions(driver);

    @FindBy(id= "filter-price-from")
    private WebElement minField ;

    @FindBy(how = How.ID, using = "filter-price-to" )
    private static WebElement maxField;

    @FindBy(how = How.XPATH, using = "//div[@id=\"sortBySelect\"]/div")
    private static WebElement sortElement;

    @FindBy(how = How.XPATH, using = "//a[@data-filter-type=\"price-desc\"]")
    private static WebElement low_toHigh;

    @FindBy(how = How.XPATH, using = "//a[@data-filter-type=\"price-asc\" and contains (text(), 'High')]")
    private static WebElement highToLow;

    @FindBy (how = How.XPATH, using = "//span[@class=\"price price-m\"]")
    private static WebElement firstItemPrice;

    @FindBy (how = How.XPATH, using = "//a[@class=\"history-item product \"]")
    private static WebElement itemTextFirstLink;

    @FindBy (xpath = "//ul[@class=\"util-clearfix son-list util-clearfix\"]/li[1]//a")
    private static WebElement openFirstLinkInResults;

    public void setMinPrice(String price_Min) {
        minField.click();
        minField.sendKeys(price_Min);
        minField.sendKeys(Keys.TAB);
    }

    public  void setMaxPrice(String price_Max) {
        maxField.sendKeys(price_Max);
        maxField.sendKeys(Keys.ENTER);
    }

    public  void setSortFromLowToHI() {
        sortElement.click();
        actions.moveToElement(low_toHigh).click().build().perform();
    }

    public  void setSortFromHiToLow()  {
        sortElement.click();
        actions.moveToElement(highToLow).click().build().perform();
    }

    public  String getFirstItemPrice() {
        String dol = firstItemPrice.getText();
        String[] part = dol.split("(?<=\\D)(?=\\d)");
        System.out.println(part[1]);
        return part[1];
    }

    public String getFirstItemText(){
        itemTextFirstLink.getText();
        System.out.print(itemTextFirstLink.getText());
        return itemTextFirstLink.getText();
    }

    public ItemDetailsPage openFirstItem(){
        openFirstLinkInResults.click();
        return new ItemDetailsPage();
    }
}
