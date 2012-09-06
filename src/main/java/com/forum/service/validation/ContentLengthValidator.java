package com.forum.service.validation;

import org.apache.commons.lang.StringEscapeUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContentLengthValidator implements ConstraintValidator<ContentLength, String> {
    private ContentLength contentLength;

    @Override
    public void initialize(ContentLength contentLength) {
        this.contentLength = contentLength;
    }

    @Override
    public boolean isValid(String context, ConstraintValidatorContext constraintValidatorContext) {
        if (stripHTML(context).length() > 1000) {
            return false;
        } else {
            return true;
        }
    }

    String stripHTML(String text) {
        String regex = "<.*?>";
        String strippedHtml = text.replaceAll(regex, "");
        String decoded = decodeHTML(strippedHtml);
        String result = replaceSpace(decoded).trim();
        return result;
    }

    private String replaceSpace(String text) {
        text = text.replace((char) 160, ' ');
        return text.replace("  ", " ");
    }


    private String decodeHTML(String text) {
        return StringEscapeUtils.unescapeHtml(text);
    }
}
