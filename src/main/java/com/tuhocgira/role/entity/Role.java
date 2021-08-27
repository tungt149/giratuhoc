package com.tuhocgira.role.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tuhocgira.common.entity.BaseEntity;

@Entity
@Table(name = "gira_role")
public class Role extends BaseEntity {

	@NotNull
	@Size(min = 3, max = 50)
	@Column(unique = true)
	private String name;
	private String description;

	@ManyToMany(mappedBy = "roles")
	private Set<Group> groups = new HashSet<>();

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE },fetch = FetchType.LAZY)
	@JoinTable(name = "gira_role_program", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "program_id"))
	private Set<Program> programs = new HashSet<>();

	public void addProgram(Program program) {
		this.programs.add(program);
		program.getRoles().add(this);

	}

	public void removeProgram(Program program) {
		this.programs.remove(program);
		program.getRoles().remove(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public Set<Program> getPrograms() {
		return programs;
	}

	public void setPrograms(Set<Program> programs) {
		this.programs = programs;
	}
}
