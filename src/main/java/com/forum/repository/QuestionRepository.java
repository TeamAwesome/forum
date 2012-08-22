package com.forum.repository;

import com.forum.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class QuestionRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public QuestionRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Question> all() {
        return jdbcTemplate.query("SELECT * from QUESTION", new Object[]{}, new CustomerRowMapper());
    }

}
