package com.forum.web.controller;

import com.forum.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LoginControllerTest {

    private LoginController loginController;

    @Before
    public void setUp() {
        loginController = new LoginController();
    }

    @Test
    public void shouldForwardToAdminDashboardPageWhenUserInAdminRole() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addUserRole("ROLE_ADMIN");

        String viewName = loginController.userHomeView(request);

        assertThat(viewName, equalTo("redirect: adminDashboard"));
    }

    @Test
    public void shouldForwardToHomePageWhenUserInUserRole() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addUserRole("ROLE_USER");

        String viewName = loginController.userHomeView(request);

        assertThat(viewName, equalTo("redirect:/"));
    }

    @Test
    public void shouldForwardToHomePageWhenUserNotAuthenticated() {
        MockHttpServletRequest request = new MockHttpServletRequest();

        String viewName = loginController.userHomeView(request);

        assertThat(viewName, equalTo("redirect:/"));
    }

    @Test
    public void shouldThrowErrorMessageIfUserValidationFails() {
        ModelAndView errorModelAndView = loginController.errorLoginView();

        assertThat(errorModelAndView.getViewName(), is("login"));
        assertThat((String) errorModelAndView.getModel().get("noticeMessage"),is("<span style=\"color:red;\" >Invalid Username or Password.</span>"));
    }

    @Test
    public void shouldDisplayMessageOnSuccessfulLogout() {
        ModelAndView logoutModelAndView = loginController.logoutView();

        assertThat(logoutModelAndView.getViewName(), is("login"));
        assertThat((String) logoutModelAndView.getModel().get("noticeMessage"),is("You have successfully logged out."));
    }

    @Test
    public void shouldDisplayMessageWhenSessionInvalid() {
        ModelAndView invalidModelAndView = loginController.invalidView();

        assertThat(invalidModelAndView.getViewName(), is("login"));
        assertThat((String) invalidModelAndView.getModel().get("noticeMessage"),is("Session invalid, please login again."));
    }
}
