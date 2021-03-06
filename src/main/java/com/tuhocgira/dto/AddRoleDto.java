package com.tuhocgira.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AddRoleDto {
	@NotNull
	@Min(value = 1)
	private Long RoleId;
	@NotNull
	@Min(value = 1)
	private Long GroupId;



}
