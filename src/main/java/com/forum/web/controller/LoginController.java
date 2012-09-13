package com.forum.web.controller;

import com.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginController {

    @RequestMapping(value = "/errorLogin")
    public ModelAndView errorLoginView() {
        ModelAndView errorModelAndView = new ModelAndView("login");
        errorModelAndView.addObject("noticeMessage","<span style=\"color:red;\" >Invalid Username or Password.</span>");
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

    @RequestMapping(value = "/home")
    public String userHomeView(HttpServletRequest request) {
        if(request.isUserInRole("ROLE_ADMIN")){
            return "redirect: adminDashboard";
        }
        return "redirect:/";
    }
}


