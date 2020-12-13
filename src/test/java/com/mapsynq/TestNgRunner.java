package com.mapsynq;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin={"html:target/cucumber-html-report",
        "json:target/cucumber.json",
        "pretty:target/cucumber-pretty.txt",
        "junit:target/cucumber-results.xml"},
        features="C:\\Users\\Asit\\IdeaProjects\\QuantumInventionMapsynq\\src\\test\\resources\\Features")
public class TestNgRunner extends AbstractTestNGCucumberTests {
}
