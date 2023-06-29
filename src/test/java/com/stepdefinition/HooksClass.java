package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * 
 * @author Suriyanarayanan
 * @see used to maintain the LoginPage implement parts
 * @Date 27/12/2022
 *
 */

public class HooksClass extends BaseClass {

	/**
	 * 
	 * @see used to maintain the beforeScenario implement parts
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	static Scenario sc;

	@Before

	public void beforeScenario(Scenario scenario) throws FileNotFoundException, IOException {

		getDriver(getPropertieFileValue("browser"));
		loadUrl(getPropertieFileValue("url"));
		maximizeWindow();
		implicitWaits(20);
		sc = scenario;

	}

	/**
	 * 
	 * @see used to maintain the afterScenario implement parts
	 * @param scenario
	 */

	@After

	public void afterScenario(Scenario scenario) {

		scenario.attach(screenshot(), "images/png", "Every Scenario");

		quitWindow();

	}

}
