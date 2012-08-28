package com.forum.service.validation;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintValidatorContext;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class PhoneNumberValidatorTest {

    private ConstraintValidatorContext constraintValidatorContext;
    private PhoneNumberValidator phoneNumberValidator;

    @Before
    public void setUp(){
        constraintValidatorContext = mock(ConstraintValidatorContext.class);
        phoneNumberValidator = new PhoneNumberValidator();
    }

    @Test
    public void shouldReturnTrueIfPhoneNumberIsEmpty(){
        assertThat(phoneNumberValidator.isValid("", constraintValidatorContext), is(true));
    }

    @Test
    public void shouldReturnTrueIfPhoneNumberIs10Digits(){
        assertThat(phoneNumberValidator.isValid("1234567890", constraintValidatorContext), is(true));
    }

    @Test
    public void shouldReturnFalseIfPhoneNumberIs10DigitsThatAreNotNumbers(){
        assertThat(phoneNumberValidator.isValid("1234e67890", constraintValidatorContext), is(false));
    }

    @Test
    public void shouldReturnFalseIfPhoneNumberIs9Digits(){
        assertThat(phoneNumberValidator.isValid("123567890", constraintValidatorContext), is(false));
    }


}
