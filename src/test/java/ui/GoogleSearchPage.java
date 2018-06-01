package ui;


import core.Driver;
import org.apache.log4j.Logger;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage extends BasePage{
    public static String baseURL = "https://google.com";
    Logger log = Logger.getLogger(GoogleSearchPage.class);

    //    @Before
//    public void setUp() {
//
//        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
//       driver = new ChromeDriver();
//
//    }
    public static String AUTOMATION = "Automation";
    @FindBy(xpath = "//input[@name='q']")
    WebElement textField;

    @FindBy(xpath = "//*[@id=\"rso\"]/div/div/div[1]/div/div/h3/a")
    WebElement SearchFieldButton;


    public void OpenPage() {
//        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
//        driver = new ChromeDriver();
        Driver.get().get(System.getProperty("test.baseURL"));
        log.info("Open Google page ");

    }

    public void SearchByText() {
        PageFactory.initElements(Driver.get(), this);
        textField.sendKeys(System.getProperty("test.wordfinder"));
        // driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation");
        textField.sendKeys(Keys.ENTER);
        log.info("Enter:  " + System.getProperty("test.wordfinder"));
    }

    public void ButtonClick() {
        SearchFieldButton.click();
        log.info("Push button 'to next page'");

    }

}


