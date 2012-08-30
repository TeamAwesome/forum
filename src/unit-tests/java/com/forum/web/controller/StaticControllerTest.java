package com.forum.web.controller;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StaticControllerTest {
    @Test
    public void shouldShowTermsAndConditionsPage(){
        StaticController staticController = new StaticController();
        ModelAndView termsModelView = staticController.registerTerms();
        assertThat(termsModelView.getViewName(), is("terms"));
    }
}
