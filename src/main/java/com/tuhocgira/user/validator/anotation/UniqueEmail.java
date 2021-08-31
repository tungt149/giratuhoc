package com.tuhocgira.user.validator.anotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.tuhocgira.user.validator.validator.UniqueEmailEmailValidator;
@Constraint(validatedBy = UniqueEmailEmailValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface UniqueEmail {
	String message() default "Email has been used";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
