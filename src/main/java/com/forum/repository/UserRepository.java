package com.forum.repository;

import com.forum.domain.User;
import com.forum.util.BooleanToInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Date;
import java.util.logging.Logger;

/*
 * TODO - get user interests and knowledge from database when querying a user
 */
@Repository
public class UserRepository {

    private JdbcTemplate jdbcTemplate;

    private static Logger logger = Logger.getLogger(UserRepository.class.getName());

    @Autowired
    public UserRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User getById(int userId) {
        UserRowMapper rowMapper = new UserRowMapper();
        try {
            return (User) jdbcTemplate.queryForObject("SELECT * FROM USER WHERE ID = ?", new Object[]{userId}, rowMapper);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public User getByUsername(String username) {
        UserRowMapper rowMapper = new UserRowMapper();
        try {
            return (User) jdbcTemplate.queryForObject(
                    "SELECT * FROM USER WHERE USERNAME = ?",
                    new Object[]{username},
                    rowMapper);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public User getByEmail(String email) {
        UserRowMapper rowMapper = new UserRowMapper();
        try {
            return (User) jdbcTemplate.queryForObject(
                    "SELECT * FROM USER WHERE EMAIL_ADDRESS = ?",
                    new Object[]{email},
                    rowMapper);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public String getPasswordByUsername(String username) {
        String expectedPassword = (String) jdbcTemplate.queryForObject(
                "SELECT PASSWORD FROM USER WHERE USERNAME = ?",
                new Object[]{username},
                String.class);
        return (String) expectedPassword;
    }

    /*
     * This method executes multiple SQL statements. The statements are not executed in a single transaction.
     * As a consequence, incomplete user data could be stored in the database, for example when the first statement
     * is successful but later statements fail.
     *
     * TODO - Include all SQL statements in a single transaction, have a look at http://static.springsource.org/spring/docs/2.0.x/reference/transaction.html
     *
     */
    public int createUser(User user) {
        int result = 0;
        BooleanToInteger converter = new BooleanToInteger();
        logger.info(user.toString());
        result+=jdbcTemplate.update(
                "INSERT INTO USER (PASSWORD,NAME,EMAIL_ADDRESS,PHONE_NUMBER,COUNTRY,GENDER,AGE_RANGE,USERNAME,PRIVACY,CREATED_AT) VALUES (?,?,?,?,?,?,?,?,?,?)",
                user.getPassword(),
                user.getName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getCountry(),
                user.getGender(),
                user.getAgeRange(),
                user.getUsername(),
                converter.toInteger(user.getPrivacy()),
                new Date());

        Integer userId = getUserId(user.getUsername());
        for (Integer interestId : user.getInterests()) {
            result+=jdbcTemplate.update(
                    "INSERT INTO USER_INTERESTS (USER_ID,INTEREST_ID) VALUES (?,?)",
                    userId,
                    interestId);
        }
        for (Integer knowledgeId : user.getKnowledge()) {
            result+=jdbcTemplate.update(
                    "INSERT INTO USER_KNOWLEDGE (USER_ID,KNOWLEDGE_ID) VALUES (?,?)",
                    userId,
                    knowledgeId);
        }

        return result;
    }

    public Integer getUserId(String userName) {
        return jdbcTemplate.queryForObject(
                "SELECT ID FROM USER WHERE USERNAME = ?",
                new Object[]{userName},
                Integer.class);  //To change body of created methods use File | Settings | File Templates.
    }

    public int getUserPrivilege(User user) {
        return jdbcTemplate.queryForInt("SELECT PRIVILEGE FROM USER WHERE USERNAME = ?",user.getUsername());
    }
}
