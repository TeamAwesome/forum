package com.forum.service;

import com.forum.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class AdminService {
    private QuestionRepository questionRepository;

    @Autowired
    public AdminService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Integer getTotalNumberOfQuestions() {
        return questionRepository.getAllQuestions().size();
    }


    int getNumberOfQuestionInADay(int numberOfDays) {
        Calendar calendar = getKthDaysCalendar(numberOfDays);

        Timestamp beginningTime = getBeginningTime(calendar);
        Timestamp endingTime = getEndingTime(calendar);
        return questionRepository.getNumberOfQuestionBetweenTimes(beginningTime, endingTime);
    }

    private Timestamp getBeginningTime(Calendar calendar) {
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.AM_PM, Calendar.AM);
        Date date = calendar.getTime();
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;
    }

    private Timestamp getEndingTime(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = calendar.getTime()  ;
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;
    }

    public Calendar getKthDaysCalendar(int numberOfDaysBeforeCurrentDate) {
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DATE, -1*numberOfDaysBeforeCurrentDate);
        return calendar;

    }

    public List<Integer> getNumberOfQuestionsInNinetyDays() {
        List<Integer> numberOfQuestions = new ArrayList<Integer>();
        for (int i = 0; i < 90; i++) {
            numberOfQuestions.add(getNumberOfQuestionInADay(i));
        }
        return numberOfQuestions;
    }
}
