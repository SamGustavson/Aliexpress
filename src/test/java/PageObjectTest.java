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
        homePage.navigateToHomePage();
        homePage.closeCoupon();
        homePage.changeGoToGlobalSite();
        homePage.changeCurrency();
        homePage.openCategoryPage();
        ResultPage resultPage = new ResultPage();
        resultPage.setMinPrice();
        resultPage.setMaxPrice();
        resultPage.setSortFromLowToHI();
        Assert.assertEquals("50.", resultPage.getFirstItemPrice());
        resultPage.setSortFromHiToLow();
        Assert.assertEquals("90.", resultPage.getFirstItemPrice());
    }
    @Test
    public void Test3(){

    }



    @Test
    public  void Test4() {
        HomePage homePage = new HomePage();

        homePage.navigateToHomePage();
        homePage.closeCoupon();
        homePage.changeGoToGlobalSite();
        homePage.changeCurrency();
        WebElement searchFild = Driver.get().findElement(By.xpath("//div[@class=\"search-key-box\"]/input"));
        searchFild.click();
        searchFild.sendKeys("iPhone 7 128");
        searchFild.sendKeys(Keys.ENTER);
        WebElement item = Driver.get().findElement(By.xpath("//a[@class=\"history-item product \"]"));
        item.getText();
        System.out.print(item.getText());
        Assert.assertTrue(item.getText().contains("iPhone 7") && item.getText().contains("128"));









    }
}
