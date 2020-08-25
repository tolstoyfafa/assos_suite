package com.motus.assosuite.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motus.assosuite.api.exceptions.BusinessException;
import com.motus.assosuite.enums.AssosBusinessErrorCode;
import com.motus.assosuite.models.Admin;
import com.motus.assosuite.repository.AdminRepository;
import com.motus.assosuite.service.AdminService;

/**
 * Service that provide admin information for authentication
 * 
 * @author fbordjah
 *
 */
@Service
public class AdminServiceImpl implements AdminService {


	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private final AdminRepository repository;

	@Autowired
	public AdminServiceImpl(AdminRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public boolean found(String username) throws BusinessException {
		if (loadUserByUsername(username) != null) {
			return true;
		}
		return false;
	}

	protected Admin getAdmin(String uuid) {
		return repository.findByUuid(uuid);
	}
	
	@Override
	public Admin update(Admin admin) throws BusinessException {
		
		return repository.save(admin);
	}

	@Override
	public Admin loadUserByUsername(String username) throws BusinessException {
		Admin admin = repository.findByMail(username);
		if (admin == null) {
			throw new BusinessException("Admin not found", AssosBusinessErrorCode.ADMIN_NOT_FOUND);
		}
		return admin;
	}

}
