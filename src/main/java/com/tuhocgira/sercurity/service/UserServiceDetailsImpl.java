package com.tuhocgira.sercurity.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tuhocgira.role.entity.Group;
import com.tuhocgira.sercurity.config.dto.UserDetailsDto;
import com.tuhocgira.user.entity.User;
import com.tuhocgira.user.repository.UserRepository;

@Service
public class UserServiceDetailsImpl implements UserDetailsService {
	private UserRepository repository;

	public UserServiceDetailsImpl(UserRepository userRepository) {
		repository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = repository.findByUsernameWithGroup(username);
		if (!user.isPresent())
			throw new UsernameNotFoundException("Username is not exist");
		Set<GrantedAuthority> authorities = getAuthorities(user.get().getGroups());

		return new UserDetailsDto(username, user.get().getPassword(), authorities);
	}

	private Set<GrantedAuthority> getAuthorities(Set<Group> groups) {
		Set<GrantedAuthority> authorities = new HashSet<>();
		for (Group group : groups) {
			authorities.add(new SimpleGrantedAuthority(group.getName()));
		}
		return authorities;
	}

}
