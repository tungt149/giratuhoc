package com.tuhocgira.sercurity.jwt;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JwtUntil {
	private static final Logger LOGGER = LoggerFactory.getLogger(Jwts.class);
	private Long JwtExpiration = 86400000L;
	private String jwtSecret = "thisismysecrettoken";
	private String authHeader = "Autorization";
	private String tokenPrefix = "Bearer";

	public String generateJwtToken(Authentication authentication) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		Date now = new Date();

		return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(now)
				.setExpiration(new Date(now.getTime() + JwtExpiration)).signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}

	public boolean validateJwtToken(String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parse(token);

		} catch (SignatureException e1) {
			LOGGER.error("Ivalid JWT signature: {}", e1.getMessage());

		} catch (ExpiredJwtException e2) {
			LOGGER.error("JWT token is expired: {}", e2.getMessage());

		} catch (MalformedJwtException e3) {
			LOGGER.error("Ivalid JWT Token: {}", e3.getMessage());

		} catch (IllegalArgumentException e4) {
			LOGGER.error("JWT claims string is empty {}", e4.getMessage());

		} catch (UnsupportedJwtException e5) {
			LOGGER.error("JWR token is not support", e5.getMessage());
		}

		return false;
	}

	public String getJwtTokenFromRequest(HttpServletRequest request) {
		String header = request.getHeader(authHeader);
		if (StringUtils.hasText(header) && header.startsWith(tokenPrefix))
			return header.substring(tokenPrefix.length(), header.length());

		return null;
	}
}
