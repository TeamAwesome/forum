package com.forum.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.sql.DataSource;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AdminDashboardRespositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    private DataSource dataSource;

    @Test
    public void shouldGetNumberOfQuestionsInDatabase(){
        AdminRepository repository = new AdminRepository(dataSource);
        int numberOfQuestions = repository.getTotalNumberOfQuestions();
        assertThat(numberOfQuestions, is(1));
    }

    @Test
    public void shouldGetNumberOfAnswersInDatabase(){
        AdminRepository repository = new AdminRepository(dataSource);
        int numberOfAnswers = repository.getTotalNumberOfAnswers();
        assertThat(numberOfAnswers, is(1));
    }
}
