package com.forum.web.page.tests;


import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PostQuestionTest extends FunctionalTestBase {

    @Test
    public void shouldGoThroughPostQuestion() {
        WebElement login = browser.findElement(By.linkText("Login"));
        login.click();
        WebElement loginUsername = browser.findElement(By.name("j_username"));
        loginUsername.sendKeys("Stephanie");
        WebElement loginPassword = browser.findElement(By.name("j_password"));
        loginPassword.sendKeys("Stephanie");
        WebElement submit = browser.findElement(By.name("submit"));
        submit.click();
        WebElement postQuestion = browser.findElement(By.linkText("Post Question"));
        postQuestion.click();
        assertThat(browser.getCurrentUrl(), is("http://localhost:8080/forum/postQuestion"));
        assertTrue(browser.findElement(By.id("questionTitle")).isDisplayed());
    }

    @Test
    public void checkTitleTest() {
        WebElement title = browser.findElement(By.id("questionTitle"));
        title.sendKeys("Practice");
        WebElement post = browser.findElement(By.id("titleValidationMessage"));
        assertThat(post.getText(), is("92 Characters Remaining"));
    }

    @Test
    public void testTitleLimit() throws Exception {
        WebElement title = browser.findElement(By.id("questionTitle"));
        title.sendKeys(StringUtils.repeat("0", 100));
        WebElement post = browser.findElement(By.id("titleValidationMessage"));
        assertThat(post.getText(), is("0 Characters Remaining"));
    }

    @Test
    public void shouldStopTextEntry() throws Exception {
        WebElement title = browser.findElement(By.id("questionTitle"));
        title.sendKeys(StringUtils.repeat("0", 100) + "132");
        assertThat(title.getAttribute("value"), is(StringUtils.repeat("0", 100)));
    }

    @Test
    public void shouldGiveErrorOnSubmitWithEmptyBody() throws Exception {
        WebElement title = browser.findElement(By.id("questionTitle"));
        title.sendKeys("asdfad");
        WebElement submit = browser.findElement(By.id("submitButton"));
        submit.click();
        assertThat(browser.getCurrentUrl(), is("http://localhost:8080/app/postQuestion"));
        assertThat(browser.findElement(By.id("descriptionValidationMessage")).getText(), is("A Question must have a description."));
    }

    @Test
    public void shouldGiveErrorOnSubmitWithEmptyTitle() throws Exception {
        WebElement submit = browser.findElement(By.id("submitButton"));
        submit.click();
        assertThat(browser.getCurrentUrl(), is("http://localhost:8080/app/postQuestion"));
        assertThat(browser.findElement(By.id("titleValidationMessage")).getText(), is("A Question must have a title."));
        assertThat(browser.findElement(By.id("descriptionValidationMessage")).getText(), is("A Question must have a description."));
    }
}


