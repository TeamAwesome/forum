package com.forum.web.controller;


import com.forum.domain.Question;
import com.forum.domain.User;
import com.forum.service.QuestionService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
public class QuestionController {

    private QuestionService questionService;
    private Logger logger = Logger.getLogger(QuestionController.class.getName());


    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;

    }

    @RequestMapping(value = "/postQuestion", method = RequestMethod.GET)
    public ModelAndView postQuestion() {
        ModelAndView modelAndView=new ModelAndView("postQuestion");
        return modelAndView;
    }

    @RequestMapping(value = "/showPostedQuestion", method = RequestMethod.POST)
    public ModelAndView showPostedQuestion(@RequestParam Map<String, String> params){
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        Question question = new Question(params.get("questionTitle"), params.get("questionDescription"), new User(), timestamp);
        questionService.createQuestion(question);
        List latestQuestionList = questionService.latestQuestion("1","1");
        Question latestQuestion = (Question)latestQuestionList.get(0);
        Integer questionId = latestQuestion.getId();
        System.out.println(questionId);

        ModelAndView modelAndView = new ModelAndView("showPostedQuestion");
        modelAndView.addObject("questionTitle",params.get("questionTitle"));
        modelAndView.addObject("questionDescription",params.get("questionDescription"));
        return viewQuestionDetail(questionId);
    }

    @RequestMapping(value = "/question/view/{questionId}", method = RequestMethod.GET)
    public ModelAndView viewQuestionDetail(@PathVariable Integer questionId) {
        Question question = questionService.getById(questionId);
        ModelAndView modelAndView = new ModelAndView("questionDetail");
        modelAndView.addObject("questionId", question.getId());
        modelAndView.addObject("questionTitle", question.getTitle());
        modelAndView.addObject("questionDescription", question.getDescription());
        modelAndView.addObject("username", question.getUser().getName());
        modelAndView.addObject("dateCreatedAt", new SimpleDateFormat("MMMM dd,yyyy").format(question.getCreatedAt()));
        modelAndView.addObject("timeCreatedAt", new SimpleDateFormat("hh:mm:ss a").format(question.getCreatedAt()));
        modelAndView.addObject("likes", question.getLikes());
        modelAndView.addObject("dislikes", question.getDislikes());
        modelAndView.addObject("views", question.getViews());
        modelAndView.addObject("flags", question.getFlags());
        modelAndView.addObject("responses", question.getResponses());
        return modelAndView;
    }

    @RequestMapping(value = "/question/like/{questionId}", method = RequestMethod.POST)
    @ResponseBody
    public String likeQuestion(@PathVariable Integer questionId, @RequestParam Map<String, Integer> params) {
        questionService.addLikesById(questionId);
        Question question = questionService.getById(questionId);
        return "(" + question.getLikes() + ") Likes";
    }

    @RequestMapping(value = "/question/dislike/{questionId}", method = RequestMethod.POST)
    @ResponseBody
    public String dislikeQuestion(@PathVariable Integer questionId, @RequestParam Map<String, Integer> params) {
        questionService.addDisLikesById(questionId);
        Question question = questionService.getById(questionId);
        return "(" + question.getDislikes() + ") Dislikes";
    }

    @RequestMapping(value = "/question/flag/{questionId}", method = RequestMethod.POST)
    @ResponseBody
    public String flagQuestion(@PathVariable Integer questionId, @RequestParam Map<String, Integer> params) {
        questionService.addFlagsByID(questionId);
        Question question = questionService.getById(questionId);
        return "(" + question.getFlags() + ") Flags";
    }

}
