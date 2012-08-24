package com.forum.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class AdminController {

    @RequestMapping(value = "/adminDashboard", method = RequestMethod.GET)
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView("adminDashboard");
        modelAndView.addObject("month1","6");
        return modelAndView;
    }

    @RequestMapping(value = "/adminDashboard", method = RequestMethod.POST)
    public ModelAndView dashboard(@RequestParam Map<String, String> params) {
        ModelAndView modelAndView = new ModelAndView("adminDashboard");
        modelAndView.addObject("month",params.get("month.value"));
        return modelAndView;
    }
}
