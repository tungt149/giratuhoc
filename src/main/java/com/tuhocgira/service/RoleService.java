package com.tuhocgira.service;

import java.util.List;

import javax.validation.Valid;

import com.tuhocgira.dto.AddProgramDto;
import com.tuhocgira.dto.CreateRoleDto;
import com.tuhocgira.dto.RoleDto;
import com.tuhocgira.role.entity.Role;

public interface RoleService {
	List<RoleDto> findAll();

	Role addNewRole(CreateRoleDto dto);

	Role addProgram(@Valid AddProgramDto dto);}

