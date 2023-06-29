package com.pages;

import java.time.Duration;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {

	@Test
	public void login() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");

		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("oneplus bluetooth earphones", Keys.ENTER);
		WebElement searchText = driver
				.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[3]"));
		searchText.click();

		String parWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for (String eachWindow : allWindow) {
			if (!parWindow.equals(eachWindow)) {
				driver.switchTo().window(eachWindow);
			}
		}

		WebElement cart = driver.findElement(By.id("add-to-cart-button"));
		cart.click();

	    Assert.assertTrue("Added to Cart", true);

		WebElement addCart = driver.findElement(By.id("nav-cart"));
		addCart.click();

		WebElement proceedCheckout = driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']"));
		proceedCheckout.click();

		WebElement phoneNumber = driver.findElement(By.id("ap_email"));
		phoneNumber.sendKeys("9790383744", Keys.ENTER);

		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys("vikravan", Keys.ENTER);

		driver.navigate().refresh();
		WebElement useAddress = driver.findElement(By.xpath("(//input[@class='a-button-input'])[2]"));
		useAddress.click();

		WebElement checkoutCancel = driver.findElement(By.xpath("//i[@class='a-icon a-icon-logo clickable-heading']"));
		checkoutCancel.click();

		WebElement returnToCart = driver.findElement(By.xpath("//a[contains(text(),'Return to Cart')]"));
		returnToCart.click();

		WebElement cartDelete = driver
				.findElement(By.xpath("(//input[@class='a-color-link'])[1]"));
		cartDelete.click();
	
	    Assert.assertTrue("was removed from Shopping Cart.", true);
	}

}
