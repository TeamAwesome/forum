package com.forum.util;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: nitinku
 * Date: 31/8/12
 * Time: 11:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class BooleanToIntegerTest {
    BooleanToInteger converter;

    @Before
    public void setUp() {
        converter = new BooleanToInteger();
    }

    @Test
    public  void shouldConvertABooleanToInteger(){
        assertThat(converter.toInteger(false),is(0));
        assertThat(converter.toInteger(true), is(1));
    }

    @Test
    public void shouldConvertAnIntegerToBoolean(){
        assertThat(converter.toBoolean(0), is(false));
        assertThat(converter.toBoolean(1), is(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldRejectIntegerGreaterThenOne() {
        converter.toBoolean(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldRejectIntegerLessThenZero() {
           converter.toBoolean(-1);
       }


}
