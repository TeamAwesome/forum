package com.forum.web.controller;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserControllerTest {


    @Test
    public void shouldNavigateToJoinPage() {

        //Given
        UserController userController = new UserController();

        //When
        ModelAndView activityModelAndView = userController.activityView();

        //Then
        assertThat(activityModelAndView.getViewName(), is("join"));
    }


}
