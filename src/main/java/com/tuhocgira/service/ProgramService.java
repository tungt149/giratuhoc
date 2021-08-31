package com.tuhocgira.service;

import java.util.List;



import com.tuhocgira.dto.CreateProgramDto;
import com.tuhocgira.dto.ProgramDto;
import com.tuhocgira.role.entity.Program;

public interface ProgramService {

	List<ProgramDto> findAll();

	Program save(CreateProgramDto dto) ;

	boolean isExistId(Long programId);
	
	

}