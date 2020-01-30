package com.ibm.qe;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestNationwide {

	private String sFFDriverLoc = "C:\\Users\\JebersonChelladuraiJ\\git\\Test\\TestCICD\\resources\\geckodriver.exe";
	private WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.gecko.driver", sFFDriverLoc);
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	@Test
	@Category(TestInterface.class)
	public void test() {
		driver.get("https://www.nationwide.co.uk/");
		driver.findElement(By.linkText("Branch finder")).click();
		driver.findElement(By.cssSelector(".Locator-searchBar input")).sendKeys("Swindon, UK");
		driver.findElement(By.cssSelector(".search-button")).click();
		driver.findElement(By.xpath("//span[text()='Swindon Regent Street']")).click();
		assert driver.findElement(By.className("LocationName-geo")).getText().equals("Swindon Regent Street");
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	

}
