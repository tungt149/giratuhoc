package com.tuhocgira.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AddRoleDto {
	@NotNull
	@Min(value = 1)
	private Long RoleId;
	@NotNull
	@Min(value = 1)
	private Long GroupId;

	public Long getRoleId() {
		return RoleId;
	}

	public void setRoleId(Long roleId) {
		RoleId = roleId;
	}

	public Long getGroupId() {
		return GroupId;
	}

	public void setGroupId(Long groupId) {
		GroupId = groupId;
	}

}
