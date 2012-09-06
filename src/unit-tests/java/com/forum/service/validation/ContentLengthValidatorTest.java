package com.forum.service.validation;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintValidatorContext;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

public class ContentLengthValidatorTest {

    private ContentLengthValidator contentLengthValidator;
    private ConstraintValidatorContext mockConstraintValidatorContext;

    @Before
    public void setup() {
        contentLengthValidator = new ContentLengthValidator();
        mockConstraintValidatorContext = mock(ConstraintValidatorContext.class);
    }

    @Test
    public void shouldStripHTML() {
        String text = "Hello!<br><br><br>&lt;p&gt;<span style=\"background-color: #40a0ff; \">We</span> ar<strong>e f</strong>ine.&lt;/p&gt;<br><br><ul><li>dfd</li><li>3434</li></ul>";
        String expectedStripedHTML = "Hello!<p>We are fine.</p>dfd3434";
        String stripedHTML = contentLengthValidator.stripHTML(text);
        assertThat(stripedHTML, is(expectedStripedHTML));
    }

    @Test
    public void shouldStripHTMLWithManySpaces() {
        String text = "&nbsp; &nbsp; &nbsp; &nbsp;<br><br><br>&nbsp;<br>this is a nice day lu!! &nbsp; &nbsp; &nbsp; &nbsp;yes rohit &nbsp; &nbsp;.<br><br>";
        String expectedStripedHTML = "this is a nice day lu!!    yes rohit  .";
        String stripedHTML = contentLengthValidator.stripHTML(text);
        assertThat(stripedHTML, is(expectedStripedHTML));
    }

    @Test
    public void shouldReturnTrue(){
        String text = "";
        for(int i=0; i<1000; i++){
            text +="U";
        }
        assertTrue(contentLengthValidator.isValid(text, mockConstraintValidatorContext));
    }

    @Test
    public void shouldReturnTrueWithHTMLTag(){
        String text = "";
        for(int i=0; i<1000; i++){
            text +="U";
        }
        text = "<p>"+text+"</p>";
        assertTrue(contentLengthValidator.isValid(text, mockConstraintValidatorContext));
    }

    @Test
    public void shouldReturnFailed(){
        String text = "";
        for(int i=0; i<1001; i++){
            text +="U";
        }
        assertFalse(contentLengthValidator.isValid(text, mockConstraintValidatorContext));
    }

    @Test
    public void shouldReturnFalseWithHTMLTag(){
        String text = "";
        for(int i=0; i<994; i++){
            text +="U";
        }
        text = "&lt;p&gt;"+text+"&lt;/p&gt;";
        assertFalse(contentLengthValidator.isValid(text, mockConstraintValidatorContext));
    }
}
