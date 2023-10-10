package com.runner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.Baseclass.Baseclass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\featurefile\\Limeroad.feature", glue = "com\\stepdefinition",
				 dryRun = false, 
				 tags = "@demotest",
				 plugin = {"pretty",
						 "json:Reports/json-report.json",
						 "html:Reports/html-report.html",
						 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class Runner extends Baseclass {

	@BeforeClass
	public static void browser() {
		BrowserLaunch("chrome");
		Launch_url("https://www.limeroad.com/");
	}	
}

