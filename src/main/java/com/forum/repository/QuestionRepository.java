package com.forum.repository;

import com.forum.domain.Question;
import com.forum.domain.Question1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class QuestionRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public QuestionRepository(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    public List<Question1> latestQuestion(int number) {
        QuestionRowMapper rowMapper = new QuestionRowMapper();
        return jdbcTemplate.query("select * from question1 order by date desc, time desc limit ?", new Object[]{number}, rowMapper);
    }
}