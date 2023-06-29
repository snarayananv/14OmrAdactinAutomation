package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Suriyanarayanan
 * @see used to maintain the BookHotelPage implement parts
 * @Date 27/12/2022
 *
 */

public class BookHotelPage extends BaseClass {

	/**
	 * 
	 * @see user should maintain bookhotelpage locator deatails
	 * 
	 */

	public BookHotelPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first_name")
	WebElement txtFirst;

	@FindBy(id = "last_name")
	WebElement txtLastWord;

	@FindBy(id = "address")
	WebElement txtAddress;

	@FindBy(id = "cc_num")
	WebElement txtCcNum;

	@FindBy(id = "cc_type")
	WebElement ddCcType;

	@FindBy(id = "cc_exp_month")
	WebElement ddExpMon;

	@FindBy(id = "cc_exp_year")
	WebElement ddExpYear;

	@FindBy(id = "cc_cvv")
	WebElement txtCvv;

	@FindBy(id = "book_now")
	WebElement ddBook;

	@FindBy(id = "first_name_span")
	WebElement textFirstErrorMessage;
	@FindBy(id = "last_name_span")
	WebElement textLastErrorMessage;
	@FindBy(id = "address_span")
	WebElement textAddressErrorMessage;
	@FindBy(id = "cc_num_span")
	WebElement textNumErrorMessage;
	@FindBy(id = "cc_type_span")
	WebElement textTypeErrorMeassage;
	@FindBy(id = "cc_expiry_span")
	WebElement textExpiryErrorMessage;
	@FindBy(id = "cc_cvv_span")
	WebElement textCvvErrorMessage;

	@FindBy(xpath = "//td[text()='Booking Confirmation ']")
	WebElement textbookingCofirmMessage;

	public WebElement getTextbookingCofirmMessage() {
		return textbookingCofirmMessage;
	}

	public WebElement getTextFirstErrorMessage() {
		return textFirstErrorMessage;
	}

	public WebElement getTextLastErrorMessage() {
		return textLastErrorMessage;
	}

	public WebElement getTextAddressErrorMeaasage() {
		return textAddressErrorMessage;
	}

	public WebElement getTextNumErrorMessage() {
		return textNumErrorMessage;
	}

	public WebElement getTextTypeErrorMessage() {
		return textTypeErrorMeassage;
	}

	public WebElement getTextExpiryErrorMessage() {
		return textExpiryErrorMessage;
	}

	public WebElement getTextCvvErrorMessage() {
		return textCvvErrorMessage;
	}

	public WebElement getTxtFirst() {
		return txtFirst;
	}

	public WebElement getTxtLastWord() {
		return txtLastWord;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCcNum() {
		return txtCcNum;
	}

	public WebElement getDdCcType() {
		return ddCcType;
	}

	public WebElement getDdExpMon() {
		return ddExpMon;
	}

	public WebElement getDdExpYear() {
		return ddExpYear;
	}

	public WebElement getTxtCvv() {
		return txtCvv;
	}

	public WebElement getDdBook() {
		return ddBook;
	}

	/**
	 * 
	 * @see user should maintain bookHotelEnterAllFields implement part
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param ccNumber
	 * @param ccType
	 * @param expMonth
	 * @param expYear
	 * @param cVV
	 */

	public void bookHotelEnterAllFields(String firstName, String lastName, String address, String ccNumber,
			String ccType, String expMonth, String expYear, String cVV) {

		insertValue(getTxtFirst(), firstName);
		insertValue(getTxtLastWord(), lastName);
		insertValue(getTxtAddress(), address);
		insertValue(getTxtCcNum(), ccNumber);
		selectOptionByText(getDdCcType(), ccType);
		selectOptionByText(getDdExpMon(), expMonth);
		selectOptionByText(getDdExpYear(), expYear);
		insertValue(getTxtCvv(), cVV);
		click(ddBook);

	}

	/**
	 * 
	 * @see user should maintain bookHotelWithoutEnterAnyFields implement part
	 * 
	 */

	public void bookHotelWithoutEnterAnyFields() {

		click(ddBook);

	}

}
