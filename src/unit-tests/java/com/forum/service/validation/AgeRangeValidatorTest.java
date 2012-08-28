package com.forum.service.validation;

import org.junit.Test;

import javax.validation.ConstraintValidatorContext;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class AgeRangeValidatorTest {
    @Test
    public void shouldReturnFalseWhenAgeRangeIs6(){
        ConstraintValidatorContext constraintValidatorContext = mock(ConstraintValidatorContext.class);
        AgeRangeValidator ageRangeValidator = new AgeRangeValidator();

        boolean result = ageRangeValidator.isValid(6, constraintValidatorContext);

        assertThat(result, is(false));
    }

    @Test
    public void shouldReturnTrueWhenAgeRangeIs3(){
        ConstraintValidatorContext constraintValidatorContext = mock(ConstraintValidatorContext.class);
        AgeRangeValidator ageRangeValidator = new AgeRangeValidator();

        boolean result = ageRangeValidator.isValid(3, constraintValidatorContext);

        assertThat(result, is(true));
    }
}
