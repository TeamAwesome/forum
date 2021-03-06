package com.forum.web.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Browser {

    private final boolean javascriptEnabled;
    private final String hostAddress;
    private final WebDriver driver;

    public Browser(String hostAddress, boolean testWithFirefox) {
        this.hostAddress = hostAddress;
        if (testWithFirefox) {
            this.driver = new FirefoxDriver();
            this.javascriptEnabled = true;
        } else {
            this.driver = new HtmlUnitDriver();
            this.javascriptEnabled = false;
        }
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public Browser open(String url) {
        if (url.startsWith("/")) {
            driver.get(hostAddress + url);
        } else {
            driver.get(url);
        }
        return this;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isJavascriptEnabled() {
        return javascriptEnabled;
    }

    public WebElement findElement(By selector) {
        return driver.findElement(selector);
    }

    public List<WebElement> findElements(By selector) {
        return driver.findElements(selector);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public String getBodyClass() {
        return findElement(By.tagName("body")).getAttribute("class");
    }

    public void stop() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebElement waitFor(ExpectedCondition<WebElement> expectedCondition) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        return wait.until(expectedCondition);
    }

    public Boolean waitFor(ExpectedCondition<Boolean> expectedCondition) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        return wait.until(expectedCondition);
    }

}
