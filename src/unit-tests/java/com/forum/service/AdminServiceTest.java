package com.forum.service;

import com.forum.domain.Question;
import com.forum.domain.User;
import com.forum.repository.QuestionRepository;
import org.junit.Test;

import java.util.*;
import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdminServiceTest {
    private static Logger logger = Logger.getLogger(AdminServiceTest.class.getName());

    @Test
    public void shouldGetTotalNumberOfQuestions(){
        List<Question> questions = new ArrayList<Question>();
        User user = new User("Tom", "pass", "Tom Tom", "tom@tom.com", "1234567",
                "Moon", "He doesn't know", 200);

        QuestionRepository questionRepository = mock(QuestionRepository.class);
        when(questionRepository.getAllQuestions()).thenReturn(questions);

        AdminService adminService = new AdminService(questionRepository);

        assertThat(adminService.getTotalNumberOfQuestions(), is(questions.size()));
        questions.add(new Question(1, "test","test",user,new Date()));
        assertThat(adminService.getTotalNumberOfQuestions(), is(questions.size()));
        questions.add(new Question(2, "test","test",user,new Date()));
        questions.add(new Question(3, "test","test",user,new Date()));
        assertThat(adminService.getTotalNumberOfQuestions(), is(questions.size()));
    }

}
