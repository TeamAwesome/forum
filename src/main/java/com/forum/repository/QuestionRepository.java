package com.forum.repository;

import com.forum.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public QuestionRepository(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    public List<Question> latestQuestion(int number) {
        QuestionRowMapper rowMapper = new QuestionRowMapper();
        return jdbcTemplate.query("SELECT * FROM QUESTION ORDER BY CREATED_AT DESC LIMIT ?", new Object[]{number}, rowMapper);
    }
}