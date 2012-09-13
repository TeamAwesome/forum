package com.forum.util;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class TestHelperTest {
    private TestHelper testHelper;

    @Before
    public void setup() {
        testHelper = new TestHelper();
    }

    @Test
    public void shouldParseInteger() {
        assertEquals(42, testHelper.getLikeCountValue("abc (42) def"));
    }

    @Test
    public void shouldHandleMissingOpenBracket() {
        assertEquals(Integer.MIN_VALUE, testHelper.getLikeCountValue("abc 42) def"));
    }

    @Test
    public void shouldHandleMissingCloseBracket() {
        assertEquals(Integer.MIN_VALUE, testHelper.getLikeCountValue("abc (42 def"));
    }

    @Test
    public void shouldHandleWrongOrderOfBrackets() {
        assertEquals(Integer.MIN_VALUE, testHelper.getLikeCountValue("abc )42( def"));
    }

    @Test
    public void shouldReturnMinusOne() {
        assertEquals(-1, testHelper.getLikeCountValue("abc (-1) def"));
    }
}
