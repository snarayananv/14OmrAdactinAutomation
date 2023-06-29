package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;
import io.cucumber.java.en.Then;

/**
 * 
 * @author Suriyanarayanan
 * @see used to maintain the LoginPage implement parts
 * @Date 27/12/2022
 *
 */

public class CommonStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * 
	 * @see used to maintain User should verify after login success message
	 *      implement parts
	 * @param expLoginSuccessMsg
	 * 
	 */

	@Then("User should verify after login success message {string}")

	public void userShouldVerifyAfterLoginSuccessMessage(String expLoginSuccessMsg) {

		WebElement txtLoginMsg = pom.getSearchHotelPage().getTextLoginMessage();
		String actLoginMsg = elementGetAttribute(txtLoginMsg, expLoginSuccessMsg);
		Assert.assertEquals("verify after login success msg", expLoginSuccessMsg, actLoginMsg);
		HooksClass.sc.log(
				"verify after login success msg" + "exp.Value= " + expLoginSuccessMsg + "act.Value= " + actLoginMsg);

	}

}
