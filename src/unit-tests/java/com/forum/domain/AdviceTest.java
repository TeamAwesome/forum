package com.forum.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AdviceTest {
    @Test
    public void shouldEqualsWithSameProperties(){
        User user = new User();
        user.setUsername("me");
        Advice advice = new Advice(20,  user, "description");
        Advice anotherAdvice  = new Advice(20,  user, "description");

        assertThat(advice, is(anotherAdvice));
        assertThat(advice.hashCode(), is(anotherAdvice.hashCode()));
    }

    @Test
    public void shouldEqualsWhenNull(){
        Advice advice = null;
        Advice anotherAdvice =null;
        assertThat(advice, is(anotherAdvice));
    }

}
