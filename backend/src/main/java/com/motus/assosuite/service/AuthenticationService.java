package com.motus.assosuite.service;

import com.motus.assosuite.models.Admin;

public interface AuthenticationService {
	
	String authenticateJwt(Admin admin);

}
