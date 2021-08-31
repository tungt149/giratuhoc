package com.tuhocgira.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tuhocgira.common.util.ValidatorUtils;
import com.tuhocgira.role.validation.anotation.ExistProgramId;
import com.tuhocgira.service.ProgramService;



public class ExistProgramIdValidator implements ConstraintValidator<ExistProgramId, Long> {
	private String message;
	private ProgramService service;
	
	public ExistProgramIdValidator(ProgramService programService) {
		service = programService;
	}
	
	@Override
	public void initialize(ExistProgramId constraintAnnotation) {
		message = constraintAnnotation.message();
	}
	@Override
	public boolean isValid(Long programId, ConstraintValidatorContext context) {
		boolean isExisted = service.isExistId(programId);
		
		if(isExisted)
			return true;
		
		ValidatorUtils.addError(context, message);
		return false;
	}
}
