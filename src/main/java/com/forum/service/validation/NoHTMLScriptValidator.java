package com.forum.service.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NoHTMLScriptValidator implements ConstraintValidator<NoHTMLScript, String> {
    @Override
    public void initialize(NoHTMLScript noHTMLScript) {
    }

    @Override
    public boolean isValid(String title, ConstraintValidatorContext constraintValidatorContext) {
        return !title.matches("<script.*?>");
    }
}
