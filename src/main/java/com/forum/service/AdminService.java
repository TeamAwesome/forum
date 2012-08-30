package com.forum.service;

import com.forum.domain.Question;
import com.forum.repository.QuestionRepository;

import java.util.*;
import java.util.logging.Logger;

public class AdminService {
    private QuestionRepository questionRepository;
    private static Logger logger = Logger.getLogger(AdminService.class.getName());

    public AdminService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Integer getTotalNumberOfQuestions() {
        return questionRepository.getAllQuestions().size();
    }
}
