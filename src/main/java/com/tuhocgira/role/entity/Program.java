package com.tuhocgira.role.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tuhocgira.common.entity.BaseEntity;
import com.tuhocgira.role.util.HttpMethods;

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
@ToString(exclude = {"roles"})
@EqualsAndHashCode(exclude = {"roles"},callSuper = false)
@Entity
@Table(name = "gira_program")
public class Program extends BaseEntity {

	@NotNull
	@Column(unique = true)
	@Size(min = 3, max = 50, message = "{program.name.size}")
	private String name;

	@NotNull
	private HttpMethods method;
	@NotNull
	private String path;

	@ManyToMany(mappedBy = "programs",fetch = FetchType.LAZY)
	@JsonIgnore
	@Builder.Default
	public Set<Role> roles = new HashSet<>();

}

	