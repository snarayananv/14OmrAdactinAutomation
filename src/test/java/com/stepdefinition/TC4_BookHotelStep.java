package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.*;

/**
 * 
 * @author Suriyanarayanan
 * @see used to maintain the TC4_BookHotelStep excution parts
 * @Date 27/12/2022
 *
 */

public class TC4_BookHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * 
	 * @see User should enter BookHotel deatails
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param dataTable
	 * @throws InterruptedException
	 */

	@Then("User should enter {string},{string} and {string}")
	public void userShouldEnterAnd(String firstName, String lastName, String address,
			io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

		List<Map<String, String>> emp = dataTable.asMaps();
		Map<String, String> map = emp.get(1);
		String ccNumber = map.get("ccNumber");
		String ccType = map.get("ccType");
		String expMonth = map.get("expMonth");
		String expYear = map.get("expYear");
		String cVV = map.get("cVV");

		pom.getBookHotelPage().bookHotelEnterAllFields(firstName, lastName, address, ccNumber, ccType, expMonth,
				expYear, cVV);

	}

	/**
	 * 
	 * @see User should verify Booking success message
	 * @param expect
	 */

	@Then("User should verify Booking success message {string} and save the generated order id")
	public void userShouldVerifyBookingSuccessMessageAndSaveTheGeneratedOrderId(String extVerifyBookingSuccessMessage) {

		WebElement bookingCofirm = pom.getBookHotelPage().getTextbookingCofirmMessage();
		String actVerifyBookingSuccessMessage = elementGetText(bookingCofirm);
		Assert.assertEquals("Verified", extVerifyBookingSuccessMessage, actVerifyBookingSuccessMessage);
		HooksClass.sc.log("Verified" + "exp.Value= " + extVerifyBookingSuccessMessage + "act.Value= "
				+ actVerifyBookingSuccessMessage);

	}

	/**
	 * 
	 * @see User should click book without entering any details
	 * 
	 */

	@Then("User should click book without entering any details")
	public void userShouldClickBookWithoutEnteringAnyDetails() {

		pom.getBookHotelPage().bookHotelWithoutEnterAnyFields();

	}

	/**
	 * 
	 * @see User should verify after Book hotel with seven error messages
	 * @param first
	 * @param last
	 * @param address
	 * @param card
	 * @param type
	 * @param expiry
	 * @param error
	 */

	@Then("User should verify after Book hotel with seven error messages {string}, {string},{string},{string},{string}, {string} and {string}")
	public void userShouldVerifyAfterBookHotelWithSevenErrorMessagesAnd(String expFirstNameErrorMsg,
			String expLastNameErrorMsg, String expAddressErrorMsg, String expCardNumErrorMsg,
			String expCardTypeErrorMsg, String expExpiryDateMsg, String expCvvErrorMsg) {

		WebElement txtFirst = pom.getBookHotelPage().getTextFirstErrorMessage();
		String actFirstNameError = elementGetText(txtFirst);
		Assert.assertEquals("Verified", expFirstNameErrorMsg, actFirstNameError);
		HooksClass.sc.log("Verified" + "exp.Value= " + expFirstNameErrorMsg + "act.Value= " + actFirstNameError);

		WebElement lastError = pom.getBookHotelPage().getTextLastErrorMessage();
		String actLastNameErrorMsg = elementGetText(lastError);
		Assert.assertEquals("Verified", expLastNameErrorMsg, actLastNameErrorMsg);
		HooksClass.sc.log("Verified" + "exp.Value= " + expLastNameErrorMsg + "act.Value= " + actLastNameErrorMsg);

		WebElement addressError = pom.getBookHotelPage().getTextAddressErrorMeaasage();
		String actAddressErrorMsg = elementGetText(addressError);
		Assert.assertEquals("Verified", expAddressErrorMsg, actAddressErrorMsg);
		HooksClass.sc.log("Verified" + "exp.Value= " + expAddressErrorMsg + "act.Value= " + actAddressErrorMsg);

		WebElement ddCcNum = pom.getBookHotelPage().getTextNumErrorMessage();
		String actCardNumErrorMsg = elementGetText(ddCcNum);
		Assert.assertEquals("Verified", expCardNumErrorMsg, actCardNumErrorMsg);
		HooksClass.sc.log("Verified" + "exp.Value= " + expCardNumErrorMsg + "act.Value= " + actCardNumErrorMsg);

		WebElement tpyeError = pom.getBookHotelPage().getTextTypeErrorMessage();
		String actCardTypeErrorMsg = elementGetText(tpyeError);
		Assert.assertEquals("Verified", expCardTypeErrorMsg, actCardTypeErrorMsg);
		HooksClass.sc.log("Verified" + "exp.Value= " + expCardTypeErrorMsg + "act.Value= " + actCardTypeErrorMsg);

		WebElement expiryError = pom.getBookHotelPage().getTextExpiryErrorMessage();
		String actExpiryDateMsg = elementGetText(expiryError);
		Assert.assertEquals("Verified", expExpiryDateMsg, actExpiryDateMsg);
		HooksClass.sc.log("Verified" + "exp.Value= " + expExpiryDateMsg + "act.Value= " + actExpiryDateMsg);

		WebElement cvvError = pom.getBookHotelPage().getTextCvvErrorMessage();
		String actCvvErrorMsg = elementGetText(cvvError);
		Assert.assertEquals("Verified", expCvvErrorMsg, actCvvErrorMsg);
		HooksClass.sc.log("Verified" + "exp.Value= " + expCvvErrorMsg + "act.Value= " + actCvvErrorMsg);

	}

}
