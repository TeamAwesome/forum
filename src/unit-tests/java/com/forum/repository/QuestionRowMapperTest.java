package com.forum.repository;


import com.forum.domain.Question;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuestionRowMapperTest {
    @Test
    public void shouldMapQuestionFrommResultSet() throws SQLException {
        QuestionRowMapper questionRowMapper = new QuestionRowMapper();
        ResultSet resultSetMock = mock(ResultSet.class);
        when(resultSetMock.getInt("QUESTION_ID")).thenReturn(1);
        when(resultSetMock.getString("TITLE")).thenReturn("title");
        when(resultSetMock.getString("PASSWORD")).thenReturn("pw");
        when(resultSetMock.getString("DESCRIPTION")).thenReturn("description");
        when(resultSetMock.getInt("LIKES")).thenReturn(0);
        when(resultSetMock.getInt("LIKES")).thenReturn(0);
        when(resultSetMock.getInt("FLAGS")).thenReturn(0);

        Question question = questionRowMapper.mapRow(resultSetMock, 1);
        assertThat(question.getId(), is(1));
        assertThat(question.getTitle(), is("title"));
        assertNotNull(question.getUser());
        assertThat(question.getLikes(), is(0));
        assertThat(question.getDislikes(), is(0));
        assertThat(question.getFlags(), is(0));
    }

}
