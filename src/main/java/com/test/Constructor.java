package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Constructor extends BaseTest {
	
	public Constructor() {
		
		WebDriver driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement btnLogin;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public void loginCommonStep(String username, String password) {

		insertValue(getUsername(), username);
		insertValue(getPassword(), password);
		

	}



}
