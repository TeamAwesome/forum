package com.forum.repository;

import com.forum.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

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

    @Test
    public void shouldGetUserByEmailIfExistsInDB() {
        User user = userRepository.getByEmail("cece@thoughtworks.com");
        if (user == null)
            fail();
        else
            assertThat(user.getUsername(), is("cece"));
    }

    @Test
    public void shouldReturnNullIfEmailNotExistsInDB() {
        User user = userRepository.getByEmail("who@who.com");
        assertNull(user);
    }

    @Test
    public void shouldReturnNullIfUserNotPresent(){
        String validUser = userRepository.getPasswordByUsername("lu");
        assertThat(validUser,is("QWERTY"));
    }

    @Test
    public void shouldCreateUser(){

        User user = new User("Tom-"+System.currentTimeMillis(), "33", "Tom", "tom@tom.com", "1234567",
                "Moon", "H", 2, false);
        List<Integer> interests = new ArrayList<Integer>();
        interests.add(1);
        interests.add(2);
        user.setInterests(interests);

        int userCreated = userRepository.createUser(user);

        assertThat(userCreated, is(1));
    }

    @Test
    public void shouldReturnUserIdByUserName(){
        String userName = "Tom-"+System.currentTimeMillis();
        User user = new User(userName, "33", "Tom", "tom@tom.com", "1234567",
                "Moon", "H", 2, true);

        int userCreated = userRepository.createUser(user);
        assertThat(userCreated, is(1));

        Integer userId = userRepository.getUserId(userName);
        assertNotNull(userId);

    }
}
