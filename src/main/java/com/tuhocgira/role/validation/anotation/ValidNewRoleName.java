package com.tuhocgira.role.validation.anotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.tuhocgira.role.validation.validator.ValidNewRoleNameValidator;


@Constraint(validatedBy = ValidNewRoleNameValidator.class)
@Retention(RUNTIME)
@Target(ElementType.TYPE)
public @interface ValidNewRoleName {
	String message() default "trung ten cu roi ba con.";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
