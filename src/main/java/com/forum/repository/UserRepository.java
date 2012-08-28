package com.forum.repository;

import com.forum.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User getById(int userId) {
        UserRowMapper rowMapper = new UserRowMapper();
        try {
            return (User) jdbcTemplate.queryForObject("SELECT * FROM USER WHERE ID = ?", new Object[]{userId}, rowMapper);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public User getByUsername(String username) {
        UserRowMapper rowMapper = new UserRowMapper();
        try {
            return (User) jdbcTemplate.queryForObject("SELECT * FROM USER WHERE USERNAME = ?", new Object[]{username}, rowMapper);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
}
