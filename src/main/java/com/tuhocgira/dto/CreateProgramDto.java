package com.tuhocgira.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tuhocgira.role.util.HttpMethods;

public class CreateProgramDto {
	@NotBlank(message = "{role.name.not-blank}")
	@Size(min = 3, max = 50, message = "{program.name.size}")
	private String name;
	
	@NotBlank
	private String path;
	
	@NotNull
	private HttpMethods methods;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public HttpMethods getMethods() {
		return methods;
	}

	public void setMethods(HttpMethods methods) {
		this.methods = methods;
	}

	
}
