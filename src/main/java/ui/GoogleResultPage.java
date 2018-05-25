package ui;
import core.BeforeAfter;
import core.Driver;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleResultPage extends BeforeAfter {
    public static final String URLs = "//div[@class='f kv _SWb']/cite";
    Logger log = Logger.getLogger(GoogleSearchPage.class);


    public boolean isTitlePresent() {
       boolean titleVer =   Driver.get().getTitle().contains(System.getProperty("test.wordfinder"));
        log.info("Checking if present: " + System.getProperty("test.wordfinder"));
        return titleVer;
    }

    public boolean CatchLinks(String URLtoSearch) {

        List<WebElement> ElementCollection = Driver.get().findElements(By.xpath(URLs));

        //List<WebElement> ElementCollection = driver.findElements(By.xpath(URLs));

        for (int y = 0; y < ElementCollection.size(); y++) {
            WebElement URL = ElementCollection.get(y);
            String URLText = URL.getText();


            //  System.out.println(URLText);

            if (URLText.equals(URLtoSearch)) {
                System.out.println("This is our link: " + URLText);
                return true;
            }
        }
        return false;
    }


    public void CatchPages (String URLtoSearch,int PageNum){
//    driver.findElement(By.xpath("//a[@class ='pn'][@id='pnnext']")).click();


        for (int x = 0; x < PageNum; x++) {


            boolean result = CatchLinks(URLtoSearch);

            if (!result && x == PageNum - 1) {
                Assert.fail("Our link is absent");
            }
            if (result) {
                break;
            }
            Driver.get().findElement(By.xpath("//td/a[@class='pn'][@id='pnnext']")).click();
            log.info("Looking for an url : " + System.getProperty("test.URLtoSearch")+ "  by page." );



        }
    }


}
