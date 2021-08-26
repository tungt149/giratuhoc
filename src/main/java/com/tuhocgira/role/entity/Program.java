package com.tuhocgira.role.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.tuhocgira.common.entity.BaseEntity;
import com.tuhocgira.role.util.HttpMethods;

@Entity
public class Program extends BaseEntity{
		
	private String name;
	private String description;
	private HttpMethods methods;
	private String path;
	
	@ManyToMany(mappedBy = "programs")
	private Set<Role>roles=new HashSet<>();
}
