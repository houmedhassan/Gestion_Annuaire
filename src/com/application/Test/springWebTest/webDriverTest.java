package com.application.Test.springWebTest;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webDriverTest {
	
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
	    driver = new FirefoxDriver(); 
//	    baseUrl = "http://localhost:8080/ProjetJEE1/annuaires/annuaire/home"; 
 
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWebDriver(){
		
	}

}
