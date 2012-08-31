package com.forum.repository;

import com.forum.domain.User;
import com.forum.util.BooleanToInteger;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper {

    @Override
    public User mapRow(ResultSet resultSet, int row) throws SQLException {
        BooleanToInteger converter =new BooleanToInteger();
        return new User(resultSet.getString("USERNAME"),
                resultSet.getString("PASSWORD"),
                resultSet.getString("NAME"),
                resultSet.getString("EMAIL_ADDRESS"),
                resultSet.getString("PHONE_NUMBER"),
                resultSet.getString("COUNTRY"),
                resultSet.getString("GENDER"),
                resultSet.getInt("AGE_RANGE"),
                converter.toBoolean(resultSet.getInt("PRIVACY")));
    }
}
