package com.motus.assosuite.service.impl;

import java.util.Arrays;
import java.util.List;

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
	private List<RoleType> roles = Arrays.asList(RoleType.SUPERADMIN);
	private String password;

	@Autowired
	public AdminServiceImpl(AdminRepository repository) {
		this.repository = repository;
	}

	@Override
	public void init() {
		logger.info("======BEGIN INIT SERVICE WITH ADMIN CREDENTIALS======\n"
				+ "==========================================");
		if (repository.findByMail(adminMail) == null) {
			logger.info("======= Saving admin credentials ...");
			repository.save(new Admin(adminMail, roles));
		} else {
			logger.info("ADMIN EVENS EXISTS NO NEED TO INIT");
		}
		logger.info("======END INIT SERVICE WITH ADMIN CREDENTIALS\n"
				+ "==========================================");
	}

	protected Admin getAdmin(String uuid) {
		return repository.findByUuid(uuid);
	}
}
