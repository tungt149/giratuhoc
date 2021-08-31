package com.tuhocgira.role.validation.anotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.tuhocgira.role.validation.validator.ExistRoleIdValidator;
@Constraint(validatedBy = ExistRoleIdValidator.class)
@Retention(RUNTIME)
@Target(FIELD)
public @interface ExistRoleId {
public String message() default "Role doesn't exist.";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
