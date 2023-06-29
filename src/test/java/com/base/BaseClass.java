package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Suriyanarayanan
 * @see used to maintain the BaseClass implement parts
 * @Date 27/12/2022
 *
 */

public class BaseClass {

	public static WebDriver driver;

	/**
	 * 
	 * @see user should to maintain the intresteddriver implement parts
	 * @param browserType
	 * 
	 */

	public void getDriver(String browserType) {

		switch (browserType) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			break;

		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			break;

		case "Io":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			break;
		}

	}

	/**
	 *
	 * @see user should to maintain the maximizeWindow implement parts
	 * 
	 */

	public void maximizeWindow() {

		driver.manage().window().maximize();

	}

	/**
	 * 
	 * @see user should to maintain the loadUrl implement parts
	 * @param url
	 * 
	 */

	public void loadUrl(String url) {

		driver.get(url);

	}

	/**
	 * 
	 * @see user should to maintain the screenshot implement parts
	 * @return byte[]
	 * 
	 */

	public byte[] screenshot() {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
		return screenshotAs;

	}

	/**
	 * 
	 * @see user should to maintain the quitWindow implement parts
	 * 
	 */

	public void quitWindow() {

		driver.quit();

	}

	/**
	 * 
	 * @see user should to maintain the insertValue implement parts
	 * @param element
	 * @param data
	 * 
	 */

	public void insertValue(WebElement element, String data) {

		elementVisiblity(element);
		element.clear();
		element.sendKeys(data);

	}

	/**
	 * 
	 * @see user should to maintain the click implement parts
	 * @param element
	 * 
	 */

	public void click(WebElement element) {
		elementVisiblity(element);
		element.click();

	}

	/**
	 * 
	 * @see user should to maintain the implicitWaits implement parts
	 * @param seconds
	 * 
	 */
	public void implicitWaits(long seconds) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

	}

	/**
	 * 
	 * @see user should to maintain the selectOptionByText implement parts
	 * @param element
	 * @param text
	 * 
	 */

	public void selectOptionByText(WebElement element, String text) {

		Select s = new Select(element);
		s.selectByVisibleText(text);

	}

	/**
	 * 
	 * @see user should to maintain the elementGetAttribute implement parts
	 * @param element
	 * @param data
	 * @return String
	 * 
	 */

	public String elementGetAttribute(WebElement element, String data) {

		String attribute = element.getAttribute("value");
		return attribute;

	}

	/**
	 * 
	 * @see user should to maintain the Alert implement parts
	 * @return Alert
	 * 
	 */

	public Alert alert() {

		Alert alert = driver.switchTo().alert();
		return alert;

	}

	/**
	 * 
	 * @see user should to maintain the getProjectValue implement parts
	 * @return String
	 * 
	 */

	public static String getProjectValue() {

		String property = System.getProperty("user.dir");
		return property;

	}

	/**
	 * 
	 * @see user should to maintain the getPropertieFileValue implement parts
	 * @param key
	 * @return String
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String getPropertieFileValue(String key) throws FileNotFoundException, IOException {

		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectValue() + "\\Confiq\\confiq.properties"));
		Object object = properties.get(key);
		String string = (String) object;
		return (String) properties.get(key);

	}

	/**
	 * 
	 * @see user should to maintain the elementVisiblity implement parts
	 * @param element
	 * 
	 */

	public void elementVisiblity(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * 
	 * @see user should to maintain the elementGetText implement parts
	 * @param element
	 * @return String
	 * 
	 */

	public String elementGetText(WebElement element) {

		String text = element.getText();
		return text.trim();

	}

	/**
	 * 
	 * @see user should to maintain the quit implement parts
	 * 
	 */

	public void quit() {

		driver.quit();

	}
}
