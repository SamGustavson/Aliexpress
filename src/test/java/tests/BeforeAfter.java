package tests;

import core.Driver;
import core.Parallelized;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.LinkedList;

// will be used in BDD


public class BeforeAfter {
        @Before
        public void setUp() throws Exception {
            Driver.init();
        }

        @After
        public void tearDown() {
            Driver.tearDown();
        }
}






