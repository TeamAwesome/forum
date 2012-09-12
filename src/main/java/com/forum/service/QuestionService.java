package com.forum.service;

import com.forum.domain.Advice;
import com.forum.domain.Question;
import com.forum.repository.AdviceRepository;
import com.forum.repository.QuestionRepository;
import com.forum.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service
public class QuestionService {

    private  static Logger logger = Logger.getLogger(QuestionService.class.getName());
    private QuestionRepository questionRepository;
    private TagRepository tagRepository;
    private AdviceRepository adviceRepository;


    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Autowired
    public void setAdviceRepository(AdviceRepository adviceRepository){
        this.adviceRepository = adviceRepository;
    }

    @Autowired
    public void setTagRepository(TagRepository tagRepository){
        this.tagRepository = tagRepository;
    }

    public Question getById(Integer questionId) {
        Question question =  questionRepository.getById(questionId);
        logger.info("this is the question from repository\n" + question.toString());

        List<Advice> advices = adviceRepository.getByQuestionId(questionId);
        question.setAdvices(advices);
        return question;
    }
    @Transactional
    public int createQuestion(Question question) {
        return questionRepository.createQuestion(question);
    }

    public int addLikesById(Integer questionId) {
        return questionRepository.addLikesById(questionId);
    }

    @Transactional
    public List<Question> latestQuestions(String pageNum, String pageSize) {
        List<Question> questionList = questionRepository.latestQuestion(Integer.parseInt(pageNum), Integer.parseInt(pageSize));
        return removeSpaces(questionList);
    }

    public int addDisLikesById(Integer questionId) {
        return questionRepository.addDisLikesById(questionId);
    }

    public int addFlagsByID(Integer questionId) {
        return questionRepository.addFlagsById(questionId);
    }

    public List<Question> getByTagValue(String tagValue) {
        return questionRepository.getByTag(tagValue);
    }

    List<Question> removeSpaces(List<Question> questionList) {
        for(Question question: questionList){
            question.setDescription(question.getDescription().trim());
        }
        return questionList;
    }
}
