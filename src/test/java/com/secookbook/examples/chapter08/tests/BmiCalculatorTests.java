package com.secookbook.examples.chapter08.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import seleniumcookbook.tests.pageobjects.BmiCalcPage;

import static org.junit.Assert.*;

public class BmiCalculatorTests {

	private WebDriver driver;

	@Before
	public void setUp() {
		//set Gecko driver system property
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\David\\Documents\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Test
	public void testBmiCalculation() {
		// Create an instance of Bmi Calculator Page class
		// and provide the driver
		BmiCalcPage bmiCalcPage = new BmiCalcPage(driver);

		// Open the Bmi Calculator Page
		bmiCalcPage.get();

		// Calculate the Bmi by supplying Height and Weight values
		bmiCalcPage.calculateBmi("181", "80");

		// Verify Bmi & Bmi Category values
		assertEquals("24.4", bmiCalcPage.getBmi());
		assertEquals("Normal", bmiCalcPage.getBmiCategory());
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}

