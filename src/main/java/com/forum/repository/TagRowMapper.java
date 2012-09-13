package com.forum.repository;

import com.forum.domain.Tag;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class TagRowMapper implements  RowMapper {



    @Override
    public Tag mapRow(ResultSet resultSet, int i) throws SQLException, UnsupportedOperationException {
       Tag tag = new Tag(
                resultSet.getInt("ID"),
                resultSet.getString("NAME"),
                resultSet.getInt("COUNT")

        );
        return tag;
    }
}
