package com.forum.web.page.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class QuestionDetailedTest extends FunctionalTestBase {
    @Test
    public void shouldGoToDetailedView() {
        List<WebElement> questions = browser.findElements(By.cssSelector("#activityQuestions a"));
        WebElement question = questions.get(0);
        String title = question.getText();

        question.click();

        WebElement detailedViewTitle = browser.waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("questionTitle")));

        assertThat(detailedViewTitle.getText(), is(title));
        assertTrue(browser.getCurrentUrl().contains("/question/view/"));

    }

    @Test
    public void shouldLikeQuestion() {
        WebElement goToDetailedView = browser.findElement(By.className("questionTitle"));
        goToDetailedView.click();
        browser.waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("likeInput")));
        WebElement likeStatistic1 = browser.findElement(By.id("likeCount"));
        likeStatistic1.getText();
        WebElement likeButton = browser.findElement(By.id("likeInput"));
        likeButton.click();
        browser.waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("likeCount")));
        WebElement likeStatistic2 = browser.findElement(By.id("likeCount"));
        likeStatistic2.getText();
        assertFalse((likeStatistic1.getText()).matches(likeStatistic2.getText()));
    }
}
