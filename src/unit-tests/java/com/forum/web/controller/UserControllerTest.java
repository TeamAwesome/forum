package com.forum.web.controller;

import com.forum.service.UserService;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class UserControllerTest {


    @Test
    public void shouldNavigateToJoinPage() {
        UserService userService = mock(UserService.class);
        UserController userController = new UserController(userService);
        Map map = new HashMap();
        String activityModelAndView = userController.showRegistrationForm(map);

        //Then
        assertThat(activityModelAndView, is("join"));
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
