package ui;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailsResultPage {
    @FindBy(xpath = "//ul[@id=\"j-sku-list-2\"]/li[2]/a/span")
    public static WebElement model_size_GB;

    @FindBy(xpath = "//ul[@id=\"j-sku-list-3\"]/li[1]/a")
    public static WebElement color_model;

    @FindBy(id = "id=j-add-cart-btn")
    public static WebElement add_to_bascket;

    public void addItemToBascket()  {
        model_size_GB.click();
        color_model.click();
        add_to_bascket.click();
    }
}

