package com.forum.repository;

import com.forum.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class QuestionRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public QuestionRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Question> latestQuestion(int number) {
        QuestionRowMapper rowMapper = new QuestionRowMapper();
        return jdbcTemplate.query("SELECT * FROM QUESTION ORDER BY CREATED_AT DESC LIMIT ?", new Object[]{number}, rowMapper);
    }

    public Question getById(Integer questionId) {
        QuestionRowMapper rowMapper = new QuestionRowMapper();
        return (Question) jdbcTemplate.queryForObject("SELECT * FROM QUESTION WHERE ID = ?", new Object[]{questionId}, rowMapper);

    }

    public boolean saveQuestion(Map<String, String> params) {
        return false;
    }

    public List<Question> latestQuestion(int pageNum, int pageSize) {
        int pageStart = (pageNum-1)*pageSize;
        QuestionRowMapper rowMapper = new QuestionRowMapper();
        return jdbcTemplate.query("SELECT * FROM QUESTION ORDER BY CREATED_AT DESC LIMIT ?,?",
                new Object[]{pageStart, pageSize}, rowMapper);
    }
}