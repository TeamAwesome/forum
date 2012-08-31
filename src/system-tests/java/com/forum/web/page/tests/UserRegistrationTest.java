package com.forum.web.page.tests;

import com.forum.web.page.Browser;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class UserRegistrationTest {
    private Browser browser;

    @Before
    public void initializeWebDriver() {
        browser = new Browser("http://localhost:8080/forum", true);
        browser.open("/join");
    }

    @After
    public void closeBrowser() {
        browser.stop();
    }

    @Test
    public void shouldGoToRegistrationPage() {
        browser.open("/");
        WebElement joinLink = browser.findElement(By.linkText("Join"));
        joinLink.click();
        browser.waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("register")));
        assertTrue(browser.getCurrentUrl().contains("/join"));
    }

    @Ignore("Not showing password msg error.")
    @Test
    public void shouldHavePasswordErrorWhenLessThan8() {
        WebElement passwordField = browser.findElement(By.id("password"));
        passwordField.sendKeys("1234567");

        WebElement signUp = browser.findElement(By.id("register"));
        signUp.click();

        browser.waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("passwordMsg")));

        String errorMsg = browser.findElement(By.id("passwordMsg")).getText();
        assertThat(errorMsg, is("Password should be at least 8 characters."));
    }

    @Test
    public void shouldDisplayErrorWhenEmailFormatInvalid() {
        WebElement emailField = browser.findElement(By.id("email"));
        emailField.sendKeys("123asdf");

        WebElement signUp = browser.findElement(By.id("register"));
        signUp.click();

        browser.waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("emailMsg")));

        String errorMsg = browser.findElement(By.id("emailMsg")).getText();
        assertThat(errorMsg, is("Please enter a valid email address."));
    }

    @Test
    public void shouldDisplayTermsAndConditions() {
        WebElement termsLink = browser.findElement(By.name("tos"));
        termsLink.click();
        WebElement TosTitle = browser.waitFor(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
        assertTrue(browser.getCurrentUrl().contains("/terms"));
        assertThat(TosTitle.getText(), is("The Forum Terms and Conditions"));
    }
}
