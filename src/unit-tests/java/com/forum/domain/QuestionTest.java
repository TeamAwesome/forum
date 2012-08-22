package com.forum.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class QuestionTest {

    @Test
    public void shouldCreateNewQuestion(){
        Question question = new Question("Question Title", "Question Description");
        assertThat(question.getTitle(), is("Question Title"));
    }
}
