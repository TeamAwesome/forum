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
        //Given
        loginController = new LoginController(userService);
    }

    @Test
    public void shouldNavigateToLoginPage() {
        //When
        ModelAndView activityModelAndView = loginController.loginView();
        //Then
        assertThat(activityModelAndView.getViewName(), is("login"));
    }

}
