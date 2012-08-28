package com.forum.repository;

import com.forum.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import javax.sql.DataSource;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class UserRepositoryTest extends IntegrationTestBase {
    @Autowired
    private DataSource dataSource;
    private UserRepository userRepository;

    @Before
    public void setupRepository() {
        userRepository = new UserRepository(dataSource);
    }

    @Test
    public void shouldGetUserById() {
        User user = userRepository.getById(1);
        assertThat(user.getName(), is("Lu Liu"));
    }

    @Test
    public void shouldGetUserByUsernameIfExistsInDB() {
        User user = userRepository.getByUsername("lu");
        if (user == null)
            fail();
        else
            assertThat(user.getUsername(), is("lu"));
    }

    @Test
    public void shouldReturnNullIfUsernameNotExistsInDB() {
        User user = userRepository.getByUsername("who");
        assertNull(user);
    }
}
