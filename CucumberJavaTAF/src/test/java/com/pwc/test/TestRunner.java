package com.pwc.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features/nftmall.feature", 
		glue = { "com.pwc.stepdefs","com.pwc.util" },
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		publish=true
		//tags="@create and @buy"
		)

public class TestRunner {
	
}
