package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import com.base.BaseClass;
import com.pagemanager.PageObjectManager;
import io.cucumber.java.en.Then;

/**
 * 
 * @author Suriyanarayanan
 * @see used to maintain the TC3_SelectHotelStep implement parts
 * @Date 27/12/2022
 *
 */

public class TC3_SelectHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * 
	 * @see User should click Continue select hotel
	 * 
	 */

	@Then("User should click Continue select hotel")
	public void userShouldClickContinueSelectHotel() {
		pom.getSelectHotelPage().hotelPageAllFieldsClick();

	}

	/**
	 * 
	 * @see User should verify select hotel success message
	 * 
	 */

	@Then("User should verify select hotel success message {string}")
	public void userShouldVerifySelectHotelSuccessMessage(String expSelectHotelSuccessMsg) {

		WebElement bookHotelSuccess = pom.getSelectHotelPage().getTextBookHotelMessage();
		String actSelectHotelSuccessMsg = elementGetText(bookHotelSuccess);
		Assert.assertEquals("Verified", expSelectHotelSuccessMsg, actSelectHotelSuccessMsg);
		HooksClass.sc.log("Verified" + "exp.Value= " + expSelectHotelSuccessMsg
				+ "act.Value= " + actSelectHotelSuccessMsg);
	}

	/**
	 * 
	 * @see User should Click Continue without Select Hotel
	 * 
	 */

	@Then("User should Click Continue without Select Hotel")
	public void userShouldClickContinueWithoutSelectHotel() {

		pom.getSelectHotelPage().hotelPageWithOutEnterAllfieldsClick();
	}

	/**
	 * 
	 * @see User should verify after Select Hotel with error message
	 * @param selectHotelPageError
	 */

	@Then("User should verify after Select Hotel with error message {string}")
	public void userShouldVerifyAfterSelectHotelWithErrorMessage(String expselectHotelPageErrorMsg) {

		WebElement selectHotelError = pom.getSelectHotelPage().getTextErrorSelectHotelMessage();
		String actSelectHotelPageErrorMsg = elementGetText(selectHotelError);
		Assert.assertEquals("Verified", expselectHotelPageErrorMsg, actSelectHotelPageErrorMsg);
		HooksClass.sc.log("Verified" + "exp.Value= " + expselectHotelPageErrorMsg
				+ "act.Value= " + actSelectHotelPageErrorMsg);
	}

}
