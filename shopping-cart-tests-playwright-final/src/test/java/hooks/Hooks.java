package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import utils.PlaywrightFactory;

public class Hooks {
    @Before
    public void beforeScenario() {
        PlaywrightFactory.getPage();
    }

    @After
    public void afterScenario() {
        PlaywrightFactory.close();
    }
}