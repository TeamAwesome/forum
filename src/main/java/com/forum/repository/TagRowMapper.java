package com.forum.repository;

import com.forum.domain.Question;
import com.forum.domain.TagLabel;
import com.forum.domain.User;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class TagRowMapper implements  RowMapper {



    @Override
    public TagLabel mapRow(ResultSet resultSet, int i) throws SQLException, UnsupportedOperationException {
       TagLabel tag = new TagLabel(
                resultSet.getInt("ID"),
                resultSet.getString("NAME"),
                1 //TODO ALTER THIS TO GET THE COUNT OF TAG USAGE
        );
        return tag;
    }
}
