package com.forum.web.controller;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AdminControllerTest {
    @Test
    public void shouldDefaultToHomePage(){
        AdminController adminController = new  AdminController();
        ModelAndView activityModelAndView = adminController.dashboard();
        assertThat(activityModelAndView.getViewName(), is("adminDashboard"));
    }
}
