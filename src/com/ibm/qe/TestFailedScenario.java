package com.ibm.qe;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

import junit.framework.Assert;

public class TestFailedScenario {

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
//		try {
		Assert.assertTrue("Failing test",driver.findElement(By.className("LocationName-geo")).getText().equals("Swindon Regent"));
//		}
//		catch(Exception e) {
//			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			try {
//				Files.copy(file, new File("C:\\Failure"));
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}
	}
	
	@After
	public void tearDown() throws Exception {
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(file, new File("C:\\Failures\\Failure.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.quit();
	}

	

}
