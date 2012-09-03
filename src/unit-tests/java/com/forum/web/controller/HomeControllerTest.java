package com.forum.web.controller;

import com.forum.domain.Question;
import com.forum.domain.User;
import com.forum.service.QuestionService;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HomeControllerTest {

    private QuestionService questionService;
    private HomeController homeController;
    @Before
    public void setup(){
        this.questionService = mock(QuestionService.class);
        this.homeController = new HomeController(questionService);
    }

    @Test
    public void shouldDefaultToHomePage(){
        ModelAndView activityModelAndView = homeController.activityView();
        assertThat(activityModelAndView.getViewName(), is("home"));
    }

    @Test
    public void shouldLoadMoreQuestionsOnBrowser(){
        List<Question> questions = new ArrayList<Question>();
        Date date = mock(Date.class);
        User user = new User();
        Question question = new Question(1,"dummy title","dummy description for a dummy question with a dummy title by a dummy developer", user,date);
        questions.add(question);
        when(questionService.latestQuestion("1","1")).thenReturn(questions);

        String result = homeController.loadMoreQuestions("1","1");
        Gson gson = new Gson();
        Map map = (Map) gson.fromJson(result, ArrayList.class).get(0);

        assertThat((String) map.get("title"), is("dummy title"));
    }

}
