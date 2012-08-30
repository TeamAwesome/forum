package com.forum.web.controller;

import com.forum.domain.Question;
import com.forum.service.QuestionService;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class QuestionControllerTest {

    private QuestionController questionController;

    @Test
    public void shouldShowPostQuestionPage(){
        this.questionController = new QuestionController(null);
        ModelAndView questionPageModelAndView = questionController.postQuestion();
        assertThat(questionPageModelAndView.getViewName() ,is("postQuestion"));
    }

    @Test
    public void shouldReturnPostedQuestion(){
        QuestionService mockedQuestionService = mock(QuestionService.class);
        Question question = new Question("Question Title", "Question Description", null, null);
        Map<String, String> params = new HashMap<String, String>();
        params.put("questionTitle", question.getTitle());
        params.put("questionDescription", question.getDescription());
        mockedQuestionService.createQuestion(question);
        this.questionController = new QuestionController(mockedQuestionService);

        ModelAndView questionModelAndView = questionController.showPostedQuestion(params);
        String questionTitle = (String)questionModelAndView.getModel().get("questionTitle");
        String questionDescription = (String)questionModelAndView.getModel().get("questionDescription");

        assertThat(questionTitle, is("Question Title"));
        assertThat(questionDescription, is("Question Description"));
    }
}
