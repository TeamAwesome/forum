package com.forum.service.validation;

import com.forum.domain.AgeRange;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintValidatorContext;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class AgeRangeValidatorTest {

    private ConstraintValidatorContext constraintValidatorContext;
    private AgeRangeValidator ageRangeValidator;

    @Before
    public void setupAgeRangeValidator(){
        constraintValidatorContext = mock(ConstraintValidatorContext.class);
        ageRangeValidator = new AgeRangeValidator();
    }

    @Test
    public void shouldReturnFalseWhenAgeRangeIs6(){
        boolean result = ageRangeValidator.isValid(6, constraintValidatorContext);

        assertThat(result, is(false));
    }

    @Test
    public void shouldReturnTrueWhenAgeRangeIs3(){
        boolean result = ageRangeValidator.isValid(3, constraintValidatorContext);

        assertThat(result, is(true));
    }


    @Test
    public void shouldRejectNullAsAgeRangeCode(){
        boolean  result = ageRangeValidator.isValid(null, constraintValidatorContext);

        assertThat(result, is(false));
    }
}
