package com.forum.web.controller;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HomeControllerTest {
    @Test
    public void shouldDefaultToHomePage(){
        HomeController homeController = new HomeController();
        ModelAndView activityModelAndView = homeController.activityView();
        assertThat(activityModelAndView.getViewName(), is("home"));
    }
}
