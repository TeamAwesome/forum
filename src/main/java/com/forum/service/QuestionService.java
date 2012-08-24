package com.forum.service;

import com.forum.domain.Question;
import com.forum.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Transactional
    public List<Question> latestQuestion(int number) {
        return questionRepository.latestQuestion(number);
    }

    @Transactional
    public List<Question> latestQuestion() {
        return questionRepository.latestQuestion(10);
    }

    public Question getById(Integer questionId) {
        return questionRepository.getById(questionId);
    }

    public boolean saveQuestion(Map<String, String> params) {
        return questionRepository.saveQuestion(params);

    }

    @Transactional
    public List<Question> latestQuestion(String pageNum, String pageSize) {
        return questionRepository.latestQuestion(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
    }
}
