package com.tuhocgira.user.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tuhocgira.common.util.ValidatorUtils;
import com.tuhocgira.user.service.UserService;
import com.tuhocgira.user.validator.anotation.UniqueUserName;

public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {
	private String message;
	private UserService service;

	public UniqueUserNameValidator(UserService userService) {
		service = userService;
	}

	@Override
	public void initialize(UniqueUserName constraintAnnotation) {
		message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(String userName, ConstraintValidatorContext context) {
		if(userName==null)
			return false;
		boolean isTakenName = service.isTakenName(userName);
		if(!isTakenName)
			return true;
		ValidatorUtils.addError(context, message);
		return false;
	}

}
