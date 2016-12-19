package com.application.Test.springWebTest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WebDriverTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/ProjetJEE1/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testWebDriver() throws Exception {
    try {
      assertEquals("Page d'accueil Bienvenue sur la page d'accueil du gestion d'annuaire.\n \n \n \n \n \n \n \n mot de passe Perdu !!!\n se connecter s'inscrire", driver.findElement(By.cssSelector("html")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertTrue(isElementPresent(By.id("bienvenue")));
    try {
      assertEquals("Bienvenue sur la page d'accueil du gestion d'annuaire.", driver.findElement(By.id("bienvenue")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertTrue(isElementPresent(By.cssSelector("div.container")));
    assertTrue(isElementPresent(By.cssSelector("div.imgcontainer")));
    try {
      assertEquals("", driver.findElement(By.cssSelector("div.imgcontainer")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertTrue(isElementPresent(By.name("mail")));
    try {
      assertEquals("", driver.findElement(By.name("mail")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertTrue(isElementPresent(By.name("password")));
    try {
      assertEquals("", driver.findElement(By.name("password")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertTrue(isElementPresent(By.xpath("//button[@type='submit']")));
    try {
      assertEquals("se connecter", driver.findElement(By.xpath("//button[@type='submit']")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertTrue(isElementPresent(By.xpath("//button[@type='button']")));
    try {
      assertEquals("s'inscrire", driver.findElement(By.xpath("//button[@type='button']")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    assertTrue(isElementPresent(By.linkText("mot de passe Perdu !!!")));
    try {
      assertEquals("mot de passe Perdu !!!", driver.findElement(By.linkText("mot de passe Perdu !!!")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.get(baseUrl + "/ProjetJEE1/annuaires/annuaire/home");
    assertTrue(isElementPresent(By.cssSelector("html")));
  }
  
  

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
