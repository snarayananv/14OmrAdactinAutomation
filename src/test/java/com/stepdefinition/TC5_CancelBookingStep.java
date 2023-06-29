package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author Suriyanarayanan
 * @see used to maintain the TC5_CancelBookingStep implement parts
 * @Date 27/12/2022
 *
 */

public class TC5_CancelBookingStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * 
	 * @see used to maintain the User should cancel generated order Id implement
	 *      parts
	 * 
	 */

	@Then("User should cancel generated order Id")
	public void userShouldCancelGeneratedOrderId() {

		String orderid = pom.getBookingConfirmationPage().bookingConfirmationId();
		pom.getCancelBookingPage().cancelBookingOrderId(orderid);

	}

	/**
	 * 
	 * @see used to maintain the User should verify after cancelling order Id
	 *      success message implement parts
	 * @param string
	 */

	@Then("User should verify after cancelling order Id success message {string}")
	public void userShouldVerifyAfterCancellingOrderIdSuccessMessage(String expVerifyAfterCancellingOrderIdSuccessMsg) {

		WebElement errorMsg = pom.getCancelBookingPage().getTextErrorCancelBookingMessage();
		String actVerifyAfterCancellingOrderIdSuccessMsg = elementGetText(errorMsg);
		Assert.assertEquals("Verified", expVerifyAfterCancellingOrderIdSuccessMsg, actVerifyAfterCancellingOrderIdSuccessMsg);
		HooksClass.sc.log("Verified" + "exp.Value= " + expVerifyAfterCancellingOrderIdSuccessMsg
				+ "act.Value= " + actVerifyAfterCancellingOrderIdSuccessMsg);

	}

	/**
	 * 
	 * @see used to maintain the User should cancel the existing order Id implement parts
	 * @param orderId
	 * 
	 */

	@Then("User should cancel the existing order Id {string}")
	public void userShouldCancelTheExistingOrderId(String orderId) {

		pom.getCancelBookingPage().cancelExixtingOrderId(orderId);

	}

}