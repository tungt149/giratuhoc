package com.tuhocgira.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tuhocgira.role.util.HttpMethods;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CreateProgramDto {
	@NotBlank(message = "{role.name.not-blank}")
	@Size(min = 3, max = 50, message = "{program.name.size}")
	private String name;
	
	@NotBlank
	private String path;
	
	@NotNull
	private HttpMethods methods;

	
	
}
