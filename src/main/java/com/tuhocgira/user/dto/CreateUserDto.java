package com.tuhocgira.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.tuhocgira.user.validator.anotation.ConfirmPassword;
import com.tuhocgira.user.validator.anotation.UniqueEmail;
import com.tuhocgira.user.validator.anotation.UniqueUserName;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassWord() {
		return confirmPassWord;
	}

	public void setConfirmPassWord(String confirmPassWord) {
		this.confirmPassWord = confirmPassWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
