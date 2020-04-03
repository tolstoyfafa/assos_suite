package com.motus.assosuite.service.impl;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.motus.assosuite.enums.RoleType;
import com.motus.assosuite.models.Admin;
import com.motus.assosuite.repository.AdminRepository;
import com.motus.assosuite.service.AdminService;

/**
 * Service that provide admin information for authentication
 * 
 * @author fbordjah
 *
 */
public class AdminServiceImpl implements AdminService {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private final AdminRepository repository;

	@Autowired
	public AdminServiceImpl(AdminRepository repository) {
		this.repository = repository;
	}

	protected Admin getAdmin(String uuid) {
		return repository.findByUuid(uuid);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repository.findByMail(username);
	}

}
