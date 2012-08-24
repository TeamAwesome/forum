package com.forum.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LoginControllerTest {

    private LoginController loginController;

    @Before
    public void setUp() {
        //Given
        loginController = new LoginController();
    }

    @Test
    public void shouldNavigateToLoginPage() {
        //When
        ModelAndView activityModelAndView = loginController.loginView();
        //Then
        assertThat(activityModelAndView.getViewName(), is("login"));
    }

    @Test
    public void shouldGetValueFromLoginPage(){
        final Map<String, String> myMap = new HashMap<String, String>();
         ModelAndView loginModelAndView = loginController.loginStatusView(myMap);
         assertThat(loginModelAndView.getViewName(), is("login"));

    }
}
