package com.motus.assosuite.service.impl;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motus.assosuite.enums.RoleType;
import com.motus.assosuite.models.Admin;
import com.motus.assosuite.repository.AdminRepository;
import com.motus.assosuite.service.InitService;

@Service
public class InitServiceImpl implements InitService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private final AdminRepository repository;

	private final String ADMIN_MAIL = "adminstrator@assosuite.com";
	private final List<RoleType> ROLES = Arrays.asList(RoleType.SUPERADMIN);
	// BCrypt online for init with default password
	// https://www.browserling.com/tools/bcrypt rounds = 10
	// password raw : secret@!
	private final String PASSWORD = "$2a$10$jWfcFFxseSquT7vUp9a8GeEUwEDvDBna3Wcw5LF6FtgT3gx.2nfDG";

	@Autowired
	public InitServiceImpl(AdminRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void init() {
		logger.info("======BEGIN INIT SERVICE WITH ADMIN CREDENTIALS======\n"
				+ "==========================================");
		if (repository.findByMail(ADMIN_MAIL) == null) {
			logger.info("======= Saving admin credentials ...");
			repository.save(new Admin(ADMIN_MAIL, PASSWORD, ROLES));
		} else {
			logger.info("ADMIN EVENS EXISTS NO NEED TO INIT");
		}
		logger.info("======END INIT SERVICE WITH ADMIN CREDENTIALS\n" + "==========================================");
	}

}
