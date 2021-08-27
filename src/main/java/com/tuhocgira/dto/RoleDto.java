package com.tuhocgira.dto;

import java.util.Set;

public interface RoleDto {
//projection
	public Long getId();
	public String getName();
	public String getDescription();
	public Set<ProgramDto>getPrograms();
	
}
