package com.forum.repository;

import com.forum.domain.Advice;
import com.forum.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AdviceRepositoryTest extends IntegrationTestBase{

    private AdviceRepository adviceRepository;
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;
    @Before
    public void setup(){
        adviceRepository = new AdviceRepository(dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Test
    public void shouldSaveToDatabase(){
        User user = new User();
        user.setId(5);
        Advice advice = new Advice(7, user,"mock description");
        advice.setId(2);
        advice.setCreatedAt(new Date());

        int returnValue = adviceRepository.save(advice);

        assertThat(returnValue, is(1));
    }

    @Test
    public void shouldGetAdviceByQuestionId(){
        Advice actualAdvice = adviceRepository.getByQuestionId(1).get(0);
        assertThat(actualAdvice.getDescription(), is("I want to visit, but I hear it's been raining"));
    }
}
