package com.motus.assosuite.security;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.motus.assosuite.models.Admin;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {

	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	private final String ROLES_KEY = "roles";

	@Value("${app.jwtSecret}")
	private String jwtSecret;

	@Value("${app.jwtExpirationInMs}")
	private long jwtExpirationInMs;

	@Value("${app.audiance}")
	private String audiance;

	@Value("${app.issuer}")
	private String issuer;

	public String generateToken(Admin admin) {
		logger.info("Generating JWT TOKEN FOR ... {}", admin.getName());
		long now = new Date().getTime();
		Claims claims = Jwts.claims();
		claims.setSubject(admin.getMail());
		claims.put(ROLES_KEY, admin.getAuthorities());
		claims.setIssuedAt(new Date());
		claims.setIssuer(issuer);
		claims.setExpiration(new Date(now + jwtExpirationInMs));
		return Jwts.builder().setClaims(claims)
				.signWith(Keys.hmacShaKeyFor(jwtSecret.getBytes()), SignatureAlgorithm.HS512).compact();
	}

	/**
	 * recover the Admin mail from the decoded token
	 * 
	 * @param token
	 * @return
	 */
	public String getMail(String token) {
		Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(jwtSecret.getBytes())).build()
				.parseClaimsJws(token);
		return claims.getBody().getSubject();
	}
	
	public Date getExpiration(String token) {
		Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(jwtSecret.getBytes())).build()
				.parseClaimsJws(token);
		return claims.getBody().getExpiration();
	}

}
