package com.motus.assosuite.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.motus.assosuite.security.AuthorizationJwtFilter;
import com.motus.assosuite.service.AdminService;

@Configuration
public class SecurityContext {
	
	@Autowired
	private AdminService adminService;
	
	@Bean
	public AuthorizationJwtFilter filter() {
		return new AuthorizationJwtFilter(adminService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
