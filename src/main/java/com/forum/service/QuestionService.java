package com.forum.service;

import com.forum.domain.Question;
import com.forum.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question getById(Integer questionId) {
        return questionRepository.getById(questionId);
    }

    public int createQuestion(Question question) {
        return questionRepository.createQuestion(question);
    }

    @Transactional
    public List<Question> latestQuestion(String pageNum, String pageSize) {
        return questionRepository.latestQuestion(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
    }

}
