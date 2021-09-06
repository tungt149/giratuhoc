package com.tuhocgira.user.controller;

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
import com.tuhocgira.user.dto.CreateUserDto;
import com.tuhocgira.user.dto.UserDto;
import com.tuhocgira.user.entity.User;
import com.tuhocgira.user.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {
	private UserService service;

	public UserController(UserService userService) {
		service = userService;
	}

	@GetMapping
	public Object findAllUser() {
		List<UserDto> users = service.findAll();
		return ResponseHandler.getResponse(users, HttpStatus.OK);
	}

	@PostMapping
	public Object createUser(@Valid @RequestBody CreateUserDto dto, BindingResult errors) {
		if (errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
		User newUser = service.createUser(dto);
		return ResponseHandler.getResponse(newUser, HttpStatus.OK);

	}
}
