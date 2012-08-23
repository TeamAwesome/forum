package com.forum.service;

import com.forum.repository.QuestionRepository;
import org.junit.Before;
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
        Map<String,String> params = new HashMap<String,String>();
        QuestionRepository mockQuestionRepository = mock(QuestionRepository.class);
        when(mockQuestionRepository.saveQuestion(params)).thenReturn(true);
        questionService = new QuestionService(mockQuestionRepository);



        boolean hasBeenSaved = questionService.saveQuestion(params);

        assertThat(hasBeenSaved, is(true));
    }
}
