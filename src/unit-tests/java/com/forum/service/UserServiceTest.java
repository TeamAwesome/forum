package com.forum.service;

import com.forum.domain.User;
import com.forum.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    private UserRepository userRepository;
    private UserService userService;

    @Before
    public void setupUserService(){
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @Test
    public void shouldGetUserById(){
        User user = new User("Tom", "pass", "Tom Tom", "tom@tom.com", "1234567",
                            "Moon", "He doesn't know", 200);
        when(userRepository.getById(1)).thenReturn(user);

        assertThat(userService.getById(1), is(user));
    }

    @Test
    public void shouldReturnTrueIfUsernameExistsInDB(){
        User user = new User("lu", "pass", "Tom Tom", "tom@tom.com", "1234567",
                "Moon", "He doesn't know", 200);
        when(userRepository.getByUsername("lu")).thenReturn(user);
        assertThat(userService.checkExistenceOfUsername("lu"), is(true));
    }

    @Test
    public void shouldReturnFalseIfUsernameNotExistsInDB(){
        when(userRepository.getByUsername("who")).thenReturn(null);
        assertThat(userService.checkExistenceOfUsername("who"), is(false));
    }

    @Test
    public void shouldReturnTrueIfEmailExistsInDB(){
        User user = new User("lu", "pass", "Tom Tom", "tom@tom.com", "1234567",
                "Moon", "He doesn't know", 200);
        when(userRepository.getByEmail("tom@tom.com")).thenReturn(user);
        assertThat(userService.checkExistenceOfEmail("tom@tom.com"), is(true));
    }

    @Test
    public void shouldReturnFalseIfEmailNotExistsInDB(){
        when(userRepository.getByEmail("who@who.com")).thenReturn(null);
        assertThat(userService.checkExistenceOfUsername("who@who.com"), is(false));
    }
}
