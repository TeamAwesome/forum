package com.forum.repository;

import com.forum.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import javax.sql.DataSource;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserRepositoryTest extends IntegrationTestBase{
    @Autowired
    private DataSource dataSource;

    @Test
    public void shouldGetUserById(){
        UserRepository userRepository = new UserRepository(dataSource);
        User user = userRepository.getById(1);
        assertThat(user.getUsername(), is("lu"));
    }
}
