package com.forum.repository;

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

    public int getTotalNumberOfQuestions()
    {
        return 1;
    }

    public int getTotalNumberOfAnswers() {
        return 1;
    }
}
