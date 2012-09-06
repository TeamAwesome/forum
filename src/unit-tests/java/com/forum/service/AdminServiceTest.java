package com.forum.service;

import com.forum.domain.Question;
import com.forum.domain.User;
import com.forum.repository.QuestionRepository;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdminServiceTest {

    @Test
    public void shouldGetTotalNumberOfQuestions(){
        List<Question> questions = new ArrayList<Question>();
        User user = new User("Tom", "pass", "Tom Tom", "tom@tom.com", "1234567",
                "Moon", "He doesn't know", 200, false);

        QuestionRepository questionRepository = mock(QuestionRepository.class);
        when(questionRepository.getAllQuestions()).thenReturn(questions);

        AdminService adminService = new AdminService(questionRepository);
        assertThat(adminService.getTotalNumberOfQuestions(), is(questions.size()));
        questions.add(new Question(1, "test","test",user,new Date()));
        assertThat(adminService.getTotalNumberOfQuestions(), is(questions.size()));
        questions.add(new Question(2, "test","test",user,new Date()));
        questions.add(new Question(3, "test","test",user,new Date()));
        assertThat(adminService.getTotalNumberOfQuestions(), is(questions.size()));
    }

    @Test
    public void shouldGetNumberOfQuestionsInADay(){
        QuestionRepository questionRepositoryMock = mock(QuestionRepository.class);
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DATE, -1);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.AM_PM, Calendar.AM);
        Timestamp beginningTimestamp = new Timestamp(calendar.getTime().getTime());

        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        Timestamp endingTimestamp = new Timestamp(calendar.getTime().getTime());

        when(questionRepositoryMock.getNumberOfQuestionBetweenTimes(beginningTimestamp, endingTimestamp)).thenReturn(3);
        AdminService adminService = new AdminService(questionRepositoryMock);
        int numberOfQuestionInToday= adminService.getNumberOfQuestionInADay(1);

        assertThat(numberOfQuestionInToday, is(3));
    }


    @Test
    public void shouldGetListOfNumberOfQuestionsIn90Days(){
        QuestionRepository questionRepositoryMock = mock(QuestionRepository.class);
        for(int i = 0; i < 90; i++){
            Calendar calendar = new GregorianCalendar();
            calendar.add(Calendar.DATE, -i);

            calendar.set(Calendar.HOUR, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.set(Calendar.AM_PM, Calendar.AM);
            Timestamp beginningTimestamp = new Timestamp(calendar.getTime().getTime());
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MILLISECOND, 0);
            Timestamp endingTimestamp = new Timestamp(calendar.getTime().getTime());

            when(questionRepositoryMock.getNumberOfQuestionBetweenTimes(beginningTimestamp,endingTimestamp)).thenReturn(3);
        }
        AdminService adminService = new AdminService(questionRepositoryMock);
        List<Integer> listOfNumberOfQuestions = new ArrayList<Integer>();

        for(int  i= 0; i < 90; i++){
            listOfNumberOfQuestions.add(3);
        }

        assertThat(listOfNumberOfQuestions, is(adminService.getNumberOfQuestionsInNinetyDays()));
    }
}
