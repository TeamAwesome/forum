package com.forum.service;

import com.forum.domain.Advice;
import com.forum.domain.Question;
import com.forum.repository.AdviceRepository;
import com.forum.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;
    private  TagService tagService;
    private AdviceRepository adviceRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Autowired
    public void setAdviceRepository(AdviceRepository adviceRepository){
        this.adviceRepository = adviceRepository;
    }

    public Question getById(Integer questionId) {
        Question question =  questionRepository.getById(questionId);
        List<Advice> advices = adviceRepository.getByQuestionId(questionId);
        question.setAdvices(advices);
        return question;
    }

    public int createQuestion(Question question) {
        return questionRepository.createQuestion(question);
    }

    public int addLikesById(Integer questionId) {
        return questionRepository.addLikesById(questionId);
    }

    @Transactional
    public List<Question> latestQuestion(String pageNum, String pageSize) {
        return questionRepository.latestQuestion(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
    }

    public int addDisLikesById(Integer questionId) {
        return questionRepository.addDisLikesById(questionId);
    }

    public int addFlagsByID(Integer questionId) {
        return questionRepository.addFlagsById(questionId);
    }

}
