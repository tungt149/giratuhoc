package com.tuhocgira.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.tuhocgira.user.validator.anotation.ConfirmPassword;
import com.tuhocgira.user.validator.anotation.UniqueEmail;
import com.tuhocgira.user.validator.anotation.UniqueUserName;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ConfirmPassword
public class CreateUserDto {
	@NotBlank(message = "{user.username.not-blank}")

	@UniqueUserName
	private String userName;

	@NotBlank(message = "{user.password.not-blank}")
	private String password;

	@NotBlank(message = "{user.confirm-password.not-blank}")
	private String confirmPassWord;

	@NotBlank(message = "{user.email.not-blank}")
	@Email(message = "{user.email.valid}")
	@UniqueEmail
	private String email;

}
