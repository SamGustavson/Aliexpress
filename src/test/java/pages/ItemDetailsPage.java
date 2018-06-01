package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;

public class ItemDetailsPage extends BasePage{
    @FindBy(xpath = "//ul[@id=\"j-sku-list-2\"]/li[2]/a/span")
    private static WebElement model_size_GB;

    @FindBy(xpath = "//ul[@id=\"j-sku-list-3\"]/li[1]/a")
    private static WebElement color_model;

    @FindBy(id = "j-add-cart-btn")
    private static WebElement add_to_basket;

    @FindBy(xpath = "//div[@class=\"pages-window-bd\"]//a")
    private static WebElement go_to_basket;

    public ShoppingCartPage addItemToBasket()  {
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        BasePage.waitForElementVisible(model_size_GB,10);
        model_size_GB.click();
        color_model.click();
        add_to_basket.click();
        BasePage.waitForElementClickable(go_to_basket,4);
        go_to_basket.click();
        return new ShoppingCartPage();
    }
}

