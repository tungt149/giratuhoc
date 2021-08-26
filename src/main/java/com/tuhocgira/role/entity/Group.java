package com.tuhocgira.role.entity;


import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

import com.tuhocgira.common.entity.BaseEntity;

@Entity
@Table(name = "gira_group")
public class Group extends BaseEntity {

	private String name;
	private String description;

	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name ="gira_group_role",
	joinColumns = @JoinColumn(name="group_id"),
	inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role>roles = new HashSet<>();
	
}
