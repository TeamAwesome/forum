package com.forum.repository;


import com.forum.domain.Question;
import com.forum.domain.User;
import com.forum.web.controller.AdminController;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class QuestionRepositoryTest extends IntegrationTestBase {

    private QuestionRepository questionRepository;
    @Autowired
    private DataSource dataSource;

    @Before
    public void setup(){
        questionRepository = new QuestionRepository(dataSource);
    }
    @Test
    public void shouldBeAbleToRetrieveAQuestionByID(){
        QuestionRepository questionRepository = new QuestionRepository(dataSource);
        Question question = questionRepository.getById(1);

        assertThat(question.getTitle(), is("Shopping places in the city"));
    }

    @Test
    public void shouldGetLatestQuestions(){
        List<Question> questions = questionRepository.latestQuestion(1, 20);

        assertThat(questions.size(), CoreMatchers.is(20));
    }

    @Test
    public void shouldGetAllQuestions(){
        List<Question> questions = questionRepository.getAllQuestions();

        assertThat(questions.size(), is(24));
    }

    @Test
    public void shouldCreateQuestion(){
        QuestionRepository questionRepository = new QuestionRepository(dataSource);
        User user=new User();
        Date date = new Date(1970,05,25);
        Question question =new Question(12,"where","where are you",null,date);
        assertThat(questionRepository.createQuestion(question),is(1));
    }


    @Test
    public void shouldGetNumberOfQuestionInAParticularDay(){
        QuestionRepository questionRepository = new QuestionRepository(dataSource);

        Calendar cal = Calendar.getInstance();
        Timestamp timestamp = new Timestamp(cal.getTime().getTime());
        questionRepository.createQuestion(new Question("test1", "test1", null, timestamp));
        questionRepository.createQuestion(new Question("test2", "test2", null, timestamp));
        questionRepository.createQuestion(new Question("test3", "test3", null, timestamp));
        questionRepository.createQuestion(new Question("test4", "test4", null, timestamp));
        questionRepository.createQuestion(new Question("test5", "test5", null, timestamp));
        questionRepository.createQuestion(new Question("test6", "test6", null, timestamp));


        cal.set(Calendar.HOUR_OF_DAY, 00);
        cal.set(Calendar.MINUTE, 00);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Timestamp beginningTimestamp = new Timestamp(cal.getTime().getTime());

        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 59);
        Timestamp endingTimestamp = new Timestamp(cal.getTime().getTime());

        int numberOfQuestion = questionRepository.getNumberOfQuestionBetweenTimes(beginningTimestamp, endingTimestamp);

        assertThat(numberOfQuestion, is(6));
    }
}












