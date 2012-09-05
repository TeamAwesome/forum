package com.forum.repository;

import com.forum.domain.User;
import com.forum.util.BooleanToInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Date;
import java.util.logging.Logger;

/**
 * The purpose of this class is to simulate when a user is not inserted into the database correctly. This was done in
 * order to test that Spring rolls back user creation correctly.
 */
public class BrokenUserRepository {
    private JdbcTemplate jdbcTemplate;
    private static Logger logger = Logger.getLogger(BrokenUserRepository.class.getName());
    private UserRepository userRepository;

    @Autowired
    public BrokenUserRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        userRepository = new UserRepository(dataSource);
    }

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

        Integer userId = userRepository.getUserId(user.getUsername());
        for (Integer interestId : user.getInterests()) {
            result+=jdbcTemplate.update(
                    "INSERT INTO USER_INTERESTS (USER_ID,INTEREST_ID) VALUES (?,?)",
                    userId,
                    interestId);
        }

        if (true)
            throw new RuntimeException("This exception is thrown for testing purposes.");

        for (Integer knowledgeId : user.getKnowledge()) {
            result+=jdbcTemplate.update(
                    "INSERT INTO USER_KNOWLEDGE (USER_ID,KNOWLEDGE_ID) VALUES (?,?)",
                    userId,
                    knowledgeId);
        }

        return result;
    }
}
