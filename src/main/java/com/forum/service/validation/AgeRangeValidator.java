package com.forum.service.validation;

import com.forum.domain.AgeRange;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeRangeValidator implements ConstraintValidator<Age,Integer> {
    private Age age;

    @Override
    public void initialize(Age age) {
        this.age = age;
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        try {
            AgeRange.getAgeRange(integer);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
