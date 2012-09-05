package com.forum.web.controller;

import com.forum.domain.Advice;
import com.forum.service.AdviceService;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdviceControllerTest {

    private AdviceService mockAdviceService;
    private AdviceController adviceController;

    @Test
    public void shouldSaveAdviceAndShowQuestionDetails(){
        Map<String, String> model = new HashMap<String, String>();
        model.put(AdviceController.QUESTION_ID, "20");
        String username = "Jules";
        model.put(AdviceController.USERNAME, username);
        String description = "This is an advice for question 20";
        model.put(AdviceController.DESCRIPTION, description);
        Advice advice = new Advice(20,  username, description);
        mockAdviceService = mock(AdviceService.class);
        when(mockAdviceService.save(advice)).thenReturn(true);
        adviceController = new AdviceController(mockAdviceService);

        String url = adviceController.saveAdvice(model);

        assertThat(url, is(AdviceController.SHOW_QUESTION_DETAILS+"20"));
    }

    @Test
    public void shouldRejectWhenSaveAdviceFailed(){
        Map<String, String> model = new HashMap<String, String>();
        model.put(AdviceController.QUESTION_ID, "20");
        String username = "Jules";
        model.put(AdviceController.USERNAME, username);
        String description = "This is an advice for question 20";
        model.put(AdviceController.DESCRIPTION, description);
        Advice advice = new Advice(20, username, description);
        mockAdviceService = mock(AdviceService.class);
        when(mockAdviceService.save(advice)).thenReturn(false);
        adviceController = new AdviceController(mockAdviceService);

        String url = adviceController.saveAdvice(model);

        assertThat(url, is(AdviceController.ERROR_PAGE));
    }
}
