package com.forum.service;

import com.forum.domain.Question;
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
        questions.add(new Question("test","test",1,"test"));
        when(adminRepository.getAllQuestions()).thenReturn(questions);

        AdminService adminService = new AdminService(adminRepository);
        assertThat(adminService.getTotalNumberOfQuestions(), is(questions.size()));
    }
}
