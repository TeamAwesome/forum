package com.forum.web.page;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created with IntelliJ IDEA.
 * User: kunalup
 * Date: 23/8/12
 * Time: 12:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class JoinTest {

        public static void main(String args[]) {

            // Create a new instance of the Firefox driver
            // Notice that the remainder of the code relies on the interface,
            // not the implementation.
            WebDriver driver = new FirefoxDriver();

            // And now use this to visit Google
            driver.get("http://www.google.com");
            // Alternatively the same thing can be done like this
            // driver.navigate().to("http://www.google.com");

            // Find the text input element by its name
            WebElement element = driver.findElement(By.name("q"));

            // Enter something to search for
            element.sendKeys("Cheese!");

            // Now submit the form. WebDriver will find the form for us from the element
            element.submit();

            // Check the title of the page
            System.out.println("Page title is: " + driver.getTitle());

            //Close the browser
            driver.quit();
        }
    }

