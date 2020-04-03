package com.motus.assosuite.service.impl;

import org.springframework.stereotype.Service;

import com.motus.assosuite.models.Admin;
import com.motus.assosuite.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

	@Override
	public String authenticateJwt(Admin admin) {
		return null;
	}

}
