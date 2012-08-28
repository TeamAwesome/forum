package com.forum.service;

import com.forum.domain.Question;
import com.forum.repository.QuestionRepository;

import java.util.*;
import java.util.logging.Logger;

public class AdminService {
    private QuestionRepository questionRepository;
    private static Logger logger = Logger.getLogger(AdminService.class.getName());

    public AdminService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Integer getTotalNumberOfQuestions() {
        return questionRepository.getAllQuestions().size();
    }

    public List<Integer> getQuestionsPostedInLast12Months(){
        List<Integer> count = new ArrayList<Integer>(12);
        List<Question> questions = questionRepository.getQuestionsPostedInLast12Months();
        GregorianCalendar calendar = new GregorianCalendar();
        Date currentDate;

        for (int j = 0; j < 12; j++) {
            calendar.add(Calendar.MONTH, -1);
            currentDate = calendar.getTime();
            logger.info(currentDate.toString());

            count.add(0);

            for (int i = 0; i < questions.size(); i++) {
                if(questions.get(i).getCreatedAt().after(currentDate)){
                    count.set(j, count.get(j) + 1);
                }
            }
            if(j != 0){
                for (int i = 0; i < j; i++) {
                    count.set(j,count.get(j) - count.get(i));
                }
            }
        }
        return count;
    }
}
