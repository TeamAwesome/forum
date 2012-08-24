package com.forum.web.controller;

import com.forum.domain.Question;

import com.forum.service.QuestionService;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HomeControllerTest {
    @Test
    public void shouldDefaultToHomePage(){
        QuestionService questionService = mock(QuestionService.class);

        List<Question> questionList = new ArrayList<Question>();
        when(questionService.latestQuestion()).thenReturn(questionList);

        HomeController homeController = new HomeController(questionService);
        ModelAndView activityModelAndView = homeController.activityView();
        assertThat(activityModelAndView.getViewName(), is("home"));
    }
}
