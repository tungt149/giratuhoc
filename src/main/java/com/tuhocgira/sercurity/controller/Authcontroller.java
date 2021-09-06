package com.tuhocgira.sercurity.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuhocgira.common.util.ResponseHandler;
import com.tuhocgira.sercurity.dto.LoginDto;
import com.tuhocgira.sercurity.jwt.JwtUntil;

import io.jsonwebtoken.Jwts;

@RestController
@RequestMapping("/api/auth")
public class Authcontroller {
	private final AuthenticationManager authenticationManager;
	private final JwtUntil jwtUtil;
	private static final Logger LOGGER = LoggerFactory.getLogger(Jwts.class);

	public Authcontroller(AuthenticationManager authManager, JwtUntil jwtUtil) {
		authenticationManager = authManager;
		this.jwtUtil = jwtUtil;
	}

	@PostMapping("/login")
	public Object Login(@Valid @RequestBody LoginDto dto, BindingResult errors) {
		if (errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
		Authentication auth = null;
		try {
			auth = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(auth);
			String token = jwtUtil.generateJwtToken(auth);
			return ResponseHandler.getResponse(token, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.debug("{} has been logged in with wrong password: {}", dto.getUsername(), dto.getPassword());
		}

		return ResponseHandler.getResponse("Username or password is invalid",HttpStatus.BAD_REQUEST);

	}
}
