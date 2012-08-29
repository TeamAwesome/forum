package com.forum.service.validation;

import com.forum.service.UserService;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintValidatorContext;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UniqueUsernameValidatorTest {

    private ConstraintValidatorContext constraintValidatorContext;
    private UniqueUsernameValidator uniqueUsernameValidator;
    private UserService userService;

    @Before
    public void setupUsername(){
        constraintValidatorContext = mock(ConstraintValidatorContext.class);
        uniqueUsernameValidator = new UniqueUsernameValidator();
        userService = mock(UserService.class);
        uniqueUsernameValidator.setUserService(userService);
    }

    @Test
    public void shouldReturnTrueIfUsernameNotInDB(){
        when(userService.checkExistenceOfUsername("who")).thenReturn(false);
        boolean result = uniqueUsernameValidator.isValid("who", constraintValidatorContext);
        assertThat(result, is(true));
    }

    @Test
    public void shouldReturnFalseIfUsernameIsInDB(){
        when(userService.checkExistenceOfUsername("lu")).thenReturn(true);
        boolean result = uniqueUsernameValidator.isValid("lu", constraintValidatorContext);
        assertThat(result, is(false));
    }
}
