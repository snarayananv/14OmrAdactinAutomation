package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;


/**
 * 
 * @author Suriyanarayanan
 * @see used to maintain the SelectHotelPage implement parts
 * @Date 27/12/2022
 *
 */

public class SelectHotelPage extends BaseClass {

	/**
	 * 
	 * @see user should maintain the SelectHotelPage locator deatails 
	 * 
	 */
	
	public SelectHotelPage() {
		
		PageFactory.initElements(driver, this);
				
	}

	@FindBy(id = "radiobutton_0")
	WebElement rdoSelect;

	@FindBy(id = "continue")
	WebElement btncontinue;
	
	@FindBy(id = "radiobutton_span")
	WebElement textErrorSelectHotelMessage;
	
	@FindBy(xpath = "//td[text()='Book A Hotel ']")
	WebElement textBookHotelMessage;
	
	public WebElement getTextBookHotelMessage() {
		return textBookHotelMessage;
	}

	public WebElement getTextErrorSelectHotelMessage() {
		return textErrorSelectHotelMessage;
	}

	public WebElement getRdoSelect() {
		return rdoSelect;
	}

	public WebElement getBtnContinue() {
		return btncontinue;
	}

	public void hotelPageAllFieldsClick() {
		click(rdoSelect);
		click(btncontinue);
	}

	public void hotelPageWithOutEnterAllfieldsClick() {

		click(btncontinue);

	}

}
