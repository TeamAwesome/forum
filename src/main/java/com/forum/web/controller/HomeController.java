package com.forum.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//TODO: this controller is not necessary
@Controller
public class  HomeController {

    @RequestMapping("/")
    public ModelAndView activityView() {
        return new ModelAndView("home");
    }

}
