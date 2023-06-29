package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

/**
 * 
 * @author Suriyanarayanan
 * @see used to maintain the CancelBookingPage locator deatails
 * @Date 27/12/2022
 *
 */

public class CancelBookingPage extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	public CancelBookingPage() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	WebElement btnItinerary;

	@FindBy(name = "cancelall")
	WebElement btncancelall;

	@FindBy(xpath = "(//input[@type='button'])[1]")
	WebElement btncancelId;

	@FindBy(id = "order_id_text")
	WebElement textcancelOrderId;

	@FindBy(name = "search_hotel_id")
	WebElement btnGo;

	@FindBy(id = "search_result_error")
	WebElement textErrorCancelBookingMessage;

	public WebElement getBtnCancelId() {
		return btncancelId;
	}

	public WebElement getTextErrorCancelBookingMessage() {
		return textErrorCancelBookingMessage;
	}

	public WebElement getCancelall() {
		return btncancelall;
	}

	public WebElement getBtnItinerary() {
		return btnItinerary;
	}

	public WebElement getCancelOrderId() {
		return textcancelOrderId;
	}

	public WebElement getBtnGo() {
		return btnGo;
	}

	/**
	 * 
	 * @see used to maintain the cancelBookingOrderId implement parts
	 * @param orderid
	 */
	
	public void cancelBookingOrderId(String orderid) {

		click(getBtnItinerary());
		insertValue(getCancelOrderId(), orderid);
		click(getBtnGo());
		click(btncancelId);
		alert().accept();

	}
	
	/**
	 * 
	 * @see used to maintain the cancelExixtingOrderId implement parts
	 * @param orderId
	 */

	public void cancelExixtingOrderId(String orderId) {

		click(getBtnItinerary());
		insertValue(getCancelOrderId(), orderId);
		click(getBtnGo());
		click(btncancelId);
		alert().accept();

	}

}
