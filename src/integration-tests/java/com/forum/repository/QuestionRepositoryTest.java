package com.forum.repository;


import com.forum.domain.Question;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class QuestionRepositoryTest extends IntegrationTestBase {

    @Autowired
    private DataSource dataSource;

    @Test
    public void shouldBeAbleToRetrieveAQuestionByID(){
        QuestionRepository questionRepository = new QuestionRepository(dataSource);

        Question question = questionRepository.getById(1);

        assertThat(question.getTitle(), is("What\'s up today Lu"));
    }

    @Test
    public void shouldGetLatestQuestions(){
        QuestionRepository repository = new QuestionRepository(dataSource);
        List<Question> Questions=repository.latestQuestion(1, 20);
        assertThat(Questions.size(), CoreMatchers.is(20));
    }
}
