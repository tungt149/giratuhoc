package com.tuhocgira.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.tuhocgira.role.validation.anotation.UniqueRoleName;

import com.tuhocgira.role.validation.anotation.ValidRoleDescription;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CreateRoleDto {
	@NotBlank(message = "{role.name.not-blank}")
	@Size(min = 3, max = 50, message = "{group.name.size}")
	@UniqueRoleName(message ="{group.name.used}" )
	private String name;
	@ValidRoleDescription
	private String description;

	
}
