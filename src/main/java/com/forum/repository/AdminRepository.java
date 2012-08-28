package com.forum.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class AdminRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AdminRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
