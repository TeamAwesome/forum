package com.forum.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class StaticController {

    @RequestMapping("/terms")
    public ModelAndView registerTerms() {
        return new ModelAndView("terms");
    }
}
