package com.tuhocgira.dto;

import java.util.Set;

import com.tuhocgira.role.entity.Role;

public interface GroupDto {
	public Long getId();
	public String getName();

	public String getDescription();

	public Set<Role> getRoles();

}
