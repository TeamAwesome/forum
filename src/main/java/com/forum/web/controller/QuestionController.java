package com.forum.web.controller;


import com.forum.domain.Advice;
import com.forum.domain.Question;
import com.forum.domain.User;
import com.forum.service.QuestionService;
import com.forum.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
public class QuestionController {

    private QuestionService questionService;
    private UserService userService;
    private static final Logger logger = Logger.getLogger(QuestionController.class.getName());


    @Autowired
    public QuestionController(QuestionService questionService, UserService userService) {
        this.questionService = questionService;
        this.userService = userService;
    }

    @RequestMapping(value = "/postQuestion", method = RequestMethod.GET)
    public String postQuestion(Map model) {
        model.put("question", new Question());
        return "postQuestion";
    }

    @RequestMapping(value = "/showPostedQuestion", method = RequestMethod.POST)
    public String showPostedQuestion(@Valid Question question, BindingResult result, Map model, Principal principal) {
        if(principal==null)
            return "redirect: invalid";
        if (result.hasErrors()) {
            return "postQuestion";
        }
        String username = principal.getName();
        User user = userService.getByUserName(username);
        question.setUser(user);

        questionService.createQuestion(question);

        List latestQuestionList = questionService.latestQuestions("1", "1");
        Question latestQuestion = (Question) latestQuestionList.get(0);
        Integer questionId = latestQuestion.getId();

        return "redirect:/question/view/" + questionId;
    }

    @RequestMapping(value = "/question/viewAndPost/{questionId}", method = RequestMethod.GET)
    public ModelAndView viewQuestionAndPostDetail(@PathVariable Integer questionId) {
        return viewQuestionDetail(questionId);
    }

    @RequestMapping(value = "/question/view/{questionId}", method = RequestMethod.GET)
    public ModelAndView viewQuestionDetail(@PathVariable Integer questionId) {
        Question question = questionService.getById(questionId);
        ModelAndView modelAndView = new ModelAndView("questionDetail");
        modelAndView.addObject("question", question);
        modelAndView.addObject("dateCreatedAt", new SimpleDateFormat("MMMM dd, yyyy").format(question.getCreatedAt()));
        modelAndView.addObject("timeCreatedAt", new SimpleDateFormat("hh:mm:ss a").format(question.getCreatedAt()));
        modelAndView.addObject("advice", new Advice(0, null, ""));
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

    @RequestMapping(value = "/question/search/latest", method = RequestMethod.POST)
    @ResponseBody
    public String retrieveLatestQuestions(@RequestParam String pageNum, @RequestParam String pageSize) {
        List<Question> questionList = questionService.latestQuestions(pageNum, pageSize);
        return new Gson().toJson(questionList);
    }

    @RequestMapping(value = "/question/search/tag/{value}", method = RequestMethod.POST)
    @ResponseBody
    public String getQuestionsWithTagValue(@PathVariable String value) {
        logger.info("Come into this function.");
        List<Question> questions = questionService.getByTagValue(value);
        return new Gson().toJson(questions);
    }

    @RequestMapping(value = "/tags/{tagValue}", method = RequestMethod.GET)
    public ModelAndView showResultsForTag(@PathVariable String tagValue) {
            return new ModelAndView("questionWithTag").addObject("tagName", tagValue);
    }
}
