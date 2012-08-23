package com.forum.repository;

import com.forum.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class AdminRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AdminRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<Question> getAllQuestions() {
        return jdbcTemplate.query("SELECT * FROM QUESTION", new QuestionRowMapper());
    }
}
