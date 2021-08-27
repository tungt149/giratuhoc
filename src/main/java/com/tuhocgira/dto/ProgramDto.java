package com.tuhocgira.dto;

import com.tuhocgira.role.util.HttpMethods;

public interface ProgramDto {
	public Long getId();

	public String getName();

	public HttpMethods getMethod();

	public String getPath();
}
