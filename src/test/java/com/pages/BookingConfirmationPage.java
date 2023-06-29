package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Suriyanarayanan
 * @see used to maintain the BookingConfirmationPage locators deatails
 * @Date 27/12/2022
 *
 */

public class BookingConfirmationPage extends BaseClass {

	public BookingConfirmationPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "order_no")
	WebElement txtorderId;

	public WebElement getTxtOrderid() {
		return txtorderId;
	}

	/**
	 * 
	 * @see used to maintain the BookingConfirmationId implement parts
	 * @return
	 */

	public String bookingConfirmationId() {

		String attribute = elementGetAttribute(txtorderId, "value");
		return attribute;

	}

}
