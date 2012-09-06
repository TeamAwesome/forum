package com.forum.service;

import com.forum.domain.Advice;
import com.forum.domain.User;
import com.forum.repository.AdviceRepository;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdviceServiceTest {

    private AdviceService adviceService;
    private AdviceRepository mockAdviceRepository;

    @Before
    public void setup(){
        mockAdviceRepository = mock(AdviceRepository.class);
        adviceService = new AdviceService(mockAdviceRepository);
    }

    @Test
    public void shouldReturnTrueIfAdviceSaved() {
        Advice advice = new Advice(1, new User(), "d");
        when(mockAdviceRepository.save(advice)).thenReturn(1);

        assertThat(adviceService.save(advice), is(1));
    }

}
