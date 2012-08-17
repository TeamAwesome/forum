package com.forum.web.page;

import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class HomePage implements Page {

    private WebElement search;

    public void verify(Browser browser) {
        assertThat("Unexpected page", browser.getBodyClass(), containsString("home"));
    }

}
