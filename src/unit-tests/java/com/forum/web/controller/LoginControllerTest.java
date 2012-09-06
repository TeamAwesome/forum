package com.forum.web.controller;

import com.forum.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LoginControllerTest {

    private LoginController loginController;
    private UserService userService;

    @Before
    public void setUp() {
        loginController = new LoginController(userService);
    }

    @Test
    public void shouldNavigateToLoginPage() {
        ModelAndView activityModelAndView = loginController.loginView();

        assertThat(activityModelAndView.getViewName(), is("login"));
    }

    @Test
    public void shouldThrowErrorMessageIfUserValidationFails() {
        ModelAndView errorModelAndView = loginController.errorLoginView();

        assertThat(errorModelAndView.getViewName(), is("login"));
    }
}
