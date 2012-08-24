package com.forum.repository;

import com.forum.domain.Question;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Question question = new Question(resultSet.getInt("ID"), resultSet.getString("TITLE"),resultSet.getString("DESCRIPTION"),resultSet.getInt("USER_ID"),resultSet.getString("CREATED_AT"));
        return question;
    }
}
