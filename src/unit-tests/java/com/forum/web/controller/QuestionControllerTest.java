package com.forum.web.controller;


import com.forum.domain.Question;
import com.forum.domain.User;
import com.forum.service.QuestionService;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    @Test
    public void shouldReturnDetailedViewOfQuestion(){
        QuestionService questionService = mock(QuestionService.class);
        ModelAndView modelAndView;
        User user = new User();
        user.setName("Dummy User");
        Date createdAt = new Date();
        Question question = new Question(42,"model question title","model question description", user, createdAt);
        when(questionService.getById(42)).thenReturn(question);
        this.questionController = new QuestionController(questionService);

        modelAndView = questionController.viewQuestionDetail(42);
        String questionTitle = (String)modelAndView.getModel().get("questionTitle");
        String questionDescription = (String)modelAndView.getModel().get("questionDescription");
        String questionDate = (String)modelAndView.getModel().get("dateCreatedAt");
        String questionTime = (String)modelAndView.getModel().get("timeCreatedAt");
        String questionUserName = (String)modelAndView.getModel().get("username");

        assertThat(questionTitle, is("model question title"));
        assertThat(questionDescription, is("model question description"));
        assertThat(questionDate, is(new SimpleDateFormat("MMMM dd,yyyy").format(createdAt)));
        assertThat(questionTime, is(new SimpleDateFormat("hh:mm:ss a").format(createdAt)));
        assertThat(questionUserName, is(user.getName()));

    }


}
