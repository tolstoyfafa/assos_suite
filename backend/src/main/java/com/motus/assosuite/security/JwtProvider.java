package com.motus.assosuite.security;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import com.motus.assosuite.enums.RoleType;
import com.motus.assosuite.models.Admin;
import com.sun.security.auth.UserPrincipal;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtProvider {

	private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);

	private final String ROLES_KEY = "roles";

	@Value("${app.jwtSecret}")
	private String jwtSecret;

	@Value("${app.jwtExpirationInMs}")
	private long jwtExpirationInMs;
	
	public String generateToken(Authentication authentication, List<RoleType> roles) {
		logger.info("===================>>> Generating JWT TOKEN FOR ... {}", authentication.getName());
		long now = new Date().getTime();
		Admin admin = (Admin) authentication.getPrincipal();
		Claims claims = Jwts.claims();
		claims.setSubject(admin.getMail());
		claims.put(ROLES_KEY, admin.getAuthorities());
		claims.setIssuedAt(new Date());
		claims.setIssuer("ASSOSUITE_ISSUER");
		claims.setExpiration( new Date(now + jwtExpirationInMs));
		return Jwts.builder().setClaims(claims).compact();
	}

}
