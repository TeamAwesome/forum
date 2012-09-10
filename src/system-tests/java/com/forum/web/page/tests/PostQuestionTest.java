package com.forum.web.page.tests;


import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PostQuestionTest extends FunctionalTestBase {

    private void goToPostQuestionPage() {
        WebElement postQuestion = browser.findElement(By.linkText("Post Question"));
        postQuestion.click();
        browser.waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("questionTitle")));
    }


    @Test
    public void shouldGoThroughPostQuestion() {
        login();
        goToPostQuestionPage();
        assertTrue(browser.getCurrentUrl().contains("/postQuestion"));
        assertTrue(browser.findElement(By.id("questionTitle")).isDisplayed());
    }

    @Test
    public void checkTitleTest() {
        login();
        goToPostQuestionPage();
        WebElement title = browser.findElement(By.id("questionTitle"));
        title.sendKeys("Practice");
        WebElement post = browser.findElement(By.id("titleValidationMessage"));
        assertThat(post.getText(), is("92 characters remaining."));
    }

    @Test
    public void testTitleLimit() throws Exception {
        login();
        goToPostQuestionPage();
        WebElement title = browser.findElement(By.id("questionTitle"));
        title.sendKeys(StringUtils.repeat("0", 100));
        WebElement post = browser.findElement(By.id("titleValidationMessage"));
        assertThat(post.getText(), is("0 characters remaining."));
    }

    @Test
    public void shouldStopTextEntry() throws Exception {
        login();
        goToPostQuestionPage();
        WebElement title = browser.findElement(By.id("questionTitle"));
        title.sendKeys(StringUtils.repeat("0", 100) + "132");
        assertThat(title.getAttribute("value"), is(StringUtils.repeat("0", 100)));
    }

    @Test
    public void shouldGiveErrorOnSubmitWithEmptyBody() throws Exception {
        login();
        goToPostQuestionPage();
        WebElement title = browser.findElement(By.id("questionTitle"));
        title.sendKeys("asdfad");
        WebElement submit = browser.findElement(By.id("submitButton"));
        submit.click();
        browser.waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("questionTitle")));
        assertTrue(browser.getCurrentUrl().contains("/showPostedQuestion"));
        assertThat(browser.findElement(By.id("descriptionMsg")).getText(), is("Description is empty."));
    }

    @Test
    public void shouldGiveErrorOnSubmitWithEmptyTitle() throws Exception {
        login();
        goToPostQuestionPage();
        WebElement submit = browser.findElement(By.id("submitButton"));
        submit.click();
        browser.waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("questionTitle")));
        assertTrue(browser.getCurrentUrl().contains("/showPostedQuestion"));
        assertThat(browser.findElement(By.id("titleMsg")).getText(), is("Title is empty."));
        assertThat(browser.findElement(By.id("descriptionMsg")).getText(), is("Description is empty."));
    }
}


