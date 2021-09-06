package com.tuhocgira.role.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuhocgira.common.util.ResponseHandler;
import com.tuhocgira.dto.AddRoleDto;
import com.tuhocgira.dto.AddUserDto;
import com.tuhocgira.dto.CreateGroupDto;

import com.tuhocgira.dto.GroupDto;
import com.tuhocgira.role.entity.Group;
import com.tuhocgira.service.GroupService;

@RestController
@RequestMapping("/api/group")
public class GroupController {
	private GroupService service;

	public GroupController(GroupService groupService) {
		service = groupService;
	}

	@GetMapping
	public Object findAllGroupDto() {
		List<GroupDto> groups = service.findAll();
		return ResponseHandler.getResponse(groups, HttpStatus.OK);

	}

	@PostMapping
	public Object createGroup(@Valid @RequestBody CreateGroupDto dto, BindingResult errors) {
		if (errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);

		Group newGroup = service.addNewGroup(dto);
		return ResponseHandler.getResponse(newGroup, HttpStatus.OK);
	}

	@PostMapping("/add-role")
	public Object addRole(@Valid @RequestBody AddRoleDto dto, BindingResult errors) {
		if (errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);

		Group addRole = service.addNewRole(dto);

		return ResponseHandler.getResponse(addRole, HttpStatus.OK);
	}

	@PostMapping("/add-user")
	public Object addUserGroup(@Valid @RequestBody AddUserDto dto, BindingResult errors) {
		if (errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
		Group updateGroup = service.addUser(dto);
		return ResponseHandler.getResponse(updateGroup, HttpStatus.OK);
	}
}