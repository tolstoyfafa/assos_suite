package com.motus.assosuite.rest;

import org.springframework.http.ResponseEntity;

import com.motus.assosuite.api.exceptions.BusinessException;
import com.motus.assosuite.api.payloads.AuthDto;
import com.motus.assosuite.models.Admin;

public interface AuthenticationRestController {

	ResponseEntity<String> authenticateJwt(AuthDto admin) throws BusinessException;

}
