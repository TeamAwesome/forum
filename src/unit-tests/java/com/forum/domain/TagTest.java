package com.forum.domain;

import org.hibernate.validator.HibernateValidator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.validation.ConstraintViolation;
import java.util.Set;
import java.util.logging.Logger;

public class TagTest {

    private static final Logger logger = Logger.getLogger(TagTest.class.getName());
    private LocalValidatorFactoryBean localValidatorFactory;

    @Before
    public void setup() {
        localValidatorFactory = new LocalValidatorFactoryBean();
        localValidatorFactory.setProviderClass(HibernateValidator.class);
        localValidatorFactory.afterPropertiesSet();
    }

    @Test
    public void shouldRejectSpecialCharactersInName() {
        Tag tag = new Tag("abcd123,.<>");

        Set<ConstraintViolation<Tag>> constraintViolations = localValidatorFactory.validate(tag);
        logger.info("constraintViolations = " + constraintViolations.toString());

        assertThat(constraintViolations.size(),is(1));
    }

    @Test
    public void shouldAcceptAlphanumericCharactersIncludingSpecialGermanCharacters() {
        Tag tag = new Tag(
                "defghi XZ89äÄöÖüÜß"
        );

        Set<ConstraintViolation<Tag>> constraintViolations = localValidatorFactory.validate(tag);
        assertThat(constraintViolations.size(),is(0));
    }

    @Test
    public void shouldRejectTabsInName() {
        Tag tag = new Tag("\t");

        Set<ConstraintViolation<Tag>> constraintViolations = localValidatorFactory.validate(tag);
        logger.info("constraintViolations = " + constraintViolations.toString());

        assertThat(constraintViolations.size(),is(1));
    }

}
