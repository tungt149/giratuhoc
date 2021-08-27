package com.tuhocgira.service.itf;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.tuhocgira.dto.AddProgramDto;
import com.tuhocgira.dto.CreateRoleDto;
import com.tuhocgira.dto.RoleDto;
import com.tuhocgira.role.entity.Program;
import com.tuhocgira.role.entity.Role;
import com.tuhocgira.role.repository.ProgramRepository;
import com.tuhocgira.role.repository.RoleRepository;
import com.tuhocgira.service.RoleService;

@Service
public class RoleServiceIpml implements RoleService {
	private RoleRepository repository;
	private ProgramRepository programRepository;

	public RoleServiceIpml(RoleRepository roleRepository, ProgramRepository programRepository) {
		repository = roleRepository;
		this.programRepository = programRepository;
	}

	@Override
	public List<RoleDto> findAll() {

		return repository.findAllDto();
	}

	@Override
	public Role addNewRole(CreateRoleDto dto) {
		Role newRole = new Role();
		newRole.setName(dto.getName());
		newRole.setDescription(dto.getDescription());
		return repository.save(newRole);
	}

	@Override
	public Role addProgram(@Valid AddProgramDto dto) {
		Role role = repository.getById(dto.getRoleId());
		Program program = programRepository.getById(dto.getProgramId());
		role.addProgram(program);
		return repository.save(role);
	}

}
