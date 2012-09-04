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

    @Test
    public void shouldThrowErrorMessageIfUserValidationFails() {
        ModelAndView errorModelAndView = loginController.errorLoginView();

        assertThat(errorModelAndView.getViewName(), is("login"));
    }

//    @Test
//    public void shouldRejectLoginWithEmptyUsername() {
//        Map userMap = new HashMap();
//        HttpServletRequest mockHttpServletRequest = mock(HttpServletRequest.class);
//        userMap.put(LoginController.USERNAME, "");
//        userMap.put(LoginController.PASSWORD, "QWERTY");
//
//        ModelAndView modelAndView = loginController.validateForm(userMap, mockHttpServletRequest);
//
//        assertThat(modelAndView.getViewName(), is("login"));
//        Map<String, Object> expectedModel = modelAndView.getModel();
//        assertThat((String) expectedModel.get("usernameError"), is("Please Enter a Valid Username"));
//    }
//
//    @Test
//    public void shouldRejectLoginWithEmptyPassword() {
//        Map userMap = new HashMap();
//        HttpServletRequest mockHttpServletRequest = mock(HttpServletRequest.class);
//        userMap.put(LoginController.USERNAME, "lu");
//        userMap.put(LoginController.PASSWORD, "");
//
//        ModelAndView modelAndView = loginController.validateForm(userMap, mockHttpServletRequest);
//
//        assertThat(modelAndView.getViewName(), is("login"));
//        Map<String, Object> expectedModel = modelAndView.getModel();
//        assertThat((String) expectedModel.get("passwordError"), is("Please Enter a Valid Password"));
//    }
}
