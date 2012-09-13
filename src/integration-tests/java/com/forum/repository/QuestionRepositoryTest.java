package com.forum.repository;


import com.forum.domain.Question;
import com.forum.domain.User;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuestionRepositoryTest extends IntegrationTestBase {

    Logger logger = Logger.getLogger(Question.class.getName());
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

        assertThat(questionRepository.createQuestion(question),is(6));
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

    @Test
    public void shouldGetQuestionsByTagName(){

        //Given
        String tagAsString = "AwesomeSauce";
        User user = new User("Henry", "HenryMum", "Henry", "henry@henry.henry", "1234567890", "India", "Male", 1, false);
        Date date =  new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        Question testQuestion1 = new Question(100, "test Question", "test description", user, timestamp, 0, 0, 0, tagAsString);
        Question testQuestion2 = new Question(200, "test Question1", "test description1", user, timestamp, 0, 0, 0, tagAsString);
        Question testQuestion3 = new Question(300, "test Question2", "test description2", user, timestamp, 0, 0, 0, "Actually no");


        UserRepository userRepository = new UserRepository(dataSource);
        userRepository.createUser(user);
        user.setId(userRepository.getUserId(user.getUsername()));


        questionRepository.createQuestion(testQuestion1);
        questionRepository.createQuestion(testQuestion2);
        questionRepository.createQuestion(testQuestion3);

        List<Question> expectedQuestions = new ArrayList<Question>();

        //When
        List<Question> questions = questionRepository.getByTag(tagAsString);
        assertThat(questions.size(), is(2));

        //Then

        assertThat(questions.get(0).getTitle(), is("test Question1"));
        assertThat(questions.get(0).getDescription(), is("test description1"));

        assertThat(questions.get(1).getTitle(), is("test Question"));
        assertThat(questions.get(1).getDescription(), is("test description"));




    }

}












