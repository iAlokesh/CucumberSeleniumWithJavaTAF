package com.pwc.util;

import java.io.IOException;

import com.pwc.stepdefs.BaseTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {
	
	BaseTest bt;
	
	public Hooks(BaseTest bt) {
		
		this.bt = bt;
	}
	
	@Before
	public void setUp() throws InterruptedException, IOException {
		
		bt.pdr = new PropertiesDataReader();
		bt.driver = ReusableLibraries.launchBrowser(bt.pdr.getPropertyvalue("URL"));
	}
	
	@After
    public void tearDown(Scenario scenario){

        if(scenario.isFailed()) {
        	
        	System.out.println("Test has been failed - "+scenario.getName());
            scenario.attach(ReusableLibraries.takeScreenshot(bt.driver), "image/png", scenario.getName());
            driver.quit();
        }
    }
}
