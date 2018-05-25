package ui;

import core.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected static WebDriver driver ;

    public BasePage() {
        driver = Driver.get();
        PageFactory.initElements(driver, this);
    }

}


