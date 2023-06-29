package com.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;

	public void getDriver() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public void maximizeWindow() {

		driver.manage().window().maximize();

	}

	public void loadUrl(String url) {

		driver.get(url);

	}

	public void insertValue(WebElement element, String data) {

		element.sendKeys(data);

	}

	public void click(WebElement element) {

		element.click();

	}

	public void implicitWaits(long seconds) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

	}

}
