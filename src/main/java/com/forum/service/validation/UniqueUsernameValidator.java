package com.forum.service.validation;

import com.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String> {

    private UniqueUsername uniqueUsername;
    private UserService userService;

    @Override
    public void initialize(UniqueUsername username) {
        this.uniqueUsername = username;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        boolean existence =  userService.checkExistenceOfUsername(username);
        return !existence;
    }

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }
}
