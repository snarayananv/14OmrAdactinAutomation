package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

/**
 *
 * @author Suriyanarayanan
 * @Date 27/12/2022
 * @see used to maintain TC1_LoginStep implement parts
 *
 */
public class TC1_LoginStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * @see user on the Adactin page
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	@Given("User on the Adactin page")
	public void userOnTheAdactinPage() throws FileNotFoundException, IOException {

	}

	/**
	 * @see user should perform login
	 * @param username
	 * @param password
	 */

	@When("User should perform login {string} and {string}")
	public void userShouldPerformLoginAnd(String username, String password) {

		pom.getLoginPage().login(username, password);

	}

	/**
	 * 
	 * @see user should perform login with enter key
	 * @param username
	 * @param password
	 * @throws AWTException
	 */

	@When("User should perform login {string} and {string} with Enter key")
	public void userShouldPerformLoginAndWithEnterKey(String username, String password) throws AWTException {

		pom.getLoginPage().loginWithEnterKey(username, password);
	}

	/**
	 * 
	 * @see user should verify after login with invalid credential
	 * @param string
	 */
	@Then("User should verify after login with invalid credential error message contains {string}")
	public void userShouldVerifyAfterLoginWithInvalidCredentialErrorMessageContains(String expLoginErrorMsg) {

		WebElement txtError = pom.getLoginPage().getTextErrorLoginMessage();
		String elementGetText = elementGetText(txtError);

		Assert.assertEquals("Verified", expLoginErrorMsg, elementGetText);
		HooksClass.sc.log(
				"verify after login success msg" + "exp.Value= " + expLoginErrorMsg + "act.Value= " + elementGetText);

	}

}
