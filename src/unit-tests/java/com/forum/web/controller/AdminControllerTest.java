package com.forum.web.controller;

import com.forum.service.AdminService;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class AdminControllerTest{

    @Test
    public void shouldDefaultToHomePage(){
        AdminService adminService = mock(AdminService.class);
        AdminController adminController = new AdminController(adminService);
        ModelAndView activityModelAndView = adminController.dashboard();
        assertThat(activityModelAndView.getViewName(), is("adminDashboard"));
    }
}
