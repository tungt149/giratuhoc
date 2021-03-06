package com.tuhocgira.role.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuhocgira.common.util.ResponseHandler;
import com.tuhocgira.dto.AddProgramDto;
import com.tuhocgira.dto.CreateRoleDto;
import com.tuhocgira.dto.RoleDto;
import com.tuhocgira.dto.UpdateRoleDto;
import com.tuhocgira.role.entity.Role;
import com.tuhocgira.service.RoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {

	private RoleService service;

	public RoleController(RoleService roleService) {
		service = roleService;
	}

	@GetMapping
	public Object findAllRole() {

		List<RoleDto> roles = service.findAll();
		return ResponseHandler.getResponse(roles, HttpStatus.OK);
	}

	@PostMapping
	public Object saveRole(@Valid @RequestBody CreateRoleDto dto, BindingResult errors) {
		if (errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);

		Role addedRole = service.addNewRole(dto);
		return ResponseHandler.getResponse(addedRole, HttpStatus.CREATED);
	}

	@PostMapping("/add-program")
	public Object addProgram(@Valid @RequestBody AddProgramDto dto, BindingResult errors) {
		if (errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);

		Role updatedRole = service.addProgram(dto);

		return ResponseHandler.getResponse(updatedRole, HttpStatus.OK);
	}

	@PostMapping("/remove-program")
	public Object removeProgram(@Valid @RequestBody AddProgramDto dto, BindingResult errors) {
		if (errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);

		Role updatedRole = service.RemoveProgram(dto);
		return ResponseHandler.getResponse(updatedRole, HttpStatus.OK);

	}

	@PutMapping
	public Object updateRole(@Valid @RequestBody UpdateRoleDto dto, BindingResult errors) {
		if (errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);

		Role updatedRole = service.updateRole(dto, dto.getId());
		return ResponseHandler.getResponse(updatedRole, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{role-id}")
	public Object deleteRole(@PathVariable("role-id") Long id) {

		service.deleteById(id);
		return ResponseHandler.getResponse(HttpStatus.OK);
	}

}
