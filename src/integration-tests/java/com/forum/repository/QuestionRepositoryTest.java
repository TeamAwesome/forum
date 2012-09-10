package com.forum.repository;


import com.forum.domain.Question;
import com.forum.domain.User;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    /*                                                tags = new ArrayList<Tag>();
        String[] tagArray = tagsAsString.split(",");
        for (String tag : tagArray){
            tags.add(new Tag(tag.trim()));
        }

     * TODO - continue here for writing tags to the database
     */
    @Test
    public void shouldCreateQuestionWithNonExistingTags(){
        QuestionRepository questionRepository = new QuestionRepository(dataSource);
        User user=new User();
        user.setUsername("Silly");
        user.setId(42);
        Date date = new Date();
        Question question =new Question(12,"where","where are you",user,date);
        question.setTagsAsString("Foo, Bar, Baz");
        assertThat(questionRepository.createQuestion(question),is(7));
    }

    @Test
    public void shouldCreateQuestionWithExistingTags(){
        QuestionRepository questionRepository = new QuestionRepository(dataSource);
        User user=new User();
        user.setUsername("Silly");
        user.setId(42);
        Date date = new Date();
        Question question =new Question(12,"where","where are you",user,date);
        question.setTagsAsString("Music, Food, Spice");
        assertThat(questionRepository.createQuestion(question),is(4));
    }

    @Test
    public void shouldGetNumberOfQuestionInAParticularDay(){
        QuestionRepository questionRepository = new QuestionRepository(dataSource);

        Calendar cal = Calendar.getInstance();
        Timestamp timestamp = new Timestamp(cal.getTime().getTime());
        User user=new User();
        user.setUsername("Silly");
        questionRepository.createQuestion(new Question("test1", "test1", user, timestamp));
        questionRepository.createQuestion(new Question("test2", "test2", user, timestamp));
        questionRepository.createQuestion(new Question("test3", "test3", user, timestamp));
        questionRepository.createQuestion(new Question("test4", "test4", user, timestamp));
        questionRepository.createQuestion(new Question("test5", "test5", user, timestamp));
        questionRepository.createQuestion(new Question("test6", "test6", user, timestamp));


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

    @Test
    public void shouldUpdateNumberOfLikes(){
        JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
        String query = "UPDATE QUESTION SET LIKES=LIKES+1 WHERE ID=?";
        Integer questionID = new Integer(23);
        when(jdbcTemplate.update(query,new Object[] {questionID})).thenReturn(1);
        QuestionRepository questionRepository = new QuestionRepository(dataSource);
        assertThat(questionRepository.addLikesById(questionID), is(1));
    }

    @Test
    public void shouldUpdateNumberOfDisLikes(){
        JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
        String query = "UPDATE QUESTION SET DISLIKES=DISLIKES+1 WHERE ID=?";
        Integer questionID = new Integer(23);
        when(jdbcTemplate.update(query,new Object[] {questionID})).thenReturn(1);
        QuestionRepository questionRepository = new QuestionRepository(dataSource);
        assertThat(questionRepository.addDisLikesById(questionID), is(1));
    }

    @Test
    public void shouldUpdateNumberOfFlags(){
        JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
        String query = "UPDATE QUESTION SET FLAGS=FLAGS+1 WHERE ID=?";
        Integer questionID = new Integer(23);
        when(jdbcTemplate.update(query,new Object[] {questionID})).thenReturn(1);
        QuestionRepository questionRepository = new QuestionRepository(dataSource);
        assertThat(questionRepository.addFlagsById(questionID), is(1));
    }

}












