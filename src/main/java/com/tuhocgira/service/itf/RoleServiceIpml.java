package com.tuhocgira.service.itf;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tuhocgira.dto.CreateRoleDto;
import com.tuhocgira.repository.RoleRepository;
import com.tuhocgira.role.entity.Role;
import com.tuhocgira.service.RoleService;

@Service
public class RoleServiceIpml implements RoleService {
	private RoleRepository repository;

	public RoleServiceIpml(RoleRepository roleRepository) {
		repository = roleRepository;
	}

	@Override
	public List<Role> findAll() {

		return repository.findAll();
	}

	@Override
	public Role addNewRole(CreateRoleDto dto) {
		Role newRole = new Role();
		newRole.setName(dto.getName());
		newRole.setDescription(dto.getDescription());
		return repository.save(newRole);
	}

}
