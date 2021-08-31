package com.tuhocgira.service.itf;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.tuhocgira.dto.AddRoleDto;
import com.tuhocgira.dto.CreateGroupDto;
import com.tuhocgira.dto.CreateRoleDto;
import com.tuhocgira.dto.GroupDto;
import com.tuhocgira.role.entity.Group;
import com.tuhocgira.role.entity.Role;
import com.tuhocgira.role.repository.GroupRepository;
import com.tuhocgira.role.repository.RoleRepository;
import com.tuhocgira.service.GroupService;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {
	private GroupRepository repository;
	private RoleRepository roleRepository;

	public GroupServiceImpl(GroupRepository groupRepository, RoleRepository roleRepository) {
		repository = groupRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public List<GroupDto> findAll() {

		return repository.findAllDto();
	}

	@Override
	public boolean isTakenName(String roleName) {
		return repository.countByName(roleName.toUpperCase()) >= 1;

	}

	@Override
	public Group addNewGroup(CreateGroupDto dto) {
		Group group = new Group();
		group.setName(dto.getName());
		group.setDescription(dto.getDescription());

		return repository.save(group);
	}

	@Override
	public Group addNewRole(@Valid AddRoleDto dto) {
		Group group = repository.getById(dto.getRoleId());
		Role role = roleRepository.getById(dto.getGroupId());
		group.addRole(role);
		return repository.save(group);
	}

}
