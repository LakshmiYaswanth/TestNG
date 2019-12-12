package com.revature.testng.amazonTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTestV1 {
	WebDriver driver;
	WebElement element;
	@Test
	public void openBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
	    Thread.sleep(1000);
		System.out.println("======chrome is opened========");
		driver.navigate().to("http://www.google.com/");
		Assert.assertTrue(true);
	}
	@Test(dependsOnMethods="openBrowser")
	public void openAmazon() {
		driver.findElement(By.name("q")).sendKeys("Amazon");
		element=driver.findElement(By.name("btnK"));
	    element.submit();
	    Assert.assertTrue(true);
	}
	   
	@Test(dependsOnMethods="openAmazon")
	public void Homepage() {
		element=driver.findElement(By.xpath("//span[contains(text(),'Amazon.in')]"));
		element.click();
		Assert.assertTrue(true);
	}
	@Test(dependsOnMethods="Homepage")
	public void ToLogin() {
		element= driver.findElement(By.id("nav-link-accountList"));
	    element.click();
	    driver.findElement(By.id("ap_email")).sendKeys("9398650136");
	    element = driver.findElement(By.id("continue"));
	    element.click();
	    boolean status= element.isDisplayed();
	    Assert.assertTrue(status);
	    driver.findElement(By.id("ap_password")).sendKeys("yaswanth");
	    element= driver.findElement(By.id("signInSubmit"));
	    element.click();
	}
	@Test(dependsOnMethods="ToLogin")
	public void logout() {
		element=driver.findElement(By.xpath("//a[@id='nav-link-accountList']//span[@class='nav-icon nav-arrow']"));
		element.click();
		driver.close();
	}

}
