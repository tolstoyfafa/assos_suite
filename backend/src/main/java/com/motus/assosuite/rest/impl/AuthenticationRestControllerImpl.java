package com.motus.assosuite.rest.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motus.assosuite.api.exceptions.BusinessException;
import com.motus.assosuite.api.payloads.AuthDto;
import com.motus.assosuite.api.payloads.JwtResponse;
import com.motus.assosuite.rest.AuthenticationRestController;
import com.motus.assosuite.service.AuthenticationService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/assosuite/api/v1/authentication")
public class AuthenticationRestControllerImpl implements AuthenticationRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationRestControllerImpl.class);

	private final AuthenticationService service;

	@Autowired
	public AuthenticationRestControllerImpl(AuthenticationService service) {
		super();
		this.service = service;
	}

	@PostMapping(path = "/authenticate",
			consumes = { MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Create JWT to authenticate admin")
	@Override
	public ResponseEntity<JwtResponse> authenticateJwt(@RequestBody AuthDto admin) throws BusinessException {
		String token = service.authenticateJwt(admin);
		
		return new ResponseEntity<>(new JwtResponse(token), HttpStatus.OK);
	}

}
