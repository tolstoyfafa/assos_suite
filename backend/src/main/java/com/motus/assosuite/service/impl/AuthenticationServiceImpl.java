package com.motus.assosuite.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.motus.assosuite.api.exceptions.BusinessException;
import com.motus.assosuite.api.payloads.AuthDto;
import com.motus.assosuite.enums.AssosBusinessErrorCode;
import com.motus.assosuite.models.Admin;
import com.motus.assosuite.security.JwtUtils;
import com.motus.assosuite.service.AdminService;
import com.motus.assosuite.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final AuthenticationManager authenticationManager;

	private final AdminService adminService;
	
	private JwtUtils utils;

	@Autowired
	public AuthenticationServiceImpl(AuthenticationManager authenticationManager, AdminService adminService) {
		super();
		this.authenticationManager = authenticationManager;
		this.adminService = adminService;
	}

	@Override
	public String authenticateJwt(AuthDto admin) {
		logger.info("Admin attempting to sign in");
		
		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(admin.getMail(), admin.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch (BadCredentialsException e) {
			throw new BusinessException("You have set a bad credentials for administrator", AssosBusinessErrorCode.ADMIN_BAD_CREDENTIALS); 
		}
		return utils.generateToken(adminService.loadUserByUsername(admin.getMail()));
	}

}
