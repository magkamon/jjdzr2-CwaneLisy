package com.infoshare.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

@Constraint(validatedBy = UniqueMailAndUuidValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(TYPE)

public @interface UniqueMailAndUuid {
    String message() default "Podany adres email jest zajęty.";
    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default{};
}
