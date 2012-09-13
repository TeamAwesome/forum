package com.forum.service.validation;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintValidatorContext;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Mockito.mock;

public class TagLengthValidatorTest {
    private ConstraintValidatorContext constraintValidatorContext;
    private TagLengthValidator tagLength;

    @Before
    public void setUpTagValidator(){
        constraintValidatorContext = mock(ConstraintValidatorContext.class);
        tagLength = new TagLengthValidator();
    }

    @Test
    public void shouldBeLessThan20Characters(){
        String tagListAsString = "abcdefghijklmnopqrstuvwxyz";
        boolean validationResult = tagLength.isValid(tagListAsString, constraintValidatorContext);
        assertThat(validationResult,is(false));
    }


}
