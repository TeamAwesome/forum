package com.forum.web.controller;

import com.forum.domain.Question;
import com.forum.repository.QuestionRowMapper;
import com.forum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;
import java.util.List;

@Controller
public class HomeController {


    private QuestionService questionService;

    @Autowired
    public HomeController(QuestionService questionService){
        this.questionService = questionService;
    }

    @RequestMapping("/")
    public ModelAndView activityView() {
        ModelAndView homeModelAndView = new ModelAndView("home");
        homeModelAndView.addObject("questions", questionService.latestQuestion());
        return homeModelAndView;
    }

}
