package com.forum.repository;

import com.forum.domain.Question;
import com.forum.domain.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class QuestionRepository {

    private JdbcTemplate jdbcTemplate;
    private static Logger logger = Logger.getLogger(QuestionRepository.class.getName());


    @Autowired
    public QuestionRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Question> getAllQuestions() {
        String query = "SELECT Q.ID AS QUESTION_ID, Q.TITLE, Q.DESCRIPTION," +
                " Q.CREATED_AT,Q.*, U.* FROM QUESTION Q JOIN USER U WHERE Q.USER_ID=U.ID ORDER BY Q.ID ASC; ";
        return jdbcTemplate.query(query, new QuestionRowMapper());
    }

    public Question getById(Integer questionId) {
        String query = "SELECT Q.ID AS QUESTION_ID, Q.TITLE, Q.DESCRIPTION, Q.CREATED_AT," +
                "Q.*, U.*" +
                "FROM QUESTION Q JOIN USER U " +
                "WHERE Q.USER_ID=U.ID AND Q.ID =?";
        return (Question) jdbcTemplate.queryForObject(query, new Object[]{questionId}, new QuestionRowMapper());

    }

    public int createQuestion(Question question) {

        int result = 0;
        result += jdbcTemplate.update("INSERT INTO QUESTION (TITLE, DESCRIPTION, CREATED_AT, USER_ID) VALUES (?, ?, ?, ?)",
                new Object[]{question.getTitle(), question.getDescription(), new Date(), question.getUser().getId()});

        for (Tag tag : question.getTags()) {

            if (getTagCheck(tag) == 0) {
                result += getResultIfTagCheckIsNull(tag);
            }

            int questionID = jdbcTemplate.queryForInt("SELECT ID FROM QUESTION WHERE TITLE = ? AND CREATED_AT = ? AND USER_ID = ?", question.getTitle(), new Date(), question.getUser().getId());
            int tagID = jdbcTemplate.queryForInt("SELECT ID FROM TAG WHERE NAME = ?", tag.getValue());
            result += jdbcTemplate.update("INSERT INTO QUESTION_TAG (QUESTION_ID,TAG_ID) VALUES (?,?)", questionID, tagID);
        }

        return result;
    }

    private int getResultIfTagCheckIsNull(Tag tag) {
        return jdbcTemplate.update("INSERT INTO TAG (NAME) VALUES (?)",
                tag.getValue());
    }

    private int getTagCheck(Tag tag) {
        return jdbcTemplate.queryForInt("SELECT COUNT(*) FROM TAG WHERE NAME = ?", tag.getValue());
    }

    public List<Question> latestQuestion(int pageNum, int pageSize) {
        int pageStart = (pageNum - 1) * pageSize;
        String query = "SELECT Q.ID AS QUESTION_ID, Q.TITLE, Q.DESCRIPTION, "
                + "Q.CREATED_AT,Q.*, U.* FROM QUESTION Q JOIN USER U WHERE Q.USER_ID=U.ID "
                + "ORDER BY Q.CREATED_AT DESC LIMIT ?,?";
        return jdbcTemplate.query(query,
                new Object[]{pageStart, pageSize}, new QuestionRowMapper());
    }

    public int getNumberOfQuestionBetweenTimes(Timestamp beginningTime, Timestamp endingTime) {
        int numberOfQuestionInADay = 0;
        QuestionRowMapper rowMapper = new QuestionRowMapper();
        String query = "SELECT COUNT(ID) FROM QUESTION where CREATED_AT >= ? AND CREATED_AT <= ?";
        numberOfQuestionInADay = jdbcTemplate.queryForInt(query,
                new Object[]{beginningTime, endingTime});
        return numberOfQuestionInADay;

    }

    public int addLikesById(Integer questionId) {
        String query = "UPDATE QUESTION SET LIKES=LIKES+1 WHERE ID=?";
        return jdbcTemplate.update(query, new Object[]{questionId});

    }

    public int addDisLikesById(Integer questionId) {
        String query = "UPDATE QUESTION SET DISLIKES=DISLIKES+1 WHERE ID=?";
        return jdbcTemplate.update(query, new Object[]{questionId});
    }

    public int addFlagsById(Integer questionId) {
        String query = "UPDATE QUESTION SET FLAGS=FLAGS+1 WHERE ID=?";
        return jdbcTemplate.update(query, new Object[]{questionId});
    }
}
