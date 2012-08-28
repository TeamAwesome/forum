package com.forum.web.controller;


import com.forum.domain.Country;
import com.forum.domain.User;
import com.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/join",method = RequestMethod.GET)
    public String showRegistrationForm(Map model) {
        List<Country> countries = userService.getAvailableCountries();
        User user = new User();
        model.put("user", user);
        model.put("countries", countries);
        return "join";
    }

    @RequestMapping(value = "submitInfo", method = RequestMethod.POST)
    public String processRegistrationForm(@Valid User user,  BindingResult result, Map model) {
        if (result.hasErrors()) {
            return "join";
        }
         model.put("user", user);
         return "showProfile";
    }
}
