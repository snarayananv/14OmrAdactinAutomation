package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

/**
 * 
 * @author Suriyanarayanan
 * @see used to maintain the LoginPage implement parts
 * @Date 27/12/2022
 * 
 */

public class LoginPage extends BaseClass {

	/**
	 * 
	 * @see used to maintain the locator deatails
	 * 
	 */
	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement txtUsername;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(id = "login")
	private WebElement btnLogin;

	@FindBy(xpath = "//div[@class='auth_error']")
	private WebElement textErrorLoginMessage;

	public WebElement getTextErrorLoginMessage() {
		return textErrorLoginMessage;
	}

	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	/**
	 * 
	 * @see used to maintain the button
	 * @return WebElement
	 * 
	 */

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	/**
	 *
	 * @see used to maintain the commonstep of loginpage deatails
	 * @param username
	 * @param password
	 */

	public void loginCommonStep(String username, String password) {

		insertValue(getTxtUsername(), username);
		insertValue(getTxtPassword(), password);

	}

	/**
	 * @see used to maintain the login implement part
	 * @param username
	 * @param password
	 */

	public void login(String username, String password) {

		loginCommonStep(username, password);
		click(getBtnLogin());

	}

	/**
	 * @see used to maintain the perform login with enter key implement part
	 * @param username
	 * @param password
	 * @throws AWTException
	 */

	public void loginWithEnterKey(String username, String password) throws AWTException {

		loginCommonStep(username, password);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * 
	 * @see used to maintain after login with invalid credential implement part
	 * @param username
	 * @param password
	 */

	public void loginInvalidCredendials(String username, String password) {
		loginCommonStep(username, password);
		click(getBtnLogin());

	}
}
