package com.forum.web.controller;


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

//    @RequestMapping(value = "/showprofile", method = RequestMethod.POST)
//    public ModelAndView showProfile(@RequestParam Map<String, String> params){
//
//        ModelAndView modelAndView = new ModelAndView("showprofile");
//        modelAndView.addObject("username",params.get("username"));
//        modelAndView.addObject("name",params.get("name"));
//        return modelAndView;
//
//    }

}
