package com.forum.service;

import com.forum.domain.Question;
import com.forum.domain.User;
import com.forum.repository.AdminRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdminServiceTest {
    @Test
    public void shouldGetTotalNumberOfQuestions(){
        AdminRepository adminRepository = mock(AdminRepository.class);

        List<Question> questions = new ArrayList<Question>();
        User user = new User(1, "pass", "Tom Tom", "tom@tom.com", "1234567",
                "Moon", "He doesn't know", 200);

        questions.add(new Question(1, "test","test", user,"2012-08-23 07:08:04"));
        when(adminRepository.getAllQuestions()).thenReturn(questions);

        AdminService adminService = new AdminService(adminRepository);
        assertThat(adminService.getTotalNumberOfQuestions(), is(questions.size()));
    }
}
