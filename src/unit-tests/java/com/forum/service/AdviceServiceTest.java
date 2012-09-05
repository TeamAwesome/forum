package com.forum.service;

import com.forum.domain.Advice;
import com.forum.domain.User;
import junit.framework.TestCase;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AdviceServiceTest extends TestCase {
    public void testSave() throws Exception {
        Advice advice = new Advice(1, new User(), "d");
        AdviceService adviceService = new AdviceService();
        assertThat(adviceService.save(advice), is(true));
    }
}
