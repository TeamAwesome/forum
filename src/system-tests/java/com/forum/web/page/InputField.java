package com.forum.web.page;

import org.openqa.selenium.WebElement;

public class InputField {

    public static void setValue(WebElement input, String value) {
        input.clear();
        input.sendKeys(value);
    }
}
