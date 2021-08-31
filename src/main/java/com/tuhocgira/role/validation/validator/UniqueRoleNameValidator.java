package com.tuhocgira.role.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.tuhocgira.common.util.ValidatorUtils;
import com.tuhocgira.role.validation.anotation.UniqueRoleName;
import com.tuhocgira.service.RoleService;

public class UniqueRoleNameValidator implements ConstraintValidator<UniqueRoleName, String> {
	private RoleService service;
	private String message;

	@Override
	public void initialize(UniqueRoleName constraintAnnotation) {
		this.message = constraintAnnotation.message();

	}

	public UniqueRoleNameValidator(RoleService roleService) {
		service = roleService;
	}

	@Override
	public boolean isValid(String roleName, ConstraintValidatorContext context) {
		boolean isTaken = service.isTakenName(roleName);
		if (!isTaken)
			return true;

		ValidatorUtils.addError(context, message);
		return false;
	}

}
