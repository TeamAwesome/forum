package com.forum.repository;

import com.forum.domain.Question;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.sql.DataSource;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AdminDashboardRespositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    private DataSource dataSource;

    @Test
    public void shouldGetAllQuestions(){
        AdminRepository repository = new AdminRepository(dataSource);
        List<Question> Questions=repository.getAllQuestions();
        assertThat(Questions.size(),is(25));
    }
}
