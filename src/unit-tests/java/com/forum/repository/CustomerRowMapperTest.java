package com.forum.repository;

import com.forum.domain.Customer;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerRowMapperTest {
    @Test
    public void shouldMapCustomersFromResultSet() throws SQLException {
        CustomerRowMapper customerRowMapper = new CustomerRowMapper();
        ResultSet resultSetMock = mock(ResultSet.class);
        when(resultSetMock.getInt("ID")).thenReturn(1);
        when(resultSetMock.getString("FIRST_NAME")).thenReturn("John");
        when(resultSetMock.getString("LAST_NAME")).thenReturn("Corner");
        Customer customer = customerRowMapper.mapRow(resultSetMock, 1);
        assertThat(customer.getId(), is(1));
        assertThat(customer.getFirstName(), is("John"));
        assertThat(customer.getLastName(), is("Corner"));
    }
}
