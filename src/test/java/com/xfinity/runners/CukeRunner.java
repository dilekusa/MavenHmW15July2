package com.xfinity.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/features",

		glue = "com/xfinity/step_definitions",

		tags = "@HerokupDynamicLoading")
public class CukeRunner {

}
// ./src/test/java
// features = {"classpath:features_folder1"
/// MavenHmW15July/src/test/java/com/xfinity/step_definitions/HeroDynamicLoading.java