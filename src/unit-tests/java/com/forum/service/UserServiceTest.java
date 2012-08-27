package com.forum.service;

import com.forum.domain.User;
import com.forum.repository.UserRepository;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Test
    public void shouldGetUserById(){
        UserRepository userRepository = mock(UserRepository.class);

        User user = new User("Tom", "pass", "Tom Tom", "tom@tom.com", "1234567",
                            "Moon", "He doesn't know", 200);

        when(userRepository.getById(1)).thenReturn(user);

        UserService userService = new UserService(userRepository);
        assertThat(userService.getById(1), is(user));
    }

}
