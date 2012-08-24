package com.forum.web.page.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: twu
 * Date: 24/8/12
 * Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class TWTest {



        @Test
        public void mythoughtworkssubmit () {
            WebDriver driver = new FirefoxDriver();
            driver.get("https://my.thoughtworks.com");
            WebElement username = driver.findElement(By.id("username"));
            username.sendKeys("sjacobs");
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("Al*1288bert");
            WebElement login = driver.findElement(By.className("btn-submit"));
            login.click();
            WebElement searchbox = driver.findElement(By.id("jive-query"));
            searchbox.sendKeys("Team Awesome TWU28");
            searchbox.submit();
            WebElement places = driver.findElement(By.xpath("//li[@id='jiveTab_places']/a"));
            places.click();
            WebElement teamawesome = driver.findElement(By.cssSelector("a[href='/groups/team-c-twu28']"));
            teamawesome.click();
            WebElement startdiscussion = driver.findElement(By.xpath("//li[@id='jive-link-createThread']/a"));
            startdiscussion.click();
            WebElement subject = driver.findElement(By.id("subject01"));
            subject.sendKeys("QA Practice");

            WebElement textAreaElement = driver.findElement(By.xpath("//div[@id='wysiwyg-panel']/textarea"));
            ((JavascriptExecutor)driver).executeScript("arguments[0].style.display='block';", textAreaElement);

            textAreaElement.sendKeys("Just a QA practicing functional testing");
            WebElement tag = driver.findElement(By.id("jive-tags"));
            tag.sendKeys("QAPractice");
            WebElement post = driver.findElement(By.id("postButton"));
            post.click();
}
}
