package com.tuhocgira.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tuhocgira.role.entity.Program;
@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {

}
