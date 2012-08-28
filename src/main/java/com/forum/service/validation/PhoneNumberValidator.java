package com.forum.service.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    public static final int LENGTH_OF_PHONENUMBER = 10;
    private PhoneNumber phoneNumber;


    @Override
    public void initialize(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        if (phoneNumber == "")
            return true;
        Pattern pattern = Pattern.compile("\\d{"+LENGTH_OF_PHONENUMBER+"}");
        Matcher matcher = pattern.matcher(phoneNumber);
        return  matcher.matches();
    }
}
