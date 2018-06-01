package tests;

import core.Driver;
import org.junit.After;
import org.junit.Before;


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






