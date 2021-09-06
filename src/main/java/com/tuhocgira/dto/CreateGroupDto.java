package com.tuhocgira.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.tuhocgira.role.validation.anotation.UniqueGroupName;
import com.tuhocgira.role.validation.anotation.ValidGroupDescription;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateGroupDto {
	@NotBlank(message = "{group.name.not-blank}")
	@Size(min = 3, max = 50, message = "{role.name.size}")
	@UniqueGroupName(message = "{group.name.used}")
	private String name;
	
	@ValidGroupDescription
	private String description;
	
	
}
