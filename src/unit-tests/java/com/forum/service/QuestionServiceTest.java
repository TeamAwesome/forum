

package com.forum.service;


import com.forum.domain.Advice;
import com.forum.domain.Question;
import com.forum.domain.Tag;
import com.forum.domain.User;
import com.forum.repository.AdviceRepository;
import com.forum.repository.QuestionRepository;
import com.forum.repository.TagRepository;
import com.forum.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuestionServiceTest {

    private QuestionService questionService;
    private QuestionRepository questionRepository;
    private AdviceRepository adviceRepository;
    private UserRepository userRepository;
    private TagRepository tagRepository;

    @Before
    public void setup(){
        questionRepository = mock(QuestionRepository.class);
        adviceRepository = mock(AdviceRepository.class);
        tagRepository = mock(TagRepository.class);
        questionService = new QuestionService(questionRepository);
        questionService.setAdviceRepository(adviceRepository);
        questionService.setTagRepository(tagRepository);

    }


    @Test
    public void shouldSaveQuestionToRepository(){

        Question question = new Question("Question Title", "Question Description", null, null);
        QuestionRepository mockQuestionRepository = mock(QuestionRepository.class);
        when(mockQuestionRepository.createQuestion(question)).thenReturn(1);
        questionService = new QuestionService(mockQuestionRepository);


        int questionUpdatedNumber = questionService.createQuestion(question);

        assertThat(questionUpdatedNumber, is(1));
    }

    @Test
    public void shouldReturnQuestionBasedOnId(){
        Question question = new Question(42,"mock question title","mock question description",new User(),new Date());
        when(questionRepository.getById(42)).thenReturn(question);

        ArrayList<Advice> advices = new ArrayList<Advice>();
        advices.add(new Advice());
        when(adviceRepository.getByQuestionId(42)).thenReturn(advices);
        questionService.setAdviceRepository(adviceRepository);
        Question expectedQuestion = questionService.getById(42);

        assertThat(expectedQuestion, is(question));
    }

    @Test
    public void shouldReturnLatestQuestions(){
        List<Question> questions = new ArrayList<Question>();
        when(questionRepository.latestQuestion(1,10)).thenReturn(questions);

        List<Question> returnedList = questionService.latestQuestions("1", "10");

        assertThat(returnedList, is(questions));
    }

    @Test
    public void shouldUpdateLikeOfAQuestion(){
        Question question = new Question(100,"Question Title", "Question Description", null, null,0,0,0);
        QuestionRepository mockQuestionRepository = mock(QuestionRepository.class);
        when(mockQuestionRepository.addLikesById(100)).thenReturn(1);
        questionService = new QuestionService(mockQuestionRepository);

        int numberOfRowsEffected = questionService.addLikesById(question.getId());

        assertThat(numberOfRowsEffected, is(1));
    }
    @Test
    public void shouldUpdateDisLikeOfAQuestion(){
        Question question = new Question(100,"Question Title", "Question Description", null, null,0,0,0);
        QuestionRepository mockQuestionRepository = mock(QuestionRepository.class);
        when(mockQuestionRepository.addDisLikesById(100)).thenReturn(1);
        questionService = new QuestionService(mockQuestionRepository);

        int numberOfRowsEffected = questionService.addDisLikesById(question.getId());

        assertThat(numberOfRowsEffected, is(1));
    }
    @Test
    public void shouldUpdateFlagsOfAQuestion(){
        Question question = new Question(100,"Question Title", "Question Description", null, null,0,0,0);
        QuestionRepository mockQuestionRepository = mock(QuestionRepository.class);
        when(mockQuestionRepository.addFlagsById(100)).thenReturn(1);
        questionService = new QuestionService(mockQuestionRepository);

        int numberOfRowsAffected = questionService.addFlagsByID(question.getId());

        assertThat(numberOfRowsAffected, is(1));
    }

    @Test
    public void shouldRemoveExtraSpacesInDescription(){
        List<Question> questionList = new ArrayList<Question>();
        Question question = new Question(100,"Question Title", " Question Description", null, null,0,0,0);
        Question question1 = new Question(101,"Question Title", "Question Description 1", null, null,0,0,0);
        questionList.add(question);
        questionList.add(question1);

        List<Question> questionResultList = questionService.removeSpaces(questionList);
        assertThat(questionResultList.get(0).getDescription(),is("Question Description"));
        assertThat(questionResultList.get(1).getDescription(),is("Question Description 1"));
    }

    @Test
    public void shouldReturnUsername(){
        User user = new User("lu", "pass", "Tom Tom", "tom@tom.com", "1234567",
                "Moon", "He doesn't know", 200, false);
        userRepository = mock(UserRepository.class);
        when(userRepository.getByUsername("lu")).thenReturn(user);
        assertThat(user.getUsername(), is("lu"));
    }

    @Test
    public void shouldReturnTagAsString() {
        Question question = new Question(212,"Test Data","Dont Consider me as a Data", new User(),new Date());
        question.setTagsAsString("tags,test,display");
        when(questionRepository.getById(212)).thenReturn(question);
        when(adviceRepository.getByQuestionId(212)).thenReturn(new ArrayList<Advice>());
        when(tagRepository.getTagByQuestionId(212)).thenReturn(new ArrayList<Tag>());
        Question expected = questionService.getById(212);


        assertThat(expected.getTagsAsString(),is("tags,test,display,"));
    }

    @Test
    public void shouldReturnEmptyTagsWhenPassedNull() {
        Question question = new Question(212,"Test Data","Dont Consider me as a Data", new User(),new Date());
        question.setTagsAsString("");
        when(questionRepository.getById(212)).thenReturn(question);
        when(adviceRepository.getByQuestionId(212)).thenReturn(new ArrayList<Advice>());
        when(tagRepository.getTagByQuestionId(212)).thenReturn(new ArrayList<Tag>());
        Question expected = questionService.getById(212);


        assertThat(expected.getTagsAsString(),is(","));
    }
}
