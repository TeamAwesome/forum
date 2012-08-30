package com.forum.repository;

import com.forum.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    public User getByEmail(String email) {
        UserRowMapper rowMapper = new UserRowMapper();
        try{
            return (User) jdbcTemplate.queryForObject("SELECT * FROM USER WHERE EMAIL_ADDRESS = ?", new Object[]{email}, rowMapper);
        }  catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
    public String getPasswordByUsername(String username) {
         String expectedPassword = (String) jdbcTemplate.queryForObject("SELECT PASSWORD FROM USER WHERE USERNAME = ?",new Object[]{username},String.class);
         return  (String)expectedPassword;
    }

    public User insert(User user) {
        return user;  //To change body of created methods use File | Settings | File Templates.
    }
}
