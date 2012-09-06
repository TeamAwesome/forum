package com.forum.web.controller;

import com.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    private UserService userService;


    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/login")
    public ModelAndView loginView() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/errorLogin")
    public ModelAndView errorLoginView() {
        ModelAndView errorModelAndView = new ModelAndView("login");
        errorModelAndView.addObject("noticeMessage","<span style=\"color:red;\" >Invalid Username or Password.</spam>");
        return errorModelAndView;
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logoutView() {
        ModelAndView logoutModelAndView = new ModelAndView("login");
        logoutModelAndView.addObject("noticeMessage", "You have successfully logged out.");
        return logoutModelAndView;
    }

    @RequestMapping(value = "/invalid")
    public ModelAndView invalidView() {
        ModelAndView invalidModelAndView = new ModelAndView("login");
        invalidModelAndView.addObject("noticeMessage", "Session invalid, please login again.");
        return invalidModelAndView;
    }
}


