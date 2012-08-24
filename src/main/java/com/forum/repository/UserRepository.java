package com.forum.repository;

import com.forum.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
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
        return (User) jdbcTemplate.queryForObject("SELECT * FROM USER WHERE ID = ?", new Object[]{userId}, rowMapper);
    }
}
