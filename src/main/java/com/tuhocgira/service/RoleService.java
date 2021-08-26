package com.tuhocgira.service;

import java.util.List;

import com.tuhocgira.dto.CreateRoleDto;
import com.tuhocgira.role.entity.Role;

public interface RoleService {
	List<Role> findAll();

	Role addNewRole(CreateRoleDto dto);}

