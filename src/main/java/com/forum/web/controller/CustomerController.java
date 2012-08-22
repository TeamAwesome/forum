package com.forum.web.controller;

import com.forum.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/customers")
    public ModelAndView customerView() {
        ModelAndView modelAndView = new ModelAndView("customers");
        modelAndView.getModel().put("customerList", customerService.all());
        return modelAndView;
    }
}
