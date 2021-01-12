package com.infoshare.validator;

import com.infoshare.util.ValidatorEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RegExpPatternValidator implements ConstraintValidator<RegExpPattern, String> {
    ValidatorEnum validatorEnum;

    @Override
    public void initialize(RegExpPattern constraintAnnotation) {
        validatorEnum = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.matches(validatorEnum.getRegex())){
            return true;
        }else{
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(validatorEnum.getErrorMessage()).addConstraintViolation();
            return false;
        }
    }
}
