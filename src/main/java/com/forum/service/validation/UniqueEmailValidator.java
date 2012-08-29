package com.forum.service.validation;

import com.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
    private UniqueEmail uniqueEmail;
    private UserService userService;

    @Override
    public void initialize(UniqueEmail uniqueEmail) {
        this.uniqueEmail = uniqueEmail;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        boolean existence =  userService.checkExistenceOfEmail(email);
        return !existence;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
