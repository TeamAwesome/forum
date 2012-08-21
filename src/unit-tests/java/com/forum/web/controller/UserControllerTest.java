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


    @Test
    public void shouldNotAllowPasswordUnder8Characters(){
        //Given
        UserController userController = new UserController();
        Map<String, String> params = new HashMap<String, String>();
        params.put("password", "less");

        //When
        Boolean result = userController.validatePasswordLength(params.get("password"));

        //Then
        assertThat(result, is(false));
    }

    @Test
    public void passwordShouldMatchConfirmPassword(){
        //Given
        UserController userController = new UserController();
        Map<String, String> params = new HashMap<String, String>();
        params.put("password", "thispassword");
        params.put("confirmPassword", "thatpassword");

        //When
        Boolean result = userController.validateConfirmPassword(params.get("password"), params.get("confirmPassword"));

        //Then
        assertThat(result, is(false));
    }

//    @Test
//    public void shouldGetUsername(){
//        //Given
//        UserController userController = new UserController();
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("username", "Tester");
//        String testUsername = "";
//        //When
//        testUsername = userController.;
//        //Then
//        assertThat(testUsername, is("Tester"));
//
//    }






}
