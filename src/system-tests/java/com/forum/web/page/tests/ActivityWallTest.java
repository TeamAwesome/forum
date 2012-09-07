package com.forum.web.page.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.logging.Logger;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ActivityWallTest extends FunctionalTestBase {

    private static Logger logger = Logger.getLogger(ActivityWallTest.class.getName());

    @Test
    public void shouldLoadMoreQuestions() {
        browser.waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("container")));
        WebElement loadMore = browser.findElement(By.id("loadMoreQuestions"));

        WebElement activityWall = browser.findElement(By.id("leftPane"));
        List<WebElement> questions = activityWall.findElements(By.className("questionTitle"));
        assertThat(questions.size(), is(10));
        loadMore.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        questions = activityWall.findElements(By.className("questionTitle"));
        assertThat(questions.size(), is(20));
    }

    @Test
    public void shouldGoThroughAdminLoginLogoutProcess() {
        browser.open("/adminDashboard");
        assertTrue(browser.getCurrentUrl().contains("/login"));

        WebElement userNameLogin = browser.findElement(By.name("j_username"));
        userNameLogin.sendKeys("Jules");
        WebElement passwordLogin = browser.findElement(By.name("j_password"));
        passwordLogin.sendKeys("Great!");

        WebElement submitButton = browser.findElement(By.name("submit"));
        submitButton.click();
        browser.waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("container")));

        assertTrue(browser.getCurrentUrl().contains("/errorLogin"));


        WebElement userNameLogin2 = browser.findElement(By.name("j_username"));
        userNameLogin2.sendKeys("Jules");
        WebElement passwordLogin2 = browser.findElement(By.name("j_password"));
        passwordLogin2.sendKeys("password");

        WebElement submitButton2 = browser.findElement(By.name("submit"));
        submitButton2.click();
        browser.waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("container")));

        assertTrue(browser.getCurrentUrl().contains("/adminDashboard"));
        assertTrue(browser.findElement(By.id("leftPane")).getText().contains("Welcome to the Admin Dashboard"));

        WebElement logoutLink = browser.findElement(By.id("logout"));
        logoutLink.click();
        browser.waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("container")));

        logger.info(browser.getCurrentUrl());

        assertTrue(browser.getCurrentUrl().endsWith("/forum/logout"));
    }
}
