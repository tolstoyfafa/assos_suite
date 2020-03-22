package com.motus.assosuite.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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

	private String adminMail = "adminstrator@assosuite.com";
	private String password;

	@Autowired
	public AdminServiceImpl(AdminRepository repository) {
		this.repository = repository;
	}

	@Override
	public void init() {
		logger.info("======BEGIN INIT SERVICE OF ADMIN");

		repository.save(new Admin(adminMail, RoleType.SUPERADMIN));
		logger.info("======END INIT SERVICE OF ADMIN");
	}

	protected Admin getAdmin() {
		return repository.findByUuid();
	}
}
