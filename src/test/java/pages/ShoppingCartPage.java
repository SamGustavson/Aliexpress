package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShoppingCartPage extends BasePage{
    @FindBy(xpath = "//tr[@class='item-product']")
    private WebElement items ;
    @FindBy(xpath = "//div[@class=\"product-remove\"]//a")
    private WebElement removeButton;
    @FindBy(xpath = "//div[@id=\"notice\"]")
    private WebElement emptyBasket;
    private By iTems = By.xpath("//tr[@class='item-product']//dd/a");

    public String getListItems() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        List<WebElement>elementList = driver.findElements(iTems);
        String text = null;
        for(WebElement el: elementList) {
            text += el.getText();
        }
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(System.getProperty("test.timeout")), TimeUnit.SECONDS);
        return text;
    }

    public void removeItemFromBasket(){
        removeButton.click();
    }
}
