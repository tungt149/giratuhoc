package com.tuhocgira.role.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tuhocgira.dto.ProgramDto;
import com.tuhocgira.role.entity.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {
	
	@Transactional(readOnly = true)
	@Query("SELECT p FROM Program p")
	List<ProgramDto> findAllDto();
}
