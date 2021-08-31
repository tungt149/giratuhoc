//package com.tuhocgira.role.validation.validator;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//import com.tuhocgira.common.util.ValidatorUtils;
//import com.tuhocgira.role.validation.anotation.UniqueGroupNametuilam;
//import com.tuhocgira.service.GroupService;
//
//public class UniqueGroupNameValidatortuilam implements ConstraintValidator<UniqueGroupNametuilam, String> {
//	private GroupService service;
//	private String message;
//	
//	@Override
//	public void initialize(UniqueGroupNametuilam constraintAnnotation) {
//		message=constraintAnnotation.message();
//	}
//	@Override
//	public boolean isValid(String groupName, ConstraintValidatorContext context) {
//		boolean isTaken = service.isTakenName(groupName);
//		if (!isTaken)
//			return true;
//
//		ValidatorUtils.addError(context, message);
//		return false;
//	}
//
//	
//
//}
