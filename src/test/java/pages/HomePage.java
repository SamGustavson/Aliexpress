package pages;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

    private Actions actions = new Actions(driver);
    @FindBy(xpath = "//div[@class='pages-window-content']/a")
    private WebElement popUpWindow;
    @FindBy(xpath = "//div[@class=\"pages-mask\"]")
    private WebElement backgroundWeblelement;
    @FindBy(xpath = "//div[@class=\"ng-item ng-goto-globalsite\"]/a")
    private WebElement changeLanguage;
    @FindBy(xpath = "//div[@class=\"categories-content-title\"]//a")
    private WebElement categoryElement;
    @FindBy(xpath = "//span[@class=\"account-unsigned\"]/a[@data-role='sign-link']")
    private WebElement sign_in_button;
    @FindBy(xpath = "//a[@class='sign-btn']")
    private WebElement sign_in_button_2;
    @FindBy(xpath = "//div[@class=\"categories\"]/div")
    private WebElement allcategory;
    @FindBy(xpath = "//a[@id=\"switcher-info\"]/span")
    private WebElement switcherMenu;
    @FindBy(xpath = "//div[@class=\"list-title fold\"]/span")
    private WebElement listTitleFold;
    @FindBy(xpath = "//div[@class=\"list-container\"]//a")
    private WebElement listContainer;
    @FindBy(xpath = "//div[@data-role=\"switch-currency\"]//a")
    private WebElement switchCurrency;
    @FindBy(xpath = "//div[@data-role=\"switch-currency\"]//a[contains(text() , 'US')]")
    private WebElement switchCurrencyText;
    @FindBy(xpath = "//div[@class=\"switcher-common\"]//button")
    private WebElement switcherMenuCcommon;
    @FindBy(xpath = "//a[contains(text(), 'Men') and contains(text(), \"Backpacks\")]")
    private WebElement mensLuggage;
    @FindBy(xpath = "//dl[@class=\"cl-item cl-item-shoes\"]//a")
    private WebElement bagsAndShoes;
    private static By POPUP_WINDOW = By.xpath("//div[@class='pages-window-content']/a");
    @FindBy(how = How.XPATH, using = "//div[@class=\"search-key-box\"]/input")
    private static WebElement searchField;

    public HomePage navigateToHomePage() {
        driver.get(System.getProperty("test.aliURL"));
        return this;
    }

    public HomePage closeCoupon() {
        popUpWindow.click();
        BasePage.waitForElementNotVisible(backgroundWeblelement, 3);
        return this;
    }

    public HomePage changeGoToGlobalSite() {
        changeLanguage.click();
        return this;
    }

    public LoginPage openLoginPage() {
        BasePage.waitForElementVisible(categoryElement, 3);
        actions.moveToElement(sign_in_button).build().perform();
        BasePage.waitForElementVisible(sign_in_button_2, 3);
        sign_in_button.click();
        return new LoginPage();
    }

    public boolean homePageisOpened() {
        BasePage.waitForElementVisible(backgroundWeblelement, 3);
        return BasePage.isElementPresent(POPUP_WINDOW);
    }

    public SearchResultPage openResultPage()  {
        BasePage.waitForElementVisible(categoryElement, 3);
        actions.moveToElement(allcategory).build().perform();
        BasePage.waitForElementVisible(bagsAndShoes, 3);
        actions.moveToElement(bagsAndShoes).build().perform();
        BasePage.waitForElementVisible(mensLuggage, 3);
        actions.moveToElement(mensLuggage).build().perform();
        mensLuggage.click();
        return new SearchResultPage();
    }

    public HomePage changeCurrency() {
        switcherMenu.click();
        listTitleFold.click();
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(listContainer).click().build().perform();
        switchCurrency.click();
        switchCurrencyText.click();
        switcherMenuCcommon.click();
        return this;
    }

    public SearchResultPage setTextInSerchField(String search_parameter) {
        searchField.click();
        searchField.sendKeys(search_parameter);
        searchField.sendKeys(Keys.ENTER);
        return new SearchResultPage();
    }
}
