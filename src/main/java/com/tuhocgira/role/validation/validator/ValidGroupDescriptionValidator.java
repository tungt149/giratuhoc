package com.tuhocgira.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tuhocgira.common.util.ValidatorUtils;
import com.tuhocgira.role.validation.anotation.ValidGroupDescription;


public class ValidGroupDescriptionValidator implements ConstraintValidator<ValidGroupDescription, String> {
	private String message;

	@Override
	public void initialize(ValidGroupDescription constraintAnnotation) {
		message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(String description, ConstraintValidatorContext context) {
		if (description == null) {
			ValidatorUtils.addError(context, message);
			return false;
		}
		description = description.trim();
		if (description.length() < 5) {
			ValidatorUtils.addError(context, message);
			return false;
		}

		return true;
	}

}
