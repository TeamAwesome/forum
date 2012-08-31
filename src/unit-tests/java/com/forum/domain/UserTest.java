package com.forum.domain;

import com.forum.service.UserService;
import com.forum.service.validation.UniqueUsernameValidator;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserTest {

    private static Validator validator;
    private static ValidatorFactory factory;


    @BeforeClass
    public static void setUp() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

    }


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
                "Moon", "He doesn't know", 200, false);
        assertThat(user.getPassword(), not(password));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldRejectNullAsPassword(){
        User user = new User();
        user.setPassword(null);
    }

   // @Test
    // We want to validate user object in unit test, but we need to mock a UserService object to
    // some validators, but we haven't found a way.
    public void shouldRejectShortName(){

        User user = new User("Tomd", "33", "Tom", "tom@tom.com", "1234567",
                "Moon", "He doesn't know", 200, false);

        UserService mockUserService = mock(UserService.class);
        when(mockUserService.checkExistenceOfUsername("Tomd")).thenReturn(false);

        UniqueUsernameValidator uniqueUsernameValidator = factory.getConstraintValidatorFactory().getInstance(UniqueUsernameValidator.class);
        uniqueUsernameValidator.setUserService(mockUserService);

        Set<ConstraintViolation<User>> constraintViolations =
                validator.validate(user);

        assertEquals(3, constraintViolations.size());
    }

}
