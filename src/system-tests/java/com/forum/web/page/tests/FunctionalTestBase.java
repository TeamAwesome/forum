package com.forum.web.page.tests;


import com.forum.web.page.Browser;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class FunctionalTestBase {
    public Browser browser;

    private Properties properties;
    private static Logger logger = Logger.getLogger(FunctionalTestBase.class.getName());

    @Before
    public void initializeWebDriver() throws IOException {

        properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("system-tests.properties"));
        logger.info("properties = " + properties.toString());

        StringBuilder builder = new StringBuilder();
        builder.append("http://");
        builder.append(properties.getProperty("forum.host"));
        builder.append(":");
        builder.append(properties.getProperty("forum.port"));
        builder.append("/forum");

        String address = builder.toString();
        logger.info("address = " + address);

        browser = new Browser(address, true);
        browser.open("/");

        browser.waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("activityWallTitle")));
    }

    @After
    public void closeBrowser() {
        browser.stop();
    }

    protected void login() {
        WebElement login = browser.findElement(By.linkText("Login"));
        login.click();
        WebElement loginUsername = browser.waitFor(ExpectedConditions.visibilityOfElementLocated(By.name("j_username")));
        loginUsername.sendKeys("Jules");
        WebElement loginPassword = browser.findElement(By.name("j_password"));
        loginPassword.sendKeys("password");
        WebElement submit = browser.findElement(By.name("submit"));
        submit.click();
        browser.waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("logout")));
    }

    protected void logout() {
        WebElement logoutLink = browser.findElement(By.linkText("Logout"));
        logoutLink.click();
        browser.waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("container")));
        assertTrue(browser.getCurrentUrl().endsWith("/forum/logout"));

    }
}
