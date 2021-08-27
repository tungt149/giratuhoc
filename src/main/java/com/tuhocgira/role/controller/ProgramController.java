package com.tuhocgira.role.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.tuhocgira.common.util.ResponseHandler;
import com.tuhocgira.dto.CreateProgramDto;
import com.tuhocgira.dto.ProgramDto;
import com.tuhocgira.role.entity.Program;
import com.tuhocgira.service.ProgramService;

@RestController
@RequestMapping("/api/program")
public class ProgramController {
	private ProgramService service;

	public ProgramController(ProgramService programService) {
		service = programService;
	}

	@GetMapping
	public Object findAllProgram() {
		List<ProgramDto> programs = service.findAll();
		return ResponseHandler.getResponse(programs, HttpStatus.OK);
	}

	@PostMapping
	public Object saveProgram(@Valid @RequestBody CreateProgramDto dto,BindingResult errors) {
		if(errors.hasErrors())
			return ResponseHandler.getResponse(HttpStatus.BAD_REQUEST);
		Program newprogram = service.save(dto);
		
		return ResponseHandler.getResponse(newprogram, HttpStatus.CREATED);
	}

}
