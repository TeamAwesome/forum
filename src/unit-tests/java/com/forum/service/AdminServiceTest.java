package com.forum.service;

import com.forum.domain.Question;
import com.forum.repository.QuestionRepository;
import org.junit.Test;

import java.util.*;
import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdminServiceTest {
    private static Logger logger = Logger.getLogger(AdminServiceTest.class.getName());

    @Test
    public void shouldGetTotalNumberOfQuestions(){
        List<Question> questions = new ArrayList<Question>();

        QuestionRepository questionRepository = mock(QuestionRepository.class);
        when(questionRepository.getAllQuestions()).thenReturn(questions);

        AdminService adminService = new AdminService(questionRepository);

        assertThat(adminService.getTotalNumberOfQuestions(), is(questions.size()));
        questions.add(new Question(1, "test","test",1,new Date()));
        assertThat(adminService.getTotalNumberOfQuestions(), is(questions.size()));
        questions.add(new Question(2, "test","test",2,new Date()));
        questions.add(new Question(3, "test","test",3,new Date()));
        assertThat(adminService.getTotalNumberOfQuestions(), is(questions.size()));
    }

    @Test
    public void shouldGenerateCountOfRecordsForEachMonth() {
        List<Question> questions = new ArrayList<Question>();

        questions.add(new Question(01,"mock question","mock description",01, addMonth(-1)));
        questions.add(new Question(02,"mock question","mock description",02, addMonth(-2)));
        questions.add(new Question(03,"mock question","mock description",03, addMonth(-5)));
        questions.add(new Question(04,"mock question","mock description",04, addMonth(-7)));
        questions.add(new Question(05,"mock question","mock description",05, addMonth(-7)));
        questions.add(new Question(06,"mock question","mock description",06, addMonth(-7)));

        QuestionRepository questionRepository = mock(QuestionRepository.class);
        when(questionRepository.getQuestionsPostedInLast12Months()).thenReturn(questions);

        AdminService adminService = new AdminService(questionRepository);
        List<Integer> count = new ArrayList<Integer>();
        count = adminService.getQuestionsPostedInLast12Months();

        assertThat("0 months ago", count.get(0), is(0));
        assertThat("1 months ago", count.get(1), is(1));
        assertThat("2 months ago", count.get(2), is(1));
        assertThat("3 months ago", count.get(3), is(0));
        assertThat("4 months ago", count.get(4), is(0));
        assertThat("5 months ago", count.get(5), is(1));
        assertThat("6 months ago", count.get(6), is(0));
        assertThat("7 months ago", count.get(7), is(3));
        assertThat("8 months ago", count.get(8), is(0));
        assertThat("9 months ago", count.get(9), is(0));
        assertThat("10 months ago", count.get(10), is(0));
        assertThat("11 months ago", count.get(11), is(0));
    }

    private Date addMonth(int month) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.add(Calendar.MONTH, month);

        Date result = calendar.getTime();
        logger.info(result.toString());
        return result;
    }
}
