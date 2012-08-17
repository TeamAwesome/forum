package com.forum.web.page;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class SearchResultsPage implements Page {

    private Browser browser;

    public void verify(Browser browser) {
        assertThat("Unexpected page", browser.getBodyClass(), containsString("search results"));
        this.browser = browser;
    }

}
