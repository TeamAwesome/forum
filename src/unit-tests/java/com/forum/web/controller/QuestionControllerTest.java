package com.forum.web.controller;


import com.forum.domain.Question;
import com.forum.domain.User;
import com.forum.service.QuestionService;
import com.forum.service.UserService;
import com.google.gson.Gson;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuestionControllerTest {

    private QuestionController questionController;
    private Principal principal;
    @Mock
    private QuestionService questionService;
    @Mock
    private UserService userService;

    @Test
    public void shouldShowPostQuestionPage() {
        this.questionController = new QuestionController(null, null);
        String questionView = questionController.postQuestion(new HashMap());
        assertThat(questionView, is("postQuestion"));
    }

    @Test
    public void shouldLoadLatestQuestionsOnBrowser(){
        List<Question> questions = new ArrayList<Question>();
        Date date = mock(Date.class);
        User user = new User();
        Question question = new Question(1,"dummy title","dummy description for a dummy question with a dummy title by a dummy developer", user,date);
        questions.add(question);
        when(questionService.latestQuestions("1", "1")).thenReturn(questions);

        String result = new QuestionController(questionService, null).retrieveLatestQuestions("1", "1");
        Gson gson = new Gson();
        Map map = (Map) gson.fromJson(result, ArrayList.class).get(0);

        assertThat((String) map.get("title"), Is.is("dummy title"));
    }

    @Test
    public void shouldReturnPostedQuestion() {
        User user = new User();
        user.setUsername("lu");
        Principal principalMock = mock(Principal.class);
        when(principalMock.getName()).thenReturn(user.getUsername());
        Question question = new Question(1, "Question Title", "Question Description", user, new Date());
        List<Question> questionList = new LinkedList<Question>();
        questionList.add(question);
        when(questionService.latestQuestions("1", "1")).thenReturn(questionList);
        when(questionService.getById(1)).thenReturn(question);

        questionService.createQuestion(question);
        this.questionController = new QuestionController(questionService, userService);

        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(false);

        String questionView = questionController.showPostedQuestion(question, result, new HashMap(), principalMock);

        assertThat(questionView, is("redirect:/question/view/" + question.getId()));
    }

    @Test
    public void shouldReturnToPostQuestionWhenInvalid() {
        Date createdAt = new Date();
        Question question = new Question(1, "Question Title", "Question Description", new User(), createdAt);

        this.questionController = new QuestionController(questionService, null);

        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(true);

        String questionView = questionController.showPostedQuestion(question, result, new HashMap(), principal);

        assertThat(questionView, is("postQuestion"));
    }

    @Test
    public void shouldReturnDetailedViewOfQuestion() {
        ModelAndView modelAndView;
        User user = new User();
        user.setName("Dummy User");
        Date createdAt = new Date();
        Question question = new Question(42, "model question title", "model question description", user, createdAt);
        when(questionService.getById(42)).thenReturn(question);
        this.questionController = new QuestionController(questionService, null);

        modelAndView = questionController.viewQuestionDetail(42);
        String questionTitle = (String) modelAndView.getModel().get("questionTitle");
        String questionDescription = (String) modelAndView.getModel().get("questionDescription");
        String questionDate = (String) modelAndView.getModel().get("dateCreatedAt");
        String questionTime = (String) modelAndView.getModel().get("timeCreatedAt");
        String questionUserName = (String) modelAndView.getModel().get("username");

        assertThat(questionTitle, is("model question title"));
        assertThat(questionDescription, is("model question description"));
        assertThat(questionDate, is(new SimpleDateFormat("MMMM dd, yyyy").format(createdAt)));
        assertThat(questionTime, is(new SimpleDateFormat("hh:mm:ss a").format(createdAt)));
        assertThat(questionUserName, is(user.getName()));

    }

    @Test
    public void shouldReturnDetailedViewOfQuestionWithLikesDisLikesAndFlags() {
        ModelAndView modelAndView;
        User user = new User();
        user.setName("Dummy User");
        Date createdAt = new Date();
        Question question = new Question(100, "model question title", "model question description", user, createdAt, 10, 10, 10);
        when(questionService.getById(100)).thenReturn(question);
        this.questionController = new QuestionController(questionService, null);

        modelAndView = questionController.viewQuestionDetail(100);
        Integer questionLikes = (Integer) modelAndView.getModel().get("likes");
        Integer questionDisLikes = (Integer) modelAndView.getModel().get("dislikes");
        Integer questionFlags = (Integer) modelAndView.getModel().get("flags");

        assertThat(questionLikes, is(question.getLikes()));
        assertThat(questionDisLikes, is(question.getDislikes()));
        assertThat(questionFlags, is(question.getFlags()));

    }

    @Test
    public void shouldLikeQuestion() {
        int likes = 1;
        prepareQuestionController(likes, 2, 3);

        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("likes", likes);

        String result = questionController.likeQuestion(24, params);
        assertThat(result, is("(" + (likes + 1) + ") Likes"));
    }

    @Test
    public void shouldDisLikeQuestion() {
        int dislikes = 1;
        prepareQuestionController(1, dislikes, 3);

        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("dislikes", dislikes);

        String result = questionController.dislikeQuestion(24, params);
        assertThat(result, is("(" + (dislikes + 1) + ") Dislikes"));
    }

    @Test
    public void shouldFlagQuestion() {
        int flags = 1;
        prepareQuestionController(1, 2, flags);

        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("flags", flags);

        String result = questionController.flagQuestion(24, params);
        assertThat(result, is("(" + (flags + 1) + ") Flags"));
    }

    private void prepareQuestionController(int likes, int dislikes, int flags) {
        Question question = new Question(
                24,
                "model question title",
                "model question description",
                new User(),
                new Date(),
                likes + 1,
                dislikes + 1,
                flags + 1);
        when(questionService.getById(24)).thenReturn(question);
        this.questionController = new QuestionController(questionService, null);
    }

}
