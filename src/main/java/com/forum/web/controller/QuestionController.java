package com.forum.web.controller;

import com.forum.domain.Question;
import com.forum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/postQuestion", method = RequestMethod.GET)
    public ModelAndView postQuestion() {
        return new ModelAndView("postQuestion");
    }

    @RequestMapping(value = "/showPostedQuestion", method = RequestMethod.POST)
    public ModelAndView showPostedQuestion(@RequestParam Map<String, String> params){

        ModelAndView modelAndView = new ModelAndView("showPostedQuestion");
        modelAndView.addObject("questionTitle",params.get("questionTitle"));
        modelAndView.addObject("questionDescription",params.get("editor"));
        return modelAndView;
    }

    @RequestMapping(value = "/question/view/{questionId}", method = RequestMethod.GET)
    public ModelAndView viewQuestionDetail(@PathVariable Integer questionId) {
        Question question = questionService.getById(questionId);
        ModelAndView modelAndView = new ModelAndView("questionDetail");
        modelAndView.addObject("questionTitle", question.getTitle());
        modelAndView.addObject("questionDescription", question.getDescription());
        modelAndView.addObject("userID", question.getUserId());
        modelAndView.addObject("createdAt", question.getCreatedAt());
        modelAndView.addObject("likes", question.getLikes());
        modelAndView.addObject("dislikes", question.getDislikes());
        modelAndView.addObject("views", question.getViews());
        modelAndView.addObject("flags", question.getFlags());


        return modelAndView;
    }
}
