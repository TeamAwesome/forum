package com.forum.domain;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class QuestionTest {
    private static Validator validator;
    private static ValidatorFactory factory;

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
}
