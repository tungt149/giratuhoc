package com.tuhocgira.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.tuhocgira.role.validation.anotation.ValidNewRoleName;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@ValidNewRoleName
public class UpdateRoleDto {
	@NotNull
	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	private String oldName;
	private String description;

	
}
