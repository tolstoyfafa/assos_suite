package com.motus.assosuite.service;

import com.motus.assosuite.api.payloads.AuthDto;

public interface AuthenticationService {
	
	String authenticateJwt(AuthDto admin);

}
