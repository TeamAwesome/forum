package com.forum.repository;

import com.forum.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CustomerRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Customer> all() {
        return jdbcTemplate.query("SELECT * from CUSTOMERS WHERE FIRST_NAME=?", new Object[] {"John"}, new CustomerRowMapper());
    }
}
