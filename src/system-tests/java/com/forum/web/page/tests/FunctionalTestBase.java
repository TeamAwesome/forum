package com.forum.web.page.tests;


import com.forum.web.page.Browser;
import org.junit.After;
import org.junit.Before;

public class FunctionalTestBase {
        public Browser browser;

        @Before
        public void initializeWebDriver() {
            browser = new Browser("http://localhost:8080/forum", true);
            browser.open("/");
        }

        @After
        public void closeBrowser() {
            browser.stop();
        }
}
