package steps;

import io.cucumber.java.After;
import utilities.Driver;

public class Hooks {
    @After
    public void close(){
        Driver.closeDriver();
    }
}
