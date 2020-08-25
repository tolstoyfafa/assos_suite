package com.motus.assosuite.service;

import com.motus.assosuite.api.exceptions.BusinessException;
import com.motus.assosuite.api.payloads.AuthDto;
import com.motus.assosuite.api.payloads.ChangePasswordDto;
import com.motus.assosuite.models.Admin;

public interface AuthenticationService {

	String authenticateJwt(AuthDto admin) throws BusinessException;

	Admin changePassword(ChangePasswordDto change) throws BusinessException;

}
