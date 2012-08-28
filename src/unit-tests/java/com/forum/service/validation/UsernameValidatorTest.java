package com.forum.service.validation;

import com.forum.service.UserService;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintValidatorContext;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UsernameValidatorTest {

    private ConstraintValidatorContext constraintValidatorContext;
    private UsernameValidator usernameValidator;
    private UserService userService;

    @Before
    public void setupUsername(){
        constraintValidatorContext = mock(ConstraintValidatorContext.class);
        usernameValidator = new UsernameValidator();
        userService = mock(UserService.class);
        usernameValidator.setUserService(userService);
    }

    @Test
    public void shouldReturnTrueIfUsernameNotInDB(){
        when(userService.checkExistenceOfUsername("who")).thenReturn(false);
        boolean result = usernameValidator.isValid("who", constraintValidatorContext);
        assertThat(result, is(true));
    }

    @Test
    public void shouldReturnFalseIfUsernameIsInDB(){
        when(userService.checkExistenceOfUsername("lu")).thenReturn(true);
        boolean result = usernameValidator.isValid("lu", constraintValidatorContext);
        assertThat(result, is(false));
    }
}
