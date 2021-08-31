package com.tuhocgira.user.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tuhocgira.common.util.ValidatorUtils;
import com.tuhocgira.user.service.UserService;
import com.tuhocgira.user.validator.anotation.UniqueEmail;

public class UniqueEmailEmailValidator implements ConstraintValidator<UniqueEmail, String> {
	private String message;
	private UserService service;

	public UniqueEmailEmailValidator(UserService userService) {
		service = userService;
	}

	@Override
	public void initialize(UniqueEmail constraintAnnotation) {
		message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if(email==null)
			return false;
		boolean IsTaken = service.isTakenEmail(email);
		if (!IsTaken)
			return true;
		ValidatorUtils.addError(context, message);
		return false;
	}

}
