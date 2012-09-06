package com.forum.repository;

import com.forum.domain.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class AdviceRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AdviceRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int save(Advice advice) {
        return jdbcTemplate.update("INSERT INTO ADVICE (ID, DESCRIPTION, QUESTION_ID, CREATED_AT, USER_ID) VALUES (?,?,?,?,?)",
                new Object[]{advice.getId(), advice.getDescription(), advice.getQuestionId(), advice.getCreatedAt(), advice.getUser().getId()});
    }

    public List<Advice> getByQuestionId(Integer questionId) {
        return jdbcTemplate.query("SELECT A.ID AS ID, A.CREATED_AT, A.USER_ID, A.DESCRIPTION,A.QUESTION_ID,U.* FROM ADVICE A JOIN USER U " +
                "WHERE A.USER_ID = U.ID AND A.QUESTION_ID = ?",new Object[]{questionId},new AdviceRowMapper());
    }
}

