package com.forum.web.page.tests;

import com.forum.web.page.Browser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ActivityWallTest {
    private Browser browser;

    @Before
    public void initializeWebDriver() {
        browser = new Browser("http://localhost:8080/forum", true);
        browser.open("/");
    }

    @After
    public void closeBrowser() {
        browser.stop();
    }

    @Test
    public void shouldLoadMoreQuestions() {
        WebElement loadMore = browser.findElement(By.id("loadMoreQuestions"));

        WebElement activityWall = browser.findElement(By.id("leftPane"));
        List<WebElement> questions = activityWall.findElements(By.className("questionTitle"));
        assertThat(questions.size(), is(10));

        loadMore.click();

        questions = activityWall.findElements(By.className("questionTitle"));
        assertThat(questions.size(), is(20));
    }
}
