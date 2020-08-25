package com.motus.assosuite.rest;

import org.springframework.http.ResponseEntity;

import com.motus.assosuite.api.exceptions.BusinessException;
import com.motus.assosuite.api.payloads.AuthDto;
import com.motus.assosuite.api.payloads.ChangePasswordDto;
import com.motus.assosuite.api.payloads.JwtResponse;
import com.motus.assosuite.models.Admin;

public interface AuthenticationRestController {

	ResponseEntity<JwtResponse> authenticateJwt(AuthDto admin) throws BusinessException;
	
	ResponseEntity<Admin> changePassword(ChangePasswordDto change) throws BusinessException;

}
