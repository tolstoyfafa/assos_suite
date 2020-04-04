package com.motus.assosuite.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.motus.assosuite.api.exceptions.BusinessException;
import com.motus.assosuite.models.Admin;

public interface AdminService extends UserDetailsService {

	Admin loadUserByUsername(String username) throws BusinessException ;

	
}
