package com.forum.web.controller;

import com.forum.domain.Advice;
import com.forum.domain.User;
import com.forum.service.AdviceService;
import com.forum.service.UserService;
import org.junit.Test;
import org.springframework.validation.BindingResult;

import java.security.Principal;
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
        String username = "Jules";
        String description = "This is an advice for question 20";
        Advice advice = new Advice(20,  null, description);
        UserService userService = mock(UserService.class);
        mockAdviceService = mock(AdviceService.class);
        when(mockAdviceService.save(advice)).thenReturn(1);
        adviceController = new AdviceController(mockAdviceService);
        adviceController.setUserService(userService);
        BindingResult mockBindingResult = mock(BindingResult.class);
        when(mockBindingResult.hasErrors()).thenReturn(false);

        Principal mockPrincipal = mock(Principal.class);
        when(mockPrincipal.getName()).thenReturn(username);
        when(userService.getByUserName("Jules")).thenReturn(new User());

        String url = adviceController.saveAdvice(advice, mockBindingResult, model, mockPrincipal);

        assertThat(url, is("redirect:"+AdviceController.SHOW_QUESTION_DETAILS+"20"));
    }

    @Test
    public void shouldRejectWhenSaveAdviceFailed(){
        Map<String, String> model = new HashMap<String, String>();
        String username = "Jules";
        String description = "This is an advice for question 20";
        Advice advice = new Advice(20,  null, description);
        UserService userService = mock(UserService.class);
        mockAdviceService = mock(AdviceService.class);
        when(mockAdviceService.save(advice)).thenReturn(0);
        adviceController = new AdviceController(mockAdviceService);
        adviceController.setUserService(userService);
        when(userService.getByUserName("Jules")).thenReturn(new User());
        BindingResult mockBindingResult = mock(BindingResult.class);
        when(mockBindingResult.hasErrors()).thenReturn(false);

        Principal mockPrincipal = mock(Principal.class);
        when(mockPrincipal.getName()).thenReturn(username);

        String url = adviceController.saveAdvice(advice, mockBindingResult, model, mockPrincipal);

        assertThat(url, is("redirect:"+AdviceController.ERROR_PAGE));
    }

    @Test
    public void shouldRejectWhenValidationFailed(){
        Map<String, String> model = new HashMap<String, String>();
        String username = "Jules";
        String description = "This is an advice for question 20";
        Advice advice = new Advice(20,  null, description);
        mockAdviceService = mock(AdviceService.class);
        when(mockAdviceService.save(advice)).thenReturn(0);
        adviceController = new AdviceController(mockAdviceService);

        BindingResult mockBindingResult = mock(BindingResult.class);
        when(mockBindingResult.hasErrors()).thenReturn(true);

        Principal mockPrincipal = mock(Principal.class);
        when(mockPrincipal.getName()).thenReturn(username);

        String url = adviceController.saveAdvice(advice, mockBindingResult, model, mockPrincipal);

        assertThat(url, is("redirect:"+AdviceController.SHOW_QUESTION_DETAILS+"20"));
    }
}
