package com.forum.service.validation;

import com.forum.service.UserService;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintValidatorContext;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UniqueEmailValidatorTest {
    private ConstraintValidatorContext constraintValidatorContext;
    private UserService userService;
    private UniqueEmailValidator uniqueEmailValidator;

    @Before
    public void setupEmail(){
        constraintValidatorContext = mock(ConstraintValidatorContext.class);
        uniqueEmailValidator = new UniqueEmailValidator();
        userService = mock(UserService.class);
        uniqueEmailValidator.setUserService(userService);
    }


    @Test
    public void shouldReturnTrueIfEmailNotInDB(){
        when(userService.checkExistenceOfEmail("who@who.com")).thenReturn(false);
        boolean result = uniqueEmailValidator.isValid("who@who.com", constraintValidatorContext);
        assertThat(result, is(true));
    }

    @Test
    public void shouldReturnFalseIfEmailIsInDB(){
        when(userService.checkExistenceOfEmail("who@who.com")).thenReturn(true);
        boolean result = uniqueEmailValidator.isValid("who@who.com", constraintValidatorContext);
        assertThat(result, is(false));
    }
}
