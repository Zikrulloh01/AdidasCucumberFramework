package com.demoblaze.step_definitions;


import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.After;

public class Hooks {



    @After
    public void tearDown(){
        BrowserUtils.waitFor(5);
        Driver.closeDriver();
    }

}
