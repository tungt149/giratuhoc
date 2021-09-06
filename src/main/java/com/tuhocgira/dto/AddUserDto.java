package com.tuhocgira.dto;

import javax.validation.constraints.Min;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddUserDto {
	@NotNull
	@Min(value = 1)
	private Long userId;
	@NotNull
	@Min(value = 1)
	private Long GroupId;
}
