package com.forum.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ExampleRepository {

//    private final Logger logger = LoggerFactory.getLogger(getClass());
    private JdbcTemplate template;

    @Autowired
    public ExampleRepository(JdbcTemplate template) {
        this.template = template;
    }

    @Transactional
    public void create(Object object) {
    }

}