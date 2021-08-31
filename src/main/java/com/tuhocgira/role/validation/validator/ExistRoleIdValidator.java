package com.tuhocgira.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tuhocgira.common.util.ValidatorUtils;
import com.tuhocgira.role.validation.anotation.ExistRoleId;
import com.tuhocgira.service.RoleService;



public class ExistRoleIdValidator implements ConstraintValidator<ExistRoleId, Long> {
	private String message;
	private RoleService  service;
	
	public ExistRoleIdValidator(RoleService roleService) {
		service = roleService;
	}
	
	@Override
	public void initialize(ExistRoleId constraintAnnotation) {
		message = constraintAnnotation.message();
	}
	
	@Override
	public boolean isValid(Long roleId, ConstraintValidatorContext context) {
		boolean isExisted = service.existRoleId(roleId);
		
		if(isExisted)
			return true;
		
		ValidatorUtils.addError(context, message);
		return false;
	}

}
