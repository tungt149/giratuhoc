package com.tuhocgira.service;

import java.util.List;

import javax.validation.Valid;

import com.tuhocgira.dto.AddRoleDto;
import com.tuhocgira.dto.AddUserDto;
import com.tuhocgira.dto.CreateGroupDto;

import com.tuhocgira.dto.GroupDto;
import com.tuhocgira.role.entity.Group;

public interface GroupService {

	List<GroupDto> findAll();

	boolean isTakenName(String groupName);

	Group addNewGroup(CreateGroupDto dto);

	Group addNewRole(@Valid AddRoleDto dto);

	Group addUser(@Valid AddUserDto dto);

}
