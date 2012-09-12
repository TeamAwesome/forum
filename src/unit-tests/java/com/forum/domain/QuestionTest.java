package com.forum.domain;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;

public class QuestionTest {
    private static Validator validator;
    private static ValidatorFactory factory;
    private static Logger logger = Logger.getLogger(QuestionTest.class.getName());

    @BeforeClass
    public static void setUp() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void shouldValidateEmptyTitle() {
        Question question = new Question("      ", "", new User(), new Date());

        Set<ConstraintViolation<Question>> validationResult = validator.validateProperty(question, "title");

        assertThat(validationResult.size(), is(1));
        assertThat(validationResult.iterator().next().getMessage(), is("Title is empty."));
    }

    @Test
    public void shouldValidateEmptyDescription() {
        Question question = new Question("", "      ", new User(), new Date());

        Set<ConstraintViolation<Question>> validationResult = validator.validateProperty(question, "description");

        assertThat(validationResult.size(), is(1));
        assertThat(validationResult.iterator().next().getMessage(), is("Description is empty."));
    }

    @Test
    public void shouldNotAllowHTMLScriptsOnTitle() {
        Question question = new Question("<script type=\"text/javascript\"></script>", "", new User(), new Date());

        Set<ConstraintViolation<Question>> validationResult = validator.validateProperty(question, "title");

        assertThat(validationResult.size(), is(1));
        assertThat(validationResult.iterator().next().getMessage(), is("Title Cannot Have Scripts or HTML elements."));
    }

    @Test
    public void shouldGetTags() {
        Question question = new Question(
                123,"a title", "a description", new User(), new Date(), 12, 23, 34, "Foo, Bar, Baz"
        );
        List<Tag> tagList = question.getTags();
        assertThat(tagList.size(), is(3));
        assertTrue("should contain a tag 'Foo'", tagList.contains(new Tag("Foo")));
        assertTrue("should contain a tag 'Bar'", tagList.contains(new Tag("Bar")));
        assertTrue("should contain a tag 'Baz'", tagList.contains(new Tag("Baz")));
    }

    @Test
    public void shouldHandleNullAsTagAsString(){
        Question question = new Question(
                123,"a title", "a description", new User(), new Date()
        );

        assertThat(question.getTags().size(), is(0));
    }

    @Test
    public void shouldRejectSpecialCharactersInTagString() {
        Question question = new Question(
                123,"a title", "a description", new User(), new Date(), 12, 23, 34, "abcd1234<>,."
        );

        Set<ConstraintViolation<Question>> validationResult = validator.validateProperty(question, "tagsAsString");
        assertThat(validationResult.size(), is(1));
    }

    @Test
    public void shouldAcceptAlphanumericCharactersIncludingSpecialGermanCharacters() {
        Question question = new Question(
                123,"a title", "a description", new User(), new Date(), 12, 23, 34,
                "abcdefghijk lmnopqrstu, vwxyzABCD EFGHIJKLMNO, PQRSTUVWXYZ0 123456789äÄöÖüÜß"
        );

        Set<ConstraintViolation<Question>> validationResult = validator.validateProperty(question, "tagsAsString");
        assertThat(validationResult.size(), is(0));
    }

    @Test
    public void shouldRejectWhat() {
        Question questionWhat = new Question(
                123,"a title", "a description", new User(), new Date(), 12, 23, 34, "wHat"
        );
        Question questionWhy = new Question(
                123,"a title", "a description", new User(), new Date(), 12, 23, 34, "why"
        );
        Question questionWho = new Question(
                123,"a title", "a description", new User(), new Date(), 12, 23, 34, "Who"
        );
        Question questionHow = new Question(
                123,"a title", "a description", new User(), new Date(), 12, 23, 34, "HOW"
        );

        Set<ConstraintViolation<Question>> validationResultWhat = validator.validateProperty(questionWhat, "tagsAsString");
        Set<ConstraintViolation<Question>> validationResultWhy = validator.validateProperty(questionWhy, "tagsAsString");
        Set<ConstraintViolation<Question>> validationResultWho = validator.validateProperty(questionWho, "tagsAsString");
        Set<ConstraintViolation<Question>> validationResultHow = validator.validateProperty(questionHow, "tagsAsString");

        assertThat(validationResultWhat.size(), is(1));
        assertThat(validationResultWhy.size(), is(1));
        assertThat(validationResultWho.size(), is(1));
        assertThat(validationResultHow.size(), is(1));
    }

    @Test
    public void shouldRejectHowAndWhenWithSpaceAndComma() {
        Question question = new Question(
                123,"a title", "a description", new User(), new Date(), 12, 23, 34, "how when,"
        );

        Set<ConstraintViolation<Question>> validationResult = validator.validateProperty(question, "tagsAsString");
        assertThat(validationResult.size(), is(1));
    }

    @Test
    public void shouldFilterEmptyTags() {
        Question question = new Question(
                123,"a title", "a description", new User(), new Date(), 12, 23, 34, "Foo, , Bar,  \t     , Baz, "
        );
        List<Tag> tagList = question.getTags();
        assertThat(tagList.size(), is(3));
        assertTrue("should contain a tag 'Foo'", tagList.contains(new Tag("Foo")));
        assertTrue("should contain a tag 'Bar'", tagList.contains(new Tag("Bar")));
        assertTrue("should contain a tag 'Baz'", tagList.contains(new Tag("Baz")));
    }

}
