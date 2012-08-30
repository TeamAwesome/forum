package com.forum.service;

import com.forum.domain.Question;
import com.forum.repository.QuestionRepository;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuestionServiceTest {

    private QuestionService questionService;

    @Test
    public void shouldSaveQuestionToRepository(){
        Question question = new Question("Question Title", "Question Description", null, null);
        QuestionRepository mockQuestionRepository = mock(QuestionRepository.class);
        when(mockQuestionRepository.createQuestion(question)).thenReturn(1);
        questionService = new QuestionService(mockQuestionRepository);

        int questionUpdatedNumber = questionService.createQuestion(question);

        assertThat(questionUpdatedNumber, is(1));
    }
}
