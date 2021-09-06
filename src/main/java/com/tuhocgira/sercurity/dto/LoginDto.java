package com.tuhocgira.sercurity.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginDto {
	@NotBlank(message = "{login.usename.notBlank}")
	private String username;
	@NotBlank(message = "{password.usename.notBlank}")
	private String password;

	

}
