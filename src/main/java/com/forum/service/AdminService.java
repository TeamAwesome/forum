package com.forum.service;

import com.forum.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;

@Service
public class AdminService {
    private QuestionRepository questionRepository;
    private static Logger logger = Logger.getLogger(AdminService.class.getName());

    @Autowired
    public AdminService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Integer getTotalNumberOfQuestions() {
        return questionRepository.getAllQuestions().size();
    }


    public int getNumberOfQuestionInADay(Date date) {
        return questionRepository.getNumberOfQuestionInADay(date);
    }
}
