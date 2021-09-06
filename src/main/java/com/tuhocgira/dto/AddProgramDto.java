package com.tuhocgira.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.tuhocgira.role.validation.anotation.ExistProgramId;
import com.tuhocgira.role.validation.anotation.ExistRoleId;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AddProgramDto {
	
		@NotNull
		@Min(value = 1)
		@ExistRoleId
		private Long roleId;
		
		@NotNull
		@Min(value = 1)
		@ExistProgramId
		private Long programId;
		
	}
