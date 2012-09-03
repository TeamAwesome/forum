package com.forum.web.controller;

import com.forum.service.AdminService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.*;

@Controller
public class AdminController {
    private AdminService adminService;
    private Gson gson;

    @Autowired
    public AdminController(AdminService adminService) {
        gson = new Gson();
        this.adminService = adminService;
    }


    @RequestMapping(value = "/adminDashboard", method = RequestMethod.GET)
    public ModelAndView dashboard(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("adminDashboard");
        String name = principal.getName();
        modelAndView.addObject("username", name);
        List<Integer> numberOfQuestions = adminService.getNumberOfQuestionsInNinetyDays();
        String numberOfQuestionsJson = gson.toJson(numberOfQuestions);
        modelAndView.addObject("numberOfQuestions", numberOfQuestionsJson);

        return modelAndView;
    }

    @RequestMapping(value = "/adminDashboard", method = RequestMethod.POST)
    public ModelAndView dashboard(@RequestParam Map<String, String> params) {
        ModelAndView modelAndView = new ModelAndView("adminDashboard");
        modelAndView.addObject("month", params.get("month.value"));
        return modelAndView;
    }

}
