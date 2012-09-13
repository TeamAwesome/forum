package com.forum.service.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TagLengthValidator implements ConstraintValidator<TagLength,String> {
    private TagLength tagLength;
    private final int MAX_TAG_LENGTH = 20;

    @Override
    public void initialize(TagLength tagLength) {
        this.tagLength = tagLength;
    }

    @Override
    public boolean isValid(String tagList, ConstraintValidatorContext constraintValidatorContext) {
        String[] splitTags = tagList.split(",");
        for (String tag : splitTags){
            if (tag.length() > MAX_TAG_LENGTH){
                return false;
            }
        }
        return true;
    }
}
