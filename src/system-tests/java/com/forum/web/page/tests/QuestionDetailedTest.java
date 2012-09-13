package com.forum.web.page.tests;

import com.forum.util.TestHelper;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.logging.Logger;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class QuestionDetailedTest extends FunctionalTestBase {

    private static Logger logger = Logger.getLogger(QuestionDetailedTest.class.getName());

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
        TestHelper testHelper = new TestHelper();

        WebElement goToDetailedView = browser.findElement(By.className("questionTitle"));
        goToDetailedView.click();
        browser.waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("likeInput")));

        // getting the like count before increasing it
        //
        WebElement likeCountOne = browser.findElement(By.id("likeCount"));
        int likeCountOneValue = testHelper.getLikeCountValue(likeCountOne.getText());

        assertTrue(likeCountOneValue >= 0);

        // increasing the like count
        //
        WebElement likeButton = browser.findElement(By.id("likeInput"));
        likeButton.click();

        // wait until the content of link count has changed
        //
        browser.waitFor(
                ExpectedConditions.textToBePresentInElement(
                        By.id("likeCount"),
                        "(" + (likeCountOneValue + 1) + ") Likes"
                )
        );

        // getting the updated like count
        //
        WebElement likeCountTwo = browser.findElement(By.id("likeCount"));
        int likeCountTwoValue = testHelper.getLikeCountValue(likeCountTwo.getText());

        assertEquals(likeCountOneValue + 1, likeCountTwoValue);
    }

}
