package com.forum.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AgeRangeTest {

    @Test
    public void shouldReturnCode1ForRange0to25(){
        assertThat(AgeRange.RANGE_0_25.getCode(),is(1));
    }

    @Test
    public void shouldReturnRange0to25ForCode1(){
        assertThat(AgeRange.getAgeRange(1),is(AgeRange.RANGE_0_25));
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenGettingInvalidCode(){
        AgeRange.getAgeRange(10);
    }
}
