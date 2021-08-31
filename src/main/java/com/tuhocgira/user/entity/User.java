package com.tuhocgira.user.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tuhocgira.common.entity.BaseEntity;
import com.tuhocgira.role.entity.Group;
import com.tuhocgira.user.util.UserStatus;

@Entity
@Table(name = "gira_user")
public class User extends BaseEntity {
	@NotNull
	@Column(unique = true)
	@Size(min = 3, max = 50)
	private String userName;
	@NotNull
	private String password;
	@NotNull
	@Email
	@Column(unique = true)
	private String email;

	private String fullName;
	private String avatar;
	private String displayName;
	@NotNull
	@Enumerated(EnumType.STRING)
	private UserStatus status;
	private String facebook;
	private String deparment;
	private String hobby;
	@ManyToMany(mappedBy = "users")
	private Set<Group> groups = new HashSet<>();

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getFullName() {
		return fullName;
	}

	public String getAvatar() {
		return avatar;
	}

	public String getDisplayName() {
		return displayName;
	}

	public UserStatus getStatus() {
		return status;
	}

	public String getFacebook() {
		return facebook;
	}

	public String getDeparment() {
		return deparment;
	}

	public String getHobby() {
		return hobby;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public void setDeparment(String deparment) {
		this.deparment = deparment;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

}
