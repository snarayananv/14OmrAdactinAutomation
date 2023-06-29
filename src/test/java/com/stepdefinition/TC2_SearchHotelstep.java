package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author Suriyanarayanan
 * @see used to maintain the TC2_SearchHotelstep implement parts
 * @Date 27/12/2022
 *
 */

public class TC2_SearchHotelstep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * 
	 * @see user should enter all fields in search hotel
	 * @param location
	 * @param hotels
	 * @param roomType
	 * @param noOfRooms
	 * @param dateCheckIn
	 * @param dateCheckOut
	 * @param adultsPerRoom
	 * @param childPerRoom
	 * @throws InterruptedException
	 */

	@Then("User should enter all fields in search hotel {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldEnterAllFieldsInSearchHotelAnd(String location, String hotels, String roomType,
			String noOfRooms, String dateCheckIn, String dateCheckOut, String adultsPerRoom, String childPerRoom)
			throws InterruptedException {

		Thread.sleep(3000);
		pom.getSearchHotelPage().searchHotel(location, hotels, roomType, noOfRooms, dateCheckIn, dateCheckOut,
				adultsPerRoom, childPerRoom);

	}

	/**
	 * @see user should verify after search hotel success message
	 * @param string
	 */

	@Then("User should verify after search hotel success message {string}")
	public void userShouldVerifyAfterSearchHotelSuccessMessage(String expAfterSearchHotelSuccessMessage) {

		WebElement bookHotelmsg = pom.getSearchHotelPage().getTextSearchHotelMessage();
		String actAfterSearchHotelSuccessMessage = elementGetText(bookHotelmsg);
		Assert.assertEquals("Verified", expAfterSearchHotelSuccessMessage, actAfterSearchHotelSuccessMessage);
		HooksClass.sc.log("verify after SearchHotel success msg" + "exp.Value= " + expAfterSearchHotelSuccessMessage
				+ "act.Value= " + actAfterSearchHotelSuccessMessage);
	}

	/**
	 * 
	 * @see user should enter only mandatory fields
	 * @param location
	 * @param noOfRooms
	 * @param dateCheckIn
	 * @param dateCheckOut
	 * @param adultsPerRoom
	 * @throws InterruptedException
	 */

	@Then("User should enter only mandatory fields {string},{string},{string},{string} and {string}")
	public void userShouldEnterOnlyMandatoryFieldsAnd(String location, String noOfRooms, String dateCheckIn,
			String dateCheckOut, String adultsPerRoom) throws InterruptedException {
		Thread.sleep(3000);
		pom.getSearchHotelPage().searchHotelManadoryFields(location, noOfRooms, dateCheckIn, dateCheckOut,
				adultsPerRoom);

	}

	/**
	 * 
	 * @see user should search hotel
	 * @param location
	 * @param hotels
	 * @param roomType
	 * @param noOfRooms
	 * @param dateCheckIn
	 * @param dateCheckOut
	 * @param adultsPerRoom
	 * @param childPerRoom
	 * @throws InterruptedException
	 */

	@Then("User should search hotel {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldSearchHotelAnd(String location, String hotels, String roomType, String noOfRooms,
			String dateCheckIn, String dateCheckOut, String adultsPerRoom, String childPerRoom)
			throws InterruptedException {

		Thread.sleep(3000);

		pom.getSearchHotelPage().searchHotelInvalidCheckindate(location, hotels, roomType, noOfRooms, dateCheckIn,
				dateCheckOut, adultsPerRoom, childPerRoom);

	}

	/**
	 * 
	 * @see user should verify after search hotel with invalid date error message
	 *      contains
	 * @param dateCheckInInvalid
	 * @param dateCheckOutInvalid
	 */

	@Then("User should verify after search hotel with invalid date error message contains {string} and {string}")
	public void userShouldVerifyAfterSearchHotelWithInvalidDateErrorMessageContainsAnd(String expDateCheckInInvalid,
			String expDateCheckOutInvalid) {

		WebElement invalidCheckIn = pom.getSearchHotelPage().getTextInvalidCheckIn();
		String actDateCheckInInvalid = elementGetText(invalidCheckIn);
		Assert.assertEquals("Verified", expDateCheckInInvalid, actDateCheckInInvalid);
		HooksClass.sc.log("verify after DateCheckInInvalid success msg" + "exp.Value= " + expDateCheckInInvalid
				+ "act.Value= " + actDateCheckInInvalid);

		WebElement invalidCheckOut = pom.getSearchHotelPage().getTextInvalidCheckOut();
		String actDateCheckOutInvalid = elementGetText(invalidCheckOut);
		Assert.assertEquals("Verified", expDateCheckOutInvalid, actDateCheckOutInvalid);

		HooksClass.sc.log("verify after login success msg" + "exp.Value= " + expDateCheckOutInvalid + "act.Value= "
				+ actDateCheckOutInvalid);
	}

	/**
	 * @see user should search without enter any fields in search hotel page
	 */

	@Then("User should search without enter any fields in search hotel page")
	public void userShouldSearchWithoutEnterAnyFieldsInSearchHotelPage() {

		pom.getSearchHotelPage().searchHotelWithoutEnterAnyField();
	}

	/**
	 * 
	 * @see user should verify after search hotel with error message
	 * @param loctionErrorMsg
	 */

	@Then("User should verify after search hotel with error message {string}")
	public void userShouldVerifyAfterSearchHotelWithErrorMessage(String expLoctionErrorMsg) {

		WebElement selectLocationError = pom.getSearchHotelPage().getTxtSelectLocationErrorMessage();
		String actAfterSearchHotelWithErrorMessage = elementGetText(selectLocationError);
		Assert.assertEquals("Verified", expLoctionErrorMsg, actAfterSearchHotelWithErrorMessage);
		HooksClass.sc.log("verify after DateCheckOutInvalid success msg" + "exp.Value= " + expLoctionErrorMsg
				+ "act.Value= " + actAfterSearchHotelWithErrorMessage);

	}

}