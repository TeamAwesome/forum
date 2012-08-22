package com.forum.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class HomeRepository {

    //    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public HomeRepository(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    @Transactional
    public void create(Object object) {
        String createString =
        "CREATE TABLE IF NOT EXISTS fav_color (\n"
        + "person_name varchar(25) NOT NULL,\n color_name varchar(25) NOT NULL,\n"
        + "PRIMARY KEY (<code>person_name</code>)\n) ENGINE=MyISAM DEFAULT CHARSET=utf8;";

        jdbcTemplate.update(createString);

//        Statement stmt = null;
//        try {
//            Connection con = template.getDataSource().getConnection();
//            stmt = con.createStatement();
//            stmt.executeUpdate(createString);
//        } catch (SQLException e) {
//            //JDBCTutorialUtilities.printSQLException(e);
//        } finally {
//            //if (stmt != null) { stmt.close(); }
//        }
    }

}