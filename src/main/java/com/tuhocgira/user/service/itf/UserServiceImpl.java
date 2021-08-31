package com.tuhocgira.user.service.itf;

import java.util.List;

import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tuhocgira.user.dto.CreateUserDto;
import com.tuhocgira.user.dto.UserDto;
import com.tuhocgira.user.entity.User;
import com.tuhocgira.user.repository.UserRepository;
import com.tuhocgira.user.service.UserService;
import com.tuhocgira.user.util.UserStatus;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository repository;
	private PasswordEncoder encoder;

	public UserServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder) {
		repository = userRepository;
		encoder = passwordEncoder;
	}

	@Override
	public List<UserDto> findAll() {

		return repository.findAllUserDto();
	}

	@Override
	public boolean isTakenName(String userName) {

		return repository.countByUserName(userName.toLowerCase()) >= 1;
	}

	@Override
	public boolean isTakenEmail(String email) {

		return repository.countByEmail(email) >= 1;
	}

	@Override
	public User createUser(@Valid CreateUserDto dto) {
		User newUser = new User();
		newUser.setUserName(dto.getUserName());
		newUser.setEmail(dto.getEmail());
		newUser.setPassword(encoder.encode(dto.getPassword()));
		newUser.setStatus(UserStatus.ACTIVE);
		return repository.save(newUser);
	}

}
