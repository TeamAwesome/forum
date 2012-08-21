package com.forum.web.controller;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserControllerTest {


    @Test
    public void shouldNavigateToJoinPage() {

        //Given
        UserController userController = new UserController();

        //When
        ModelAndView activityModelAndView = userController.registerView();

        //Then
        assertThat(activityModelAndView.getViewName(), is("join"));
    }

//    @Test
//    public void shouldRedirectedToShowProfilePage() {
//
//        //Given
//        UserController userController = new UserController();
//        Map<String, String> expectedMap = new HashMap<String, String>();
//        expectedMap.put("username", "arun");
//        expectedMap.put("name", "tosin");
//        //When
//        ModelAndView activityModelAndView = userController.showProfile(expectedMap);
//
//        //Then
//        assertThat(activityModelAndView.getViewName(), is("join"));
//    }



}
