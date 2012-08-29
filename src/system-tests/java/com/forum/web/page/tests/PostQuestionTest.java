package com.forum.web.page.tests;

import org.apache.commons.lang.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PostQuestionTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/app/postQuestion");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void checkTitleTest() {
        WebElement title = driver.findElement(By.id("questionTitle"));
        title.sendKeys("Practice");
        WebElement post = driver.findElement(By.id("titleValidationMessage"));
        assertThat(post.getText(), is("92 Characters Remaining"));
    }

    @Test
    public void testTitleLimit() throws Exception {
        WebElement title = driver.findElement(By.id("questionTitle"));
        title.sendKeys(StringUtils.repeat("0", 100));
        WebElement post = driver.findElement(By.id("titleValidationMessage"));
        assertThat(post.getText(), is("0 Characters Remaining"));
    }

    @Test
    public void shouldStopTextEntry() throws Exception {
        WebElement title = driver.findElement(By.id("questionTitle"));
        title.sendKeys(StringUtils.repeat("0", 100) + "132");
        assertThat(title.getAttribute("value"), is(StringUtils.repeat("0", 100)));
    }

    @Test
    public void shouldGiveErrorOnSubmitWithEmptyBody() throws Exception {
        WebElement title = driver.findElement(By.id("questionTitle"));
        title.sendKeys("asdfad");
        WebElement submit = driver.findElement(By.id("submitButton"));
        submit.click();
        assertThat(driver.getCurrentUrl(), is("http://localhost:8080/app/postQuestion"));
        assertThat(driver.findElement(By.id("descriptionValidationMessage")).getText(), is("A Question must have a description."));
    }

    @Test
    public void shouldGiveErrorOnSubmitWithEmptyTitle() throws Exception {
        WebElement submit = driver.findElement(By.id("submitButton"));
        submit.click();
        assertThat(driver.getCurrentUrl(), is("http://localhost:8080/app/postQuestion"));
        assertThat(driver.findElement(By.id("titleValidationMessage")).getText(), is("A Question must have a title."));
        assertThat(driver.findElement(By.id("descriptionValidationMessage")).getText(), is("A Question must have a description."));
    }
}


