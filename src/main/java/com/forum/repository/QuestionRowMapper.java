package com.forum.repository;

import com.forum.domain.Question1;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Question1 question = new Question1();
        question.setTitle(resultSet.getString(2));
        String description = resultSet.getString(3);
        question.setDescription(description.substring(0, description.length() > 100 ? 100 : description.length()));
        question.setDate(resultSet.getString(4));
        question.setTime(resultSet.getString(5));
        question.setUser(resultSet.getString(6));
        return question;
    }
}
