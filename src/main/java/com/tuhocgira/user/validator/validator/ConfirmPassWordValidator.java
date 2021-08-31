package com.tuhocgira.user.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tuhocgira.common.util.ValidatorUtils;
import com.tuhocgira.user.dto.CreateUserDto;
import com.tuhocgira.user.validator.anotation.ConfirmPassword;

public class ConfirmPassWordValidator implements ConstraintValidator<ConfirmPassword, CreateUserDto> {
	private String message;

	@Override
	public void initialize(ConfirmPassword constraintAnnotation) {
		message=constraintAnnotation.message();
	}

	@Override
	public boolean isValid(CreateUserDto dto, ConstraintValidatorContext context) {
		if(dto.getPassword()==null||dto.getConfirmPassWord()==null)
			ValidatorUtils.addError(context, message);
		if(dto.getPassword().equals(dto.getConfirmPassWord()))
			return true;
		
		ValidatorUtils.addError(context, message);
		return false;
	}

}
