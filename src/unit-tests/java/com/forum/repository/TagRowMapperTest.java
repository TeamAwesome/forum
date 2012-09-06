package com.forum.repository;

import com.forum.domain.TagLabel;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TagRowMapperTest {
    @Test
    public  void  shouldMapTagFromResultSet() throws SQLException {
       TagRowMapper tagRowMapper=new TagRowMapper();
        ResultSet mockResultSet=mock(ResultSet.class);
        when(mockResultSet.getString("NAME")).thenReturn("bangalore");
        when(mockResultSet.getInt("ID")).thenReturn(1);
       TagLabel tag = tagRowMapper.mapRow(mockResultSet,1);
        assertThat(tag.getId(),is(1));
        assertThat(tag.getValue(),is("bangalore"));

    }


}
