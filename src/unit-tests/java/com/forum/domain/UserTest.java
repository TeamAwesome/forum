package com.forum.domain;

import org.hamcrest.core.IsNot;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void shouldEncryptPassword() {
        User user = new User();
        String password = "password";
        user.setPassword(password);
        assertThat(user.getPassword(), not(password));
    }

    @Test
    public void shouldEncryptPasswordByConstructor() {
        String password = "pass";
        User user = new User("Tom", password, "Tom Tom", "tom@tom.com", "1234567",
                "Moon", "He doesn't know", 200);
        assertThat(user.getPassword(), not(password));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldRejectNullAsPassword(){
        User user = new User();
        user.setPassword(null);
    }
}
