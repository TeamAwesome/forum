import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JDBCConnectionTest extends AbstractTransactionalJUnit4SpringContextTests {

    private JdbcTemplate jdbcTemplate;

    @Test
    public void shouldGetDataFromDatabase(){
        String sql = "Select age from Student where id = ?";
        int age = jdbcTemplate.queryForInt(sql, 1);
        assertThat(age, is(10));
    }
}

