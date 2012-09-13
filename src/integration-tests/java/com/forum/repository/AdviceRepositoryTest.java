package com.forum.repository;

import com.forum.domain.Advice;
import com.forum.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AdviceRepositoryTest extends IntegrationTestBase {

    private AdviceRepository adviceRepository;
    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = Logger.getLogger(AdviceRepositoryTest.class.getName());
    private Advice advice;
    private User user;

    @Autowired
    private DataSource dataSource;


    @Before
    public void setup() {
        adviceRepository = new AdviceRepository(dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);
        user = new User("user4", "password", "name d", "exx@thoughtworks.com", "9982374762", "INDIA", "F", 4, true);
        user.setId(5);
        advice = new Advice(7, user, "mock description");
        Timestamp timeStamp = new Timestamp(new Date().getTime());
        advice.setCreatedAt(timeStamp);
    }

    @Test
    public void shouldSaveToDatabase() {
        adviceRepository.save(advice);
        Date timeStamp = advice.getCreatedAt();

        List<Advice> expectedAdviceList = new ArrayList<Advice>();
        expectedAdviceList = adviceRepository.getByQuestionId(advice.getQuestionId());
        expectedAdviceList.get(0).setCreatedAt(timeStamp);

        assertThat(advice, is(expectedAdviceList.get(0)));
    }

    @Test
    public void shouldGetAdviceByQuestionId() {
        adviceRepository.save(advice);

        List<Advice> expectedAdvicelist;
        expectedAdvicelist = adviceRepository.getByQuestionId(advice.getQuestionId());
        assertThat(expectedAdvicelist.get(0).getDescription(), is(advice.getDescription()));
    }
}
