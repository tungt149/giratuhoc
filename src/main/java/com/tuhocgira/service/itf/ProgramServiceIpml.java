package com.tuhocgira.service.itf;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tuhocgira.dto.CreateProgramDto;
import com.tuhocgira.dto.ProgramDto;
import com.tuhocgira.role.entity.Program;
import com.tuhocgira.role.repository.ProgramRepository;
import com.tuhocgira.service.ProgramService;

@Service
public class ProgramServiceIpml implements ProgramService {
	private ProgramRepository repository;

	public ProgramServiceIpml(ProgramRepository programRepository) {
		repository = programRepository;
	}

	@Override
	public List<ProgramDto> findAll() {

		return repository.findAllDto();
	}

	@Override
	public Program save(CreateProgramDto dto) {
		Program program = new Program();
		program.setName(dto.getName());
		program.setMethod(dto.getMethods());
		program.setPath(dto.getPath());
		return repository.save(program);
	}

}
