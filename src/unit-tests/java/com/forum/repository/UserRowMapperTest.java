package com.forum.repository;

import com.forum.domain.User;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserRowMapperTest {
    @Test
    public void shouldMapUsersFromResultSet() throws SQLException {
        UserRowMapper UserRowMapper = new UserRowMapper();
        ResultSet resultSetMock = mock(ResultSet.class);
        when(resultSetMock.getInt("ID")).thenReturn(1);
        when(resultSetMock.getString("PASSWORD")).thenReturn("John");
        when(resultSetMock.getString("NAME")).thenReturn("Corner");
        when(resultSetMock.getString("USERNAME")).thenReturn("Corner");
        when(resultSetMock.getString("EMAIL_ADDRESS")).thenReturn("ll@mail.com");
        when(resultSetMock.getString("PHONE_NUMBER")).thenReturn("12345678945");
        when(resultSetMock.getString("COUNTRY")).thenReturn("US");
        when(resultSetMock.getString("GENDER")).thenReturn("who knows");
        when(resultSetMock.getInt("AGE_RANGE")).thenReturn(200);
        User user = UserRowMapper.mapRow(resultSetMock, 0);
        assertThat(user.getName(), is("Corner"));
        assertThat(user.getAgeRange(), is(200));
        assertThat(user.getCountry(), is("US"));
        assertThat(user.getEmail(), is("ll@mail.com"));
        assertThat(user.getGender(), is("who knows"));
        assertThat(user.getPassword(), not("John"));
        assertNotNull(user.getPassword());
        assertThat(user.getPhoneNumber(), is("12345678945"));
    }

}
