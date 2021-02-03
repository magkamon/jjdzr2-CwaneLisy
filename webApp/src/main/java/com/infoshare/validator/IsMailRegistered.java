package com.infoshare.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueMailValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface IsMailRegistered {

    public String message() default "Podany email nie istnieje w bazie danych";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default{};
}
