package com.tuhocgira.user.service;

import java.util.List;

import javax.validation.Valid;

import com.tuhocgira.user.dto.CreateUserDto;
import com.tuhocgira.user.dto.UserDto;
import com.tuhocgira.user.entity.User;

public interface UserService {

	List<UserDto> findAll();

	

	boolean isTakenName(String userName);



	boolean isTakenEmail(String email);



	User createUser(CreateUserDto dto);

}
