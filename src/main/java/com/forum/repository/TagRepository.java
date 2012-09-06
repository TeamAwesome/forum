package com.forum.repository;

import com.forum.domain.TagLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;


@Repository
public class TagRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TagRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<TagLabel> getTagsByTerm(String term) {
        List<TagLabel> tags;
        String query = "SELECT * FROM TAG WHERE NAME LIKE ?" ;
        tags = jdbcTemplate.query(query,
                new Object[]{"%"+term+"%"}, new TagRowMapper());

        return tags;
    }

    public Integer createTag(TagLabel tag) {
        return jdbcTemplate.update("INSERT INTO TAG (NAME) VALUES (?)",
                new Object[]{tag.getValue()});
    }

    public TagLabel getTagByName(String tag) {
        String query = "SELECT * FROM TAG WHERE NAME=?" ;

        return (TagLabel)jdbcTemplate.queryForObject(query,
                new Object[]{tag}, new TagRowMapper());
    }
}
