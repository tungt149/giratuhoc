package com.tuhocgira.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tuhocgira.common.util.ValidatorUtils;

import com.tuhocgira.role.validation.anotation.ValidRoleDescription;

public class ValidRoleDescriptionValidator implements ConstraintValidator<ValidRoleDescription, String> {
	private String message;

	@Override
	public void initialize(ValidRoleDescription constraintAnnotation) {
		this.message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(String description, ConstraintValidatorContext context) {
		if (description == null) {
			ValidatorUtils.addError(context, message);
			return false;
		}
		// mutable
		description = description.trim();
		if (description.length() < 5) {
			ValidatorUtils.addError(context, message);
			return false;
		}

		return true;
	}

}
