package com.forum.repository;

import com.forum.domain.Question;
import com.forum.domain.User;
import com.forum.util.BooleanToInteger;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionRowMapper implements RowMapper {
    BooleanToInteger converter=new BooleanToInteger();
    @Override
    public Question mapRow(ResultSet resultSet, int i) throws SQLException, UnsupportedOperationException {
        User user = new User(
                resultSet.getString("USERNAME"),
                resultSet.getString("PASSWORD"),
                resultSet.getString("NAME"),
                resultSet.getString("EMAIL_ADDRESS"),
                resultSet.getString("PHONE_NUMBER"),
                resultSet.getString("COUNTRY"),
                resultSet.getString("GENDER"),
                resultSet.getInt("AGE_RANGE"),
                converter.toBoolean(resultSet.getInt("PRIVACY")));

        Question question = new Question(resultSet.getInt("QUESTION_ID"),
                resultSet.getString("TITLE"),
                resultSet.getString("DESCRIPTION"),
                user,
                resultSet.getTimestamp("CREATED_AT"),
                resultSet.getInt("LIKES"),
                resultSet.getInt("DISLIKES"),
                resultSet.getInt("FLAGS"));
        return question;
    }
}
