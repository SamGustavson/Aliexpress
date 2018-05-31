package tests;
import com.sun.org.glassfish.gmbal.Description;
import core.Driver;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ui.*;


public class PageObjectTest extends BeforeAfter {
//    @Test
//    public void pageObjectTestGoogle1() {
//        GoogleSearchPage page = new GoogleSearchPage();
//        page.OpenPage();
//        page.SearchByText();
//        page.ButtonClick();
//        GoogleResultPage page2 = new GoogleResultPage();
//        Assert.assertTrue("Check if the header is set to <Automation>", page2.isTitlePresent());
//    }
//
//    @Test
//    public void PageObjectTestGoogle2() {
//        GoogleSearchPage page = new GoogleSearchPage();
//        GoogleResultPage page2 = new GoogleResultPage();
//        page.OpenPage();
//        page.SearchByText();
//        page2.CatchPages(System.getProperty("test.URLtoSearch"), 5);
//    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    @Description("check Sign In process")
    public void Test1() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.closeCoupon();
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.setCredentials(System.getProperty("test.login"), System.getProperty("test.password"));
        loginPage.moveSlider();
        Assert.assertTrue(loginPage.noCapture() || homePage.homePageisOpened());
    }

    @Test
    @Description("check Search box")
    public void Test2() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.closeCoupon();
        homePage.changeGoToGlobalSite();
        homePage.changeCurrency();
        SearchResultPage resultPage = homePage.openResultPage();
        resultPage.setMinPrice("50");
        resultPage.setMaxPrice("90");
        resultPage.setSortFromLowToHI();
        Assert.assertEquals("50.", resultPage.getFirstItemPrice());
        resultPage.setSortFromHiToLow();
        Assert.assertEquals("90.", resultPage.getFirstItemPrice());
    }

    @Test
    @Description("check adding and removing article to Cart")
    public void Test3() {
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.closeCoupon();
        SearchResultPage resultPage = homePage.setTextInSerchField("iPhone 7 128");
        ItemDetailsPage detailsResultPage = resultPage.openFirstItem();
        ShoppingCartPage shoppingCartPage = detailsResultPage.addItemToBasket();
        Assert.assertTrue(shoppingCartPage.getListItems().contains("iPhone 7"));
        shoppingCartPage.removeItemFromBasket();
        Assert.assertTrue(shoppingCartPage.getListItems() == null);
    }

    @Test
    @Description("changing Country shipping and Currency ")
    public void Test4() {
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.closeCoupon();
        homePage.changeGoToGlobalSite();
        homePage.changeCurrency();
        SearchResultPage resultPage = homePage.setTextInSerchField("iPhone 7 128");
        Assert.assertTrue(resultPage.getFirstItemText().contains("iPhone 7"));
    }
}
