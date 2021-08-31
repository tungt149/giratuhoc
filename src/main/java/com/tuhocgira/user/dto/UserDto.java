package com.tuhocgira.user.dto;

import java.util.Set;

import com.tuhocgira.role.entity.Group;
import com.tuhocgira.user.util.UserStatus;

public interface UserDto {
//Spring projection
	public String getUserName();

	public String getEmail();

	public String getFullName();

	public String getAvatar();

	public String getDisplayName();

	public UserStatus getStatus();

	public String getFacebook();

	public String getDeparment();

	public String getHobby();

	public Set<Group> getGroups();
}
