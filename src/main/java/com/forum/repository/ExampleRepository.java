package com.forum.repository;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ExampleRepository {

//    private final Logger logger = LoggerFactory.getLogger(getClass());
    private BasicDataSource dataSource;

    @Autowired
    public ExampleRepository(org.apache.commons.dbcp.BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Transactional
    public void create(Object object) {
    }

}