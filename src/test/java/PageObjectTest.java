import core.BeforeAfter;

import core.Driver;
import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import ui.*;






public class PageObjectTest extends BeforeAfter {



    @Test
    public void pageObjectTestGoogle1() {

        GoogleSearchPage page = new GoogleSearchPage();
        page.OpenPage();
        page.SearchByText();
        page.ButtonClick();
        GoogleResultPage page2 = new GoogleResultPage();
        Assert.assertTrue("Check if the header is set to <Automation>", page2.isTitlePresent());

    }



    @Test
    public void PageObjectTestGoogle2() {

        GoogleSearchPage page = new GoogleSearchPage();
        GoogleResultPage page2 = new GoogleResultPage();

        page.OpenPage();
        page.SearchByText();
        page2.CatchPages(System.getProperty("test.URLtoSearch"), 5);


    }


    @Test
    public void Test1() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.closeCoupon();
        homePage.openLoginPage();
        LoginPage loginPage = new LoginPage();
        loginPage.setCredentials(System.getProperty("test.login"), System.getProperty("test.password"));
        loginPage.moveSlider();
        Assert.assertTrue(loginPage.noCapture() || homePage.homePageisOpened());

    }

    @Test
    public void Test2() throws InterruptedException{
        HomePage homePage = new HomePage();
        ResultPage resultPage = new ResultPage();
        homePage.navigateToHomePage();
        homePage.closeCoupon();
        homePage.changeGoToGlobalSite();
        homePage.changeCurrency();
        homePage.openCategoryPage();
        resultPage.setMinPrice();
        resultPage.setMaxPrice();
        resultPage.setSortFromLowToHI();
        Assert.assertEquals("50.", resultPage.getFirstItemPrice());
        resultPage.setSortFromHiToLow();
        Assert.assertEquals("90.", resultPage.getFirstItemPrice());
    }


    @Test
    public void Test3(){
        HomePage homePage = new HomePage();
        ResultPage resultPage = new ResultPage();
        DetailsResultPage detailsResultPage = new DetailsResultPage();
        homePage.navigateToHomePage();
        homePage.closeCoupon();
        homePage.setTextInSerchField();
        resultPage.openFirstItem();
        detailsResultPage.addItemToBascket();








    }



    @Test
    public  void Test4() {
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.closeCoupon();
        homePage.changeGoToGlobalSite();
        homePage.changeCurrency();
        homePage.setTextInSerchField();
        ResultPage resultPage = new ResultPage();
        Assert.assertTrue(resultPage.getFirstItemPrice().contains("iPhone 7") && resultPage.getFirstItemPrice().contains("128"));









    }
}
