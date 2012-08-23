package com.forum.service;

import com.forum.repository.QuestionRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuestionServiceTest {

    private QuestionService questionService;
    QuestionRepository mockQuestionRepository = mock(QuestionRepository.class);

    @Before
    public void setup(){
        questionService = new QuestionService(mockQuestionRepository);
    }


}
