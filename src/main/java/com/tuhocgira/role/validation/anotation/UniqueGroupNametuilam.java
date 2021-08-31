//package com.tuhocgira.role.validation.anotation;
//
//import static java.lang.annotation.ElementType.FIELD;
//import static java.lang.annotation.RetentionPolicy.RUNTIME;
//
//import java.lang.annotation.Retention;
//import java.lang.annotation.Target;
//
//import javax.validation.Constraint;
//import javax.validation.Payload;
//
//import com.tuhocgira.role.validation.validator.UniqueGroupNameValidatortuilam;
//
//
//@Constraint(validatedBy = UniqueGroupNameValidatortuilam.class)
//@Retention(RUNTIME)
//@Target(FIELD)
//public @interface UniqueGroupNametuilam {
//	public String message() default "Role name has been used";
//
//	Class<?>[] groups() default {};
//
//	Class<? extends Payload>[] payload() default {};
//}
