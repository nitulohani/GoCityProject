package frontendTest.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import frontendTest.util.DriverClass;

public class Hooks extends DriverClass {

    @Before
    public void setUp() {

        setup();
    }

    @After
    public void tearDown() {

       // closeDriver();
    }
}
