package com.forum.repository;

import com.forum.domain.Question;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Question question = new Question(resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));



        return question;
    }
}
