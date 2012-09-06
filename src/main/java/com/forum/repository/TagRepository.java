package com.forum.repository;

import com.forum.domain.Tag;
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

    public List<Tag> getTagsByTerm(String term) {
        return retrieveTags("SELECT * FROM TAG WHERE NAME LIKE ?", "%"+term+"%");
    }

    public Integer createTag(Tag tag) {
        return jdbcTemplate.update("INSERT INTO TAG (NAME) VALUES (?)",
                new Object[]{tag.getValue()});
    }

    public Tag getTagByName(String tag) {
        String query = "SELECT * FROM TAG WHERE NAME=?" ;

        return (Tag)jdbcTemplate.queryForObject(query,
                new Object[]{tag}, new TagRowMapper());
    }

    public List<Tag> allTags() {
        return retrieveTags("SELECT * FROM TAG");
    }

    @SuppressWarnings("unchecked")
    private List<Tag> retrieveTags(String query, Object... params) {
        return jdbcTemplate.query(query, params, new TagRowMapper());
    }
}
