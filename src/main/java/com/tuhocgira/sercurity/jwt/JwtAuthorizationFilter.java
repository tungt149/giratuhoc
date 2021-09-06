package com.tuhocgira.sercurity.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Jwts;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {
	private final JwtUntil jwtUtil;
	private final UserDetailsService userDetailsService;
	private static final Logger LOGGER = LoggerFactory.getLogger(Jwts.class);

	
	public JwtAuthorizationFilter(JwtUntil jwtUntil, UserDetailsService service) {
		jwtUtil = jwtUntil;
		userDetailsService = service;
	}
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// authorize the request before 
		try {
			String token = jwtUtil.getJwtTokenFromRequest(request);
			
			if(token != null && jwtUtil.validateJwtToken(token)) {
				String username = jwtUtil.getUsernameFromToken(token);
				
				// authorize
				
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				Authentication auth = new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());
				
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		} catch (Exception e) {
			LOGGER.debug("An unathorized request has been sent from {}.", request.getRemoteAddr());
		}
		
		filterChain.doFilter(request, response);
		// do after
	}

}
