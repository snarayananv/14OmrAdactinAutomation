package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

/**
 * 
 * @author Suriyanarayanan
 * @see used to maintain the SearchHotelPage implement parts
 * @Date 27/12/2022
 *
 */
public class SearchHotelPage extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * 
	 * @see used to maintain the SearchHotelPage locaters deatails
	 * 
	 */
	public SearchHotelPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	WebElement ddLocation;

	@FindBy(id = "hotels")
	WebElement ddHotels;

	@FindBy(id = "room_type")
	WebElement ddRoom;

	@FindBy(id = "room_nos")
	WebElement ddRoomsNo;

	@FindBy(id = "datepick_in")
	WebElement txtCheckin;

	@FindBy(id = "datepick_out")
	WebElement txtCheckout;

	@FindBy(id = "adult_room")
	WebElement ddAduld;

	@FindBy(id = "child_room")
	WebElement ddChild;

	@FindBy(id = "Submit")
	WebElement ddSubmit;

	@FindBy(id = "username_show")
	WebElement textLoginMessage;

	@FindBy(id = "checkin_span")
	WebElement textInvalidCheckIn;

	@FindBy(id = "checkout_span")
	WebElement textInvalidCheckOut;

	@FindBy(id = "location_span")
	WebElement textSelectLocationErrorMessage;

	@FindBy(xpath = "//td[text()='Select Hotel ']")
	WebElement textSearchHotelMessage;

	public WebElement getTextSearchHotelMessage() {
		return textSearchHotelMessage;
	}

	public WebElement getTxtSelectLocationErrorMessage() {
		return textSelectLocationErrorMessage;
	}

	public WebElement getTextLoginMessage() {
		return textLoginMessage;
	}

	public WebElement getDdLocation() {
		return ddLocation;
	}

	public WebElement getDdHotels() {
		return ddHotels;
	}

	public WebElement getDdRoom() {
		return ddRoom;
	}

	public WebElement getDdRoomsNo() {
		return ddRoomsNo;
	}

	public WebElement getTextDdCheckin() {
		return txtCheckin;
	}

	public WebElement getTextDdCheckout() {
		return txtCheckout;
	}

	public WebElement getDdAduld() {
		return ddAduld;
	}

	public WebElement getDdChild() {
		return ddChild;
	}

	public WebElement getDdSubmit() {
		return ddSubmit;
	}

	public WebElement getTextInvalidCheckIn() {
		return textInvalidCheckIn;
	}

	public WebElement getTextInvalidCheckOut() {
		return textInvalidCheckOut;
	}

	/**
	 * 
	 * @see used to maintain the searchHotelPage commonsteps implement parts
	 * @param location
	 * @param noOfRooms
	 * @param dateCheckIn
	 * @param dateCheckOut
	 * @param adultsPerRoom
	 */

	public void searchHotelCommonSteps(String location, String noOfRooms, String dateCheckIn, String dateCheckOut,
			String adultsPerRoom) {

		selectOptionByText(getDdLocation(), location);
		selectOptionByText(getDdRoomsNo(), noOfRooms);
		insertValue(getTextDdCheckin(), dateCheckIn);
		insertValue(getTextDdCheckout(), dateCheckOut);
		selectOptionByText(getDdAduld(), adultsPerRoom);

	}

	/**
	 * 
	 * @see used to maintain the submit of the page
	 * 
	 */

	public void search() {
		click(ddSubmit);

	}

	/**
	 *
	 * @see used to maintain the searchhotel implement parts 
	 * @param location
	 * @param hotels
	 * @param roomtype
	 * @param noOfRooms
	 * @param dateCheckIn
	 * @param dateCheckOut
	 * @param adultsPerRoom
	 * @param childPerRoom
	 */

	public void searchHotel(String location, String hotels, String roomtype, String noOfRooms, String dateCheckIn,
			String dateCheckOut, String adultsPerRoom, String childPerRoom) {
		searchHotelCommonSteps(location, noOfRooms, dateCheckIn, dateCheckOut, adultsPerRoom);
		selectOptionByText(getDdHotels(), hotels);
		selectOptionByText(getDdRoom(), roomtype);
		selectOptionByText(getDdChild(), childPerRoom);
		search();

	}

	/**
	 * @see used to maintain the searchHotelManadoryFields implement parts
	 * @param location
	 * @param noOfRooms
	 * @param dateCheckIn
	 * @param dateCheckOut
	 * @param adultsPerRoom
	 */

	public void searchHotelManadoryFields(String location, String noOfRooms, String dateCheckIn, String dateCheckOut,
			String adultsPerRoom) {

		searchHotelCommonSteps(location, noOfRooms, dateCheckIn, dateCheckOut, adultsPerRoom);
		search();

	}

	/**
	 * 
	 * @see used to maintain the searchHotelInvalidCheckindate 
	 * @param location
	 * @param hotels
	 * @param roomType
	 * @param noOfRooms
	 * @param dateCheckIn
	 * @param dateCheckOut
	 * @param adultsPerRoom
	 * @param childPerRoom
	 */

	public void searchHotelInvalidCheckindate(String location, String hotels, String roomType, String noOfRooms,
			String dateCheckIn, String dateCheckOut, String adultsPerRoom, String childPerRoom) {

		searchHotelCommonSteps(location, noOfRooms, dateCheckIn, dateCheckOut, adultsPerRoom);
		selectOptionByText(getDdHotels(), hotels);
		selectOptionByText(getDdRoom(), roomType);
		selectOptionByText(getDdChild(), childPerRoom);
		search();

	}

	/**
	 * 
	 * @see used to maintain the searchbutton of the page 
	 * 
	 */

	public void searchHotelWithoutEnterAnyField() {

		search();

	}

}
