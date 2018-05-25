package core;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;



public class BeforeAfter {

    //  public static WebDriver driver;

    @Before
    public void setUp () {
        Driver.init();
    }

    @After
    public void tearDown() {
//        Driver.get().close();
    }
}






