package com.forum.web.controller;

import com.forum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
        homeModelAndView.addObject("questions", questionService.latestQuestion(10));
        return homeModelAndView;
    }
//
//    List<Question> getQuestions(DataSource dataSource) {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        QuestionRowMapper rowMapper = new QuestionRowMapper();
//        questions = jdbcTemplate.query("select * from question1 order by date desc, time desc limit 10", rowMapper);
//        return questions;
//    }
}
