package com.forum.web.page.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.Set;

import static java.lang.Thread.sleep;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class HomeTest {
    private WebDriver driver;


    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/app/");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void shouldGoToTwitter() throws Exception {
        WebElement twitterLink = driver.findElement(By.className("twitter-share-button"));
        twitterLink.click();

        //assertThat(driver.getCurrentUrl(), is("https://twitter.com/intent/session?original_referer=http%3A%2F%2Flocalhost%3A8080%2Fapp%2F&return_to=%2Fintent%2Ftweet%3Foriginal_referer%3Dhttp%253A%252F%252Flocalhost%253A8080%252Fapp%252F%26source%3Dtweetbutton%26text%3DVisit%2520the%2520forum%2520for%2520info%2520on%2520Bangalore%2520-%253E%2520http%253A%252F%252Flocalhost%253A8080%252Fapp%26url%3Dhttp%253A%252F%252Flocalhost%253A8080%252Fapp%252F&source=tweetbutton&text=Visit+the+forum+for+info+on+Bangalore+-%3E+http%3A%2F%2Flocalhost%3A8080%2Fapp"));
    }

    @Test
    public void shouldGoToFacebook() throws Exception {
        WebElement facebookLink = driver.findElement(By.className("Facebook"));
        Object lastWindow = null;
        facebookLink.click();
        Set windowHandles = driver.getWindowHandles();
        Iterator iter = windowHandles.iterator();
        while (iter.hasNext()) {
            lastWindow = iter.next();
            ;
        }
        driver.switchTo().window((String) lastWindow);
        sleep(10000);
        assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com/login.php?api_key=126401650838612"));
    }

    @Test
    public void shouldDisplayNotPublishUponCancelFacebook() throws Exception {
        WebElement facebookLink = driver.findElement(By.className("Facebook"));
        Object lastWindow = null;
        Object mainWindow = driver.getWindowHandle();
        facebookLink.click();
        Set windowHandles = driver.getWindowHandles();
        Iterator iter = windowHandles.iterator();
        while (iter.hasNext()) {
            lastWindow = iter.next();
        }
        driver.switchTo().window((String) lastWindow);

        //!!!!!!Sleep till the pop up from facebook is completely loaded!!!!!!
        sleep(10000);
        WebElement cancel = driver.findElement(By.name("cancel"));
        cancel.click();
        driver.switchTo().window((String) mainWindow);
        String message = driver.switchTo().alert().getText();
        assertThat(message, is("Post was not published."));
    }
}

