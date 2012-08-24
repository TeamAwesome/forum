package com.forum.repository;

import com.forum.domain.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper {
//    @Override
    public Customer mapRow(ResultSet resultSet, int row) throws SQLException {
        return new Customer(resultSet.getInt("ID"), resultSet.getString("FIRST_NAME"), resultSet.getString("LAST_NAME"));
    }
}
