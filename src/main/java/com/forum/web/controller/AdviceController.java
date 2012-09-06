package com.forum.web.controller;

import com.forum.domain.Advice;
import com.forum.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Date;
import java.util.Map;

@Controller
public class AdviceController {
    public static final String USERNAME = "username";
    public static final String DESCRIPTION = "description";
    private AdviceService adviceService;
    public static final String SHOW_QUESTION_DETAILS = "question/view/";
    public static final String ERROR_PAGE = "500";
    public static final String QUESTION_ID = "questionId";

    @Autowired
    public AdviceController(AdviceService adviceService) {
        this.adviceService = adviceService;
    }

    @RequestMapping(value = "/postAdvice", method = RequestMethod.POST)
    public String saveAdvice(@Valid Advice advice, BindingResult result, Map model)  {
        if (result.hasErrors()) {
            return "redirect:" + SHOW_QUESTION_DETAILS + advice.getQuestionId();
        } else {
            advice.setCreatedAt(new Date());
            int succeed = adviceService.save(advice);
            if (succeed != 0) {
                return "redirect:" + SHOW_QUESTION_DETAILS + advice.getQuestionId();
            } else {
                return "redirect:" + ERROR_PAGE;
            }
        }
    }

}
