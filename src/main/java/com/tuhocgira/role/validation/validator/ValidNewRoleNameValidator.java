package com.tuhocgira.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tuhocgira.common.util.ValidatorUtils;
import com.tuhocgira.dto.UpdateRoleDto;
import com.tuhocgira.role.validation.anotation.ValidNewRoleName;
import com.tuhocgira.service.RoleService;



public class ValidNewRoleNameValidator implements ConstraintValidator<ValidNewRoleName, UpdateRoleDto> {
	private String message;
	private RoleService service;
	
	public ValidNewRoleNameValidator(RoleService roleService) {
		service = roleService;
	}
	
	@Override
	public void initialize(ValidNewRoleName constraintAnnotation) {
		message = constraintAnnotation.message();
	}
	
	@Override
	public boolean isValid(UpdateRoleDto dto, ConstraintValidatorContext context) {
		if(dto.getName().equals(dto.getOldName())) {
			boolean isTaken = service.isTakenName(dto.getName());
			
			if(!isTaken)
				return true;
		}
		
		ValidatorUtils.addError(context, message);
		return false;
	}

}
