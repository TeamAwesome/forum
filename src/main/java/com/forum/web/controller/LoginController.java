package com.forum.web.controller;

import com.forum.domain.User;
import com.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;


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


//    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView validateForm(@RequestParam Map<String, String> params, HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView("login");
        boolean flag = false;
        if (params.get(USERNAME).equals("")) {
            modelAndView.addObject("usernameError", "Please Enter a Valid Username");
            flag = true;
        }
        if (params.get(PASSWORD).equals("")) {
            modelAndView.addObject("passwordError", "Please Enter a Valid Password");
            flag = true;
        }
        if (!flag) {
            User user = new User();
            user.setUsername(params.get(USERNAME));
            user.setPassword(params.get(PASSWORD));
            if (userService.getValidation(user)) {
                modelAndView = new ModelAndView("redirect:/postQuestion");
                HttpSession session = request.getSession(true);
                session.setAttribute(USERNAME, params.get(USERNAME));
                System.out.print(session.getAttribute(USERNAME));

            } else {
                modelAndView.addObject("messageToBeDisplayed", "Enter a Correct Username or Password");
            }
        }
        return modelAndView;
    }
}


