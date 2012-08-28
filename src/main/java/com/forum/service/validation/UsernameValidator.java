package com.forum.service.validation;

import com.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<Username,String> {

    private Username username;
    private UserService userService;

    @Override
    public void initialize(Username username) {
        this.username = username;
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
