package com.tuhocgira.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.tuhocgira.role.validation.anotation.ExistProgramId;
import com.tuhocgira.role.validation.anotation.ExistRoleId;



public class AddProgramDto {
	
		@NotNull
		@Min(value = 1)
		@ExistRoleId
		private Long roleId;
		
		@NotNull
		@Min(value = 1)
		@ExistProgramId
		private Long programId;
		
		public Long getRoleId() {
			return roleId;
		}
		public void setRoleId(Long roleId) {
			this.roleId = roleId;
		}
		public Long getProgramId() {
			return programId;
		}
		public void setProgramId(Long programId) {
			this.programId = programId;
		}
	}
