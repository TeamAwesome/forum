package com.forum.web.controller;

import com.forum.domain.Advice;
import com.forum.service.AdviceService;

import java.util.Date;
import java.util.Map;

public class AdviceController {
    public static final String USERNAME = "username";
    public static final String DESCRIPTION = "description";
    private AdviceService adviceService;
    public static final String SHOW_QUESTION_DETAILS = "/question/view/";
    public static final String ERROR_PAGE = "500";
    public static final String QUESTION_ID = "questionId";

    public AdviceController(AdviceService adviceService) {
        this.adviceService = adviceService;
    }

    public String saveAdvice(Map model) {
        Advice advice = new Advice(Integer.parseInt((String) model.get(QUESTION_ID)), (String)model.get(USERNAME), (String)model.get(DESCRIPTION));
        boolean succeed =  adviceService.save(advice);
        if(succeed){
            return SHOW_QUESTION_DETAILS+model.get(QUESTION_ID);
        } else{
            return ERROR_PAGE;
        }
    }
}
