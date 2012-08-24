package com.forum.web.controller;


import com.forum.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class UserController {


    @RequestMapping("/join")
    public ModelAndView registerView() {
        return new ModelAndView("join");
    }


    @RequestMapping(value = "/showprofile", method = RequestMethod.POST)
    public ModelAndView showProfile(@RequestParam Map<String, String> params){

        User user = new User(params.get("username"), params.get("password"), params.get("name"),
                params.get("email"), params.get("phoneNumber"), params.get("country"),
                params.get("gender"), Integer.parseInt(params.get("age")));

        ModelAndView modelAndView = new ModelAndView("showprofile");
        modelAndView.addObject("username",user.getUsername());
        modelAndView.addObject("name", params.get("name"));
        return modelAndView;

    }

    public Boolean validatePasswordLength(String password) {
        if(password.length() < 8)
            return false;
        return true;
    }

    public Boolean validateConfirmPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }
}
