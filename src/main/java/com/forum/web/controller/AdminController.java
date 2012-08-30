package com.forum.web.controller;
import com.forum.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Controller
public class AdminController{

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping(value = "/adminDashboard", method = RequestMethod.GET)
    public ModelAndView dashboard() {

        ModelAndView modelAndView = new ModelAndView("adminDashboard");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,00);
        cal.set(Calendar.MINUTE,00);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND,0);
        Date date = cal.getTime();
        Integer numberOfQuestion = adminService.getNumberOfQuestionInADay(date);
        modelAndView.addObject("month1", numberOfQuestion.toString());
        return modelAndView;
    }

    @RequestMapping(value = "/adminDashboard", method = RequestMethod.POST)
    public ModelAndView dashboard(@RequestParam Map<String, String> params) {
        ModelAndView modelAndView = new ModelAndView("adminDashboard");
        modelAndView.addObject("month",params.get("month.value"));
        return modelAndView;
    }


}
