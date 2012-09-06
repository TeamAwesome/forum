package com.forum.repository;

import com.forum.domain.Advice;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdviceRowMapperTest {

    @Test
    public void shouldMapAdviceFromResultSet() throws SQLException{
        ResultSet resultSet = mock(ResultSet.class);
        Date date = new Date();
        when(resultSet.getInt("QUESTION_ID")).thenReturn(1);
        when(resultSet.getString("TITLE")).thenReturn("title");
        when(resultSet.getString("PASSWORD")).thenReturn("pw");
        when(resultSet.getString("DESCRIPTION")).thenReturn("description");
        when(resultSet.getInt("LIKES")).thenReturn(0);
        when(resultSet.getInt("LIKES")).thenReturn(0);
        when(resultSet.getInt("FLAGS")).thenReturn(0);
        when(resultSet.getInt("ID")).thenReturn(1);
        when(resultSet.getString("DESCRIPTION")).thenReturn("description");
        when(resultSet.getInt("QUESTION_ID")).thenReturn(1);
        when(resultSet.getInt("USER_ID")).thenReturn(1);
        AdviceRowMapper adviceRowMapper = new AdviceRowMapper();

        Advice advice = adviceRowMapper.mapRow(resultSet,1);

        assertThat(advice.getId(), is(1));
        assertThat(advice.getDescription(), is("description"));
        assertThat(advice.getQuestionId(), is(1));
        assertThat(advice.getUser().getId(), is(1));
    }
}
