package com.ibm.qe;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Test1 {
	private String sFFDriverLoc = "C:\\Users\\JebersonChelladuraiJ\\git\\Test\\TestCICD\\resources\\geckodriver.exe";
	private WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.gecko.driver", sFFDriverLoc);
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() {
		driver.get("http://www.google.com");
		driver.findElement(By.cssSelector("input[title='Search']")).sendKeys("IBM"+Keys.ENTER);
//		WebElement element = driver.findElement(By.cssSelector("input[value='Google Search']"));
//		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
//		element.click();
		try {
			assert driver.findElement(By.xpath("//div[@data-attrid='title']//span[text()='IBM']")).isDisplayed()==true;
		}
		catch(NoSuchElementException nse) {
			System.out.println("Element is not displayed");
		}
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
