package org.opencart;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("org/opencart")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, json:target/cucumber.json, html:target/cucumber-html-report.html")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.opencart")
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "classpath:org/opencart")
public class TestRunner {
}