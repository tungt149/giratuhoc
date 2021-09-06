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

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tuhocgira.common.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"groups","programs"})
@EqualsAndHashCode(exclude = {"groups","programs"},callSuper = false)
@Entity
@Table(name = "gira_role")
public class Role extends BaseEntity {

	@NotNull
	@Size(min = 3, max = 50)
	@Column(unique = true)
	private String name;
	private String description;

	@ManyToMany(mappedBy = "roles")
	@JsonIgnore
	@Builder.Default
	private Set<Group> groups = new HashSet<>();

	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE },fetch = FetchType.LAZY)
	@JoinTable(name = "gira_role_program", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "program_id"))
	@JsonIgnore
	@Builder.Default
	private Set<Program> programs = new HashSet<>();

	public void addProgram(Program program) {
		this.programs.add(program);
		program.getRoles().add(this);

	}

	public void removeProgram(Program program) {
		this.programs.remove(program);
		program.getRoles().remove(this);
	}

	
}
